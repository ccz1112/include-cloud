package com.include.system.controller;

import com.alibaba.fastjson.JSON;
import com.include.comm.entity.IncludePhrase;
import com.include.comm.entity.IncludeRole;
import com.include.comm.entity.R;
import com.include.system.service.IIncludePhraseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author: chenshuo
 * @Date: 2023-08-08
 * @Time: 14:00
 * @version： 1.0
 * @Description:
 **/
@RestController
@RequestMapping("includePhrase")
@Slf4j
public class IncludePhraseController {

    private final IIncludePhraseService includePhraseService;

    public IncludePhraseController(IIncludePhraseService includePhraseService) {
        this.includePhraseService = includePhraseService;
    }

    @PostMapping("insertPhrase")
    public R<?> insertPhrase(@RequestBody IncludePhrase includePhrase){
        log.info("insertPhrase data = {}", JSON.toJSONString(includePhrase));
        return includePhraseService.save(includePhrase);
    }
    @GetMapping("demo")
    public R<?> demo(){
        log.info("insertPhrase data = {}");
        return R.oK();
    }


}