package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.BaseCategory2;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 24440
* @description 针对表【base_category2(二级分类表)】的数据库操作Service
* @createDate 2022-08-23 00:06:06
*/
public interface BaseCategory2Service extends IService<BaseCategory2> {

    List<BaseCategory2> getCateGory2(Long category1Id);
}
