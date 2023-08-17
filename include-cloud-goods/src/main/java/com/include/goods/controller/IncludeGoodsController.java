package com.include.goods.controller;

import com.include.comm.entity.IncludeGoodsSku;
import com.include.comm.entity.R;
import com.include.goods.service.IIncludeGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: chenshuo
 * @Date: 2022-11-22
 * @Time: 11:41
 * @version： 1.0
 * @Description:
 **/
@RestController
@RequestMapping("hotelssmi")
@Slf4j
public class IncludeGoodsController {

    private final IIncludeGoodsService includeGoodsService;

    @Autowired
    public IncludeGoodsController(IIncludeGoodsService includeGoodsService) {
        this.includeGoodsService = includeGoodsService;
    }

    @RequestMapping("getList")
    public R getList(@RequestBody IncludeGoodsSku includeGoodsSku){
        return includeGoodsService.getList(includeGoodsSku);
    }

    @RequestMapping("getInfo")
    public R getInfo(Integer id){
        return includeGoodsService.getInfo(id);
    }

    @RequestMapping("jnrz")
    public R getInfo(String token) throws InterruptedException {
        log.info("2222222");
        return R.oK();
    }
    @RequestMapping("getToken")
    public R getToken(String token) throws InterruptedException {
        log.info("11111");
        Thread.sleep(50000);
        return R.oK();
    }

}