package com.include.order.service;

import com.include.comm.entity.IncludeOrder;
import com.include.comm.entity.R;

/**
 * @author: chenshuo
 * @Date: 2022-11-22
 * @Time: 13:41
 * @version： 1.0
 * @Description:
 **/
public interface IIncludeOrderService {

    R getList(IncludeOrder includeOrder);

    R getInfo(Integer id);

    R saveOrder(IncludeOrder includeOrder);
}