package com.jesus.truck.inspect.service;

import com.github.pagehelper.PageHelper;
import com.jesus.truck.inspect.dao.MiningTruckInfoDao;
import com.jesus.truck.inspect.commom.exception.BusinessException;
import com.jesus.truck.inspect.po.MiningTruckInfo;
import com.jesus.truck.inspect.vo.MiningTruckQueryCondition;
import com.jesus.truck.inspect.vo.ResBean;
import com.jesus.truck.inspect.vo.MiningTruckInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class MiningTruckServiceImpl implements MiningTruckService{

    @Autowired
    private MiningTruckInfoDao miningTruckInfoDao;

    @Override
    public ResBean<MiningTruckInfoVo> truckInfoSave(MiningTruckInfoVo truckInfoVo) {
        ResBean<MiningTruckInfoVo> resBean = new ResBean<>();
        if (null == truckInfoVo) {
            throw new BusinessException(9999L, "参数错误。");
        }
        MiningTruckInfo miningTruckInfo = new MiningTruckInfo();
        BeanUtils.copyProperties(truckInfoVo, miningTruckInfo);
        miningTruckInfo.setCreateDate(new Date());
        miningTruckInfo.setModifyDate(new Date());
        miningTruckInfoDao.truckInfoSave(miningTruckInfo);
        return ResBean.success(truckInfoVo);
    }

    @Override
    public ResBean<List<MiningTruckInfoVo>> queryAll(MiningTruckQueryCondition queryCondition) {
        ResBean<List<MiningTruckInfoVo>> resBean = new ResBean<>();
        if (null == queryCondition) {
            throw new BusinessException(9999L, "参数错误。");
        }
        PageHelper.startPage(queryCondition.getPageNo(), queryCondition.getPageSize());
        if(!StringUtils.isEmpty(queryCondition.getOrderBy())){
            PageHelper.startPage(queryCondition.getPageNo(), queryCondition.getPageSize(), queryCondition.getOrderBy() + (StringUtils.isEmpty(queryCondition.getDirection()) ? " asc" : " desc"));
        }
        List<MiningTruckInfoVo> pageInfo = miningTruckInfoDao.queryAll(queryCondition);
        log.info("查询数量：{}", pageInfo.size());
        return ResBean.success(pageInfo);
    }
}
