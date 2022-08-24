package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.BaseCategory2;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gmall.product.service.BaseCategory2Service;
import com.atguigu.gmall.product.mapper.BaseCategory2Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author 24440
* @description 针对表【base_category2(二级分类表)】的数据库操作Service实现
* @createDate 2022-08-23 00:06:06
*/
@Service
public class BaseCategory2ServiceImpl extends ServiceImpl<BaseCategory2Mapper, BaseCategory2>
    implements BaseCategory2Service{
    @Resource
    BaseCategory2Mapper baseCategory2Mapper;
    @Override
    public List<BaseCategory2> getCateGory2(Long category1Id) {
        QueryWrapper<BaseCategory2> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("category1_id",category1Id);
        return baseCategory2Mapper.selectList(queryWrapper);
    }
}




