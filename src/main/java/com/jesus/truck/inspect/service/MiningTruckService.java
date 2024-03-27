package com.jesus.truck.inspect.service;

import com.jesus.truck.inspect.vo.MiningTruckInfoVo;
import com.jesus.truck.inspect.vo.MiningTruckQueryCondition;
import com.jesus.truck.inspect.vo.ResBean;

import java.util.List;

public interface MiningTruckService {

    ResBean<MiningTruckInfoVo> truckInfoSave(MiningTruckInfoVo truckInfoVo);

    ResBean<List<MiningTruckInfoVo>> queryAll(MiningTruckQueryCondition queryCondition);
}
