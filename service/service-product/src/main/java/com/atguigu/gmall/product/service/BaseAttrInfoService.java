package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 24440
* @description 针对表【base_attr_info(属性表)】的数据库操作Service
* @createDate 2022-08-24 11:21:45
*/
public interface BaseAttrInfoService extends IService<BaseAttrInfo> {

    List<BaseAttrInfo> getBaseAttrInfoList(Long category1Id, Long category2Id, Long category3Id);

    void saveAttrInfo(BaseAttrInfo baseAttrInfo);
}
