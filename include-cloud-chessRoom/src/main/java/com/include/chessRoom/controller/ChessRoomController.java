package com.include.chessRoom.controller;

import com.include.chessRoom.service.IIncludePokerService;
import com.include.comm.entity.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: chenshuo
 * @Date: 2023-02-13
 * @Time: 17:15
 * @version： 1.0
 * @Description:
 **/
@RestController
@RequestMapping("poker")
@Slf4j
public class ChessRoomController {

    @Autowired
    private IIncludePokerService includePokerService;


    @RequestMapping("init")
    public R init(){
        return includePokerService.initPoker(4);
    }
}