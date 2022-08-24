package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.atguigu.gmall.model.product.BaseAttrValue;
import com.atguigu.gmall.product.service.BaseAttrInfoService;
import com.atguigu.gmall.product.service.BaseAttrValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/product")
public class BaseAttrInfoController {

    @Autowired
    private BaseAttrInfoService baseAttrInfoService;
    @Autowired
    private BaseAttrValueService baseAttrValueService;
    /**
     * 根据分类Id获取平台属性
     * @param category1Id
     * @param category2Id
     * @param category3Id
     * @return
     */
    @GetMapping("/attrInfoList/{category1Id}/{category2Id}/{category3Id}")
    public Result getBaseAttrInfo(@PathVariable("category1Id") Long category1Id,
                                  @PathVariable("category2Id") Long category2Id,
                                  @PathVariable("category3Id") Long category3Id){
        List<BaseAttrInfo> list = baseAttrInfoService.getBaseAttrInfoList(category1Id,category2Id,category3Id);
        return Result.ok(list);
    }

    /**
     * 根据id获取平台属性的值
     * @param attrId
     * @return
     */
    @GetMapping("/getAttrValueList/{attrId}")
    public Result getAttrValueList(@PathVariable("attrId") Long attrId){
        List<BaseAttrValue> list = baseAttrValueService.getAttrValueList(attrId);
        return Result.ok(list);
    }

    /**
     * 新增平台属性
     * @param baseAttrInfo
     * @return
     */
    @PostMapping("/saveAttrInfo")
    public Result saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo){
        baseAttrInfoService.saveAttrInfo(baseAttrInfo);
        return Result.ok();
    }

}
