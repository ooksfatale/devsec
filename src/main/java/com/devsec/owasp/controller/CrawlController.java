package com.devsec.owasp.controller;

import com.devsec.owasp.service.crawl.CrawlService;
import lombok.extern.slf4j.Slf4j;
import org.apache.jasper.tagplugins.jstl.core.Url;
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

    /* 크롤링 */
    @PostMapping("/crawl")
    public String crawling(@RequestParam Map<String, String> params, ModelMap model) throws Exception{
        try{

            String URL = params.get("scanUrl");
            Document document = Jsoup.connect(URL).get();

            model.addAttribute("input",document.getElementsByTag("input"));
            model.addAttribute("html",document.html());
            model.addAttribute("body",document.body());
            model.addAttribute("head",document.head());
            model.addAttribute("title",document.title());
            model.addAttribute("text",document.text());
        }catch (Exception e){

        }
        return "crawl/crawl_result";
    }

}

