package com.jesus.truck.inspect.dao;

import com.github.pagehelper.PageInfo;
import com.jesus.truck.inspect.po.MiningTruckInfo;
import com.jesus.truck.inspect.vo.MiningTruckInfoVo;
import com.jesus.truck.inspect.vo.MiningTruckQueryCondition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MiningTruckInfoDao {

    void truckInfoSave(MiningTruckInfo miningTruckInfo);

    List<MiningTruckInfoVo> queryAll(MiningTruckQueryCondition queryCondition);
}
