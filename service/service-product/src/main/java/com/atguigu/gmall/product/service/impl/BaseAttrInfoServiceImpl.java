package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.atguigu.gmall.model.product.BaseAttrValue;
import com.atguigu.gmall.product.mapper.BaseAttrValueMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gmall.product.service.BaseAttrInfoService;
import com.atguigu.gmall.product.mapper.BaseAttrInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 24440
 * @description 针对表【base_attr_info(属性表)】的数据库操作Service实现
 * @createDate 2022-08-24 11:21:45
 */
@Service
public class BaseAttrInfoServiceImpl extends ServiceImpl<BaseAttrInfoMapper, BaseAttrInfo>
        implements BaseAttrInfoService {

    @Resource
    private BaseAttrInfoMapper baseAttrInfoMapper;

    @Resource
    private BaseAttrValueMapper baseAttrValueMapper;

    /**
     * 根据分类Id获取平台属性
     *
     * @return
     */
    @Override
    public List<BaseAttrInfo> getBaseAttrInfoList(Long category1Id, Long category2Id, Long category3Id) {
        List<BaseAttrInfo> baseAttrInfoList = baseAttrInfoMapper.getBaseInfoAndValue(category1Id, category2Id, category3Id);
        return baseAttrInfoList;
    }

    /**
     * 添加平台属性
     *
     * @param baseAttrInfo
     */
    @Override
    public void saveAttrInfo(BaseAttrInfo baseAttrInfo) {
        if (baseAttrInfo.getId() == null) {
            //进行属性新增操作
            addAttrInfo(baseAttrInfo);
        } else {
            //进行属性修改操作
            updateBaseAttrInfo(baseAttrInfo);
        }
    }

    private void updateBaseAttrInfo(BaseAttrInfo baseAttrInfo) {
        //2.1该属性名信息
        baseAttrInfoMapper.updateById(baseAttrInfo);

        List<BaseAttrValue> attrValueList = baseAttrInfo.getAttrValueList();
        //先删除，前端提交来的所有属性值id
        List<Long> vids = new ArrayList<>();
        for (BaseAttrValue value : attrValueList) {
            Long id = value.getId();
            if (vids != null) {
                vids.add(id);
            }
        }
        if (vids.size() > 0) {
            //部分删除
            QueryWrapper<BaseAttrValue> deleteWrapper = new QueryWrapper<>();
            deleteWrapper.eq("attr_id", baseAttrInfo.getId());
            deleteWrapper.notIn("id", vids);
            baseAttrValueMapper.delete(deleteWrapper);
        } else {
            //全部删除
            QueryWrapper<BaseAttrValue> deleteWrapper = new QueryWrapper<>();
            deleteWrapper.eq("attr_id", baseAttrInfo.getId());
            baseAttrValueMapper.delete(deleteWrapper);
        }


        for (BaseAttrValue value : attrValueList) {
            //修改属性值
            if (value.getId() != null) {
                //属性值又id，说明数据库以前有，此次只需要修改即可
                baseAttrValueMapper.updateById(value);
            }
            if (value.getId() == null) {
                //说明数据库以前没有是新增
                value.setAttrId(baseAttrInfo.getId());
                baseAttrValueMapper.insert(value);
            }
        }
    }

    private void addAttrInfo(BaseAttrInfo baseAttrInfo) {
        baseAttrInfoMapper.insert(baseAttrInfo);

        Long id = baseAttrInfo.getId();

        List<BaseAttrValue> attrValueList = baseAttrInfo.getAttrValueList();

        for (BaseAttrValue value : attrValueList) {
            value.setAttrId(id);
            baseAttrValueMapper.insert(value);
        }
    }
}




