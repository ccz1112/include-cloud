package com.include.goods.service;


import com.include.comm.entity.IncludeGoodsSku;
import com.include.comm.entity.R;

/**
 * @projectName include-cloud-common
 * @packageName com.include.service
 * @className IIncludeGoodsService
 * @author： chenshuo
 * @version： 1.0
 * @since： 2022-11-22 11:43
 */
public interface IIncludeGoodsService {

    R getList(IncludeGoodsSku includeGoodsSku);

    R getInfo(Integer id);
}
