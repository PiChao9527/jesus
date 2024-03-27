package com.jesus.truck.inspect.po;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class MiningTruckInfo {

    /**
     * 主键
     */
    private BigDecimal id;

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

    /**
     * filed1
     */
    private String filed1;

    /**
     * filed2
     */
    private String filed2;

    /**
     * filed3
     */
    private String filed3;

    /**
     * filed4
     */
    private String filed4;

    /**
     * filed5
     */
    private String filed5;

    /**
     * filed6
     */
    private String filed6;
}
