package com.jesus.truck.inspect.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页查询请求对象的基类，包含pageNo，perPage参数
 */
@SuppressWarnings("serial")
@Data
public class BasePageQueryCondition implements Serializable {

	/**
	 * 页码
	 */
	private int pageNo;
	/**
	 * 页面容量
	 */
	private int pageSize;
	/**
	 * 排序字段
	 */
	private String orderBy;
	/**
	 * 排序规则
	 */
	private String direction;

}
