package com.jesus.truck.inspect.vo;

import lombok.Data;

import java.util.Date;

@Data
public class MiningTruckQueryCondition extends BasePageQueryCondition{
    /**
     * 车牌号
     */
    private String truckLicense;

    /**
     * 车辆序号
     */
    private String truckNo;

    /**
     * 车体颜色
     */
    private String truckColor;

    /**
     * 拉运物料
     */
    private String transMaterial;

    /**
     * 车牌识别图
     */
    private String licensePhotoUrl;

    /**
     * 物料识别图
     */
    private String materialPhotoUrl;

    /**
     * 出井时间
     */
    private Date outTime;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改时间
     */
    private Date modifyDate;
}
