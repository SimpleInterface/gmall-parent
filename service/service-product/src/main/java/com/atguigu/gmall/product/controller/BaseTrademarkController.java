package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseTrademark;
import com.atguigu.gmall.product.service.BaseTrademarkService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/product/baseTrademark")
public class BaseTrademarkController {

    @Autowired
    private BaseTrademarkService baseTrademarkService;

    /**
     * 分页查询品牌信息
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/{page}/{limit}")
    public Result getBaseTrademarkList(@PathVariable("page") Long page,
                                       @PathVariable("limit") Long limit){
        Page<BaseTrademark> trademarkPage = new Page<>(page,limit);
        Page<BaseTrademark> baseTrademarkPage = baseTrademarkService.page(trademarkPage);
        return Result.ok(baseTrademarkPage);
    }

    /**
     * 根据id获取
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Result getBaseTrademarkById(@PathVariable("id") Long id){
        BaseTrademark baseTrademark = baseTrademarkService.getById(id);
        return Result.ok(baseTrademark);
    }

    /**
     * 修改品牌信息
     * @param baseTrademark
     * @return
     */
    @PutMapping("/update")
    public Result updateBaseTrademark(@RequestBody BaseTrademark baseTrademark){
        baseTrademarkService.updateById(baseTrademark);
        return Result.ok();
    }

    /**
     * 新增品牌信息
     * @param baseTrademark
     * @return
     */
    @PostMapping("/save")
    public Result saveBaseTrademark(@RequestBody BaseTrademark baseTrademark){
        baseTrademarkService.save(baseTrademark);
        return Result.ok();
    }

    /**
     * 删除品牌信息
     * @param id
     * @return
     */
    @DeleteMapping("/remove/{id}")
    public Result removeBaseTrademark(@PathVariable("id") Long id){
        baseTrademarkService.removeById(id);
        return Result.ok();
    }
}
