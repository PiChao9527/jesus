package com.jesus.truck.inspect.controller;

import com.jesus.truck.inspect.service.MiningTruckService;
import com.jesus.truck.inspect.vo.MiningTruckQueryCondition;
import com.jesus.truck.inspect.vo.ResBean;
import io.swagger.annotations.ApiOperation;
import com.jesus.truck.inspect.vo.MiningTruckInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/truck")
@ResponseBody
public class MinningTruckController {

    @Autowired
    private MiningTruckService miningTruckService;

    @ApiOperation("卡车信息上传")
    @RequestMapping(path = "/truckInfoSave", method = RequestMethod.POST)
    public ResBean<MiningTruckInfoVo> truckInfoSave(@RequestBody MiningTruckInfoVo truckInfoVo) {
        return miningTruckService.truckInfoSave(truckInfoVo);
    }

    @ApiOperation("列表查询")
    @RequestMapping(path = "/queryAll", method = RequestMethod.POST)
    public ResBean<List<MiningTruckInfoVo>> queryAll(@RequestBody MiningTruckQueryCondition queryCondition) {
        return miningTruckService.queryAll(queryCondition);
    }

}
