package com.devsec.owasp.service.crawl;

import com.devsec.owasp.mapper.CrawlMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CrawlServiceImpl implements CrawlService {

    @Autowired
    private CrawlMapper crawlMapper;
}
