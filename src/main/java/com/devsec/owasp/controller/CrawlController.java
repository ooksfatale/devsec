package com.devsec.owasp.controller;

import com.devsec.owasp.service.crawl.CrawlService;
import lombok.extern.slf4j.Slf4j;
import org.apache.jasper.tagplugins.jstl.core.Url;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Slf4j
@Controller
public class CrawlController {

    @Autowired
    CrawlService crawlService;

    /*게시글 목록*/
    @GetMapping("/crawl")
    public String crawlingForm(ModelMap model) throws Exception{
        try {
            String URL = "http://localhost:8085/board/free/write";
            Document document = Jsoup.connect(URL).get();
            log.debug("document : "+document.html());
            log.debug("document : "+document.title());
            log.debug("document : "+document.text());
            log.debug("document : "+document.getElementsByTag("input"));

            model.addAttribute("boardList", "asd");
            model.addAttribute("boardDto", "asd");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

}
