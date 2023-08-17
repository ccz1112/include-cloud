package com.include.comm.util;

import cn.hutool.core.lang.UUID;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Map;

/**
 * @author: chenshuo
 * @Date: 2022-06-10
 * @Time: 13:52
 * @version： 1.0
 * @Description:
 **/
public class ExcelUtils {

    /***
    * @param: [path, dataList, title, headerMap]
    * @methoName: excel
    * @return: void
    * @date: 2022-06-10 13:53
    * @author: cs
    * @Description:
    */
    public static void excel(String path, List dataList, String title, Map<String,String> headerMap) {
        //通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter(path+"/"+UUID.fastUUID().toString()+".xlsx");
        headerMap.entrySet().stream().forEach(res->{
            writer.addHeaderAlias(res.getKey(),  res.getValue());
        });
        BeanUtils.copyProperties(null,null);
        // 默认的，未添加alias的属性也会写出，如果想只写出加了别名的字段，可以调用此方法排除之
        writer.setOnlyAlias(true);
        // 合并单元格后的标题行，使用默认标题样式
        writer.merge(headerMap.size()-1, title);

        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(dataList, true);
        // 关闭writer，释放内存
        writer.close();
    }
}