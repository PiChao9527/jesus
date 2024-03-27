package com.jesus.truck.inspect.vo;

import lombok.Data;

@Data
public  class ResBean<T> {
    /**
     * 0表示成功
     * 9999表示失败
     */
    private long status;
    private String message;
    private String statusText;
    /**
     * 文件信息
     */
    private T data;
    private byte[] fileData;
}
