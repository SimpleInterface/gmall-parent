package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.BaseAttrValue;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gmall.product.service.BaseAttrValueService;
import com.atguigu.gmall.product.mapper.BaseAttrValueMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author 24440
* @description 针对表【base_attr_value(属性值表)】的数据库操作Service实现
* @createDate 2022-08-24 11:21:44
*/
@Service
public class BaseAttrValueServiceImpl extends ServiceImpl<BaseAttrValueMapper, BaseAttrValue>
    implements BaseAttrValueService{

    @Resource
    private BaseAttrValueMapper baseAttrValueMapper;

    /**
     * 根据平台属性attrId获取平台属性的值
     * @param attrId
     * @return
     */
    @Override
    public List<BaseAttrValue> getAttrValueList(Long attrId) {
        QueryWrapper<BaseAttrValue> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("attr_id",attrId);
        List<BaseAttrValue> list = baseAttrValueMapper.selectList(queryWrapper);
        return list;
    }
}




