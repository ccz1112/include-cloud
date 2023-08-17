package com.include.chessRoom.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.include.chessRoom.service.IIncludePokerService;
import com.include.comm.entity.R;
import com.include.comm.entity.chessRoom.IncludePoker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author: chenshuo
 * @Date: 2023-02-13
 * @Time: 16:51
 * @version： 1.0
 * @Description:
 **/
@Service
@Slf4j
public class IncludePokerServiceImpl implements IIncludePokerService {


    private String[] color = new String[]{"♣","♥","♦","♠"};

    @Override
    public R initPoker(Integer num) {

        //定义几幅牌
        List<IncludePoker> list = new ArrayList<>();
        for(int i=0;i<num;i++){
            List<IncludePoker> infoList = new ArrayList<>();
            infoList = initPoker();
            list.addAll(infoList);
        }

        list = disorderPoker(list);
        log.info(JSON.toJSONString(list));
        return R.oK(JSON.toJSONString(list));
    }



    private Map<Integer,List<IncludePoker>> playPoker(Integer userId, List<IncludePoker> list){

        return null;
    }

    //初始化一副Poker
    private List<IncludePoker> initPoker(){
        List<IncludePoker> list = new ArrayList<>();
        for(int i=0;i<color.length;i++){
            for (int k = 3; k < 17; k++) {
                IncludePoker includePoker = new IncludePoker();
                includePoker.setVal(k);
                includePoker.setColour(color[i]);
                includePoker.setTogetherUp(0);
                list.add(includePoker);
            }
        }
        IncludePoker topKing = new IncludePoker();
        topKing.setVal(17);
        topKing.setTogetherUp(1);
        IncludePoker littleKing = new IncludePoker();
        littleKing.setVal(18);
        littleKing.setTogetherUp(1);
        //3,4,5,6,7,8,9,10,J,Q,K,A,2,DAWANG,XIAOWANG
        list.add(topKing);
        list.add(littleKing);
        return list;
    }

    //洗牌
    private List disorderPoker(List<IncludePoker> list) {
        for (int i = list.size(); i > 0; i--) {
            Random random = new Random();
            int j = random.nextInt(i);
            IncludePoker c = list.get(i-1);
            list.set(i-1,list.get(j));
            list.set(j,c);
        }
        return list;
    }


}