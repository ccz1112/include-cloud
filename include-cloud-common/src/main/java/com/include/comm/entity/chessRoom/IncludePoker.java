package com.include.comm.entity.chessRoom;

import lombok.Data;
import lombok.val;

/**
 * @author: chenshuo
 * @Date: 2023-02-13
 * @Time: 16:45
 * @version： 1.0
 * @Description:
 **/
@Data
public class IncludePoker {

    private Integer id;

    //花色
    private String colour;

    //数值
    private Integer val;

    //图形
    private String images;

    //1:可以一起,0:不可以
    private Integer togetherUp;

}
