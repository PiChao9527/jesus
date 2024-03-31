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

    public static <T> ResBean<T> success(T data) {
        ResBean<T> r = new ResBean<>();
        r.setStatus(0L);
        r.setMessage("处理成功。");
        r.setData(data);
        return r;
    }

    public static <T> ResBean<T> error(long code, String msg) {
        ResBean<T> r = new ResBean<>();
        r.setStatus(code);
        r.setMessage(msg);
        r.setData(null);
        return r;
    }
}
