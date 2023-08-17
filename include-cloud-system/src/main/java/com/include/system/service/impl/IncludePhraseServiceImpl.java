package com.include.system.service.impl;

import cn.hutool.http.HttpUtil;
import com.hankcs.hanlp.dictionary.py.Pinyin;
import com.hankcs.hanlp.dictionary.py.PinyinDictionary;
import com.include.comm.entity.IncludePhrase;
import com.include.comm.entity.R;
import com.include.comm.util.IdWorker;
import com.include.system.mapper.IncludePhraseMapper;
import com.include.system.service.IIncludePhraseService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: chenshuo
 * @Date: 2023-08-08
 * @Time: 14:01
 * @version： 1.0
 * @Description:
 **/
@Service
public class IncludePhraseServiceImpl implements IIncludePhraseService {

    private final IncludePhraseMapper includePhraseMapper;

    private final RedisTemplate<String,String> redisTemplate;

    private final IdWorker idWorker;

    public IncludePhraseServiceImpl(IncludePhraseMapper includePhraseMapper, RedisTemplate<String, String> redisTemplate, IdWorker idWorker) {
        this.includePhraseMapper = includePhraseMapper;
        this.redisTemplate = redisTemplate;
        this.idWorker = idWorker;
    }

    @Override
    public R save(IncludePhrase includePhrase) {
        includePhrase.setRoomCode(idWorker.nextId()+"");
        includePhraseMapper.insert(includePhrase);
        return R.oK(includePhrase.getRoomCode());
    }

    @Override
    public R joinRoom(String roomCode) {
        return null;
    }

    @Override
    public R getPhrase(String params, String nextParams) {
        String lastChar = params.substring(params.length()-1,params.length());

        String firstChar = nextParams.substring(0,1);

        nextParams = nextParams.substring(0,4);
        //检测是否为成语
        String url = "https://chengyu.yw11.com/cy/"+params;
        String res = HttpUtil.get(url);
        if(res.contains("error")){
            return R.error("该词汇非成语,请重新提交");
        }

        Integer score = 0;
        //判断同字
        if(lastChar.equals(firstChar)){
            score = 3;
        }else{
            //对比读音
            List<Pinyin> paramsList = PinyinDictionary.convertToPinyin(params);
            List<Pinyin> nextList = PinyinDictionary.convertToPinyin(nextParams);
            //谐音1分
            score = 1;
            Pinyin paramsPinYin = paramsList.get(paramsList.size());
            Pinyin nextPinYin = nextList.get(0);
            if(nextPinYin.getPinyinWithToneMark().equals(paramsPinYin.getPinyinWithToneMark())){
                //同音2分
                score = 2;
            }

            //拼音也不同则重新提交
            if(nextPinYin.getPinyinWithoutTone().equals(paramsPinYin.getPinyinWithoutTone())){
                return R.error("该词汇不符合规则,请重新提交");
            }
        }

        Map<String,Object> map = new HashMap<>();
        map.put("score",score);
        map.put("nextParams",nextParams);


        return null;
    }
}