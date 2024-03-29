package com.jesus.truck.inspect.commom.exception;

public enum ReturnCode {
    RC0(0L, "处理成功"),
    RC200(200L, "ok"),
    RC400(400L, "请求失败，参数错误，请检查后重试。"),
    RC404(404L, "未找到您请求的资源。"),
    RC405(405L, "请求方式错误，请检查后重试。"),
    RC500(500L, "操作失败，服务器繁忙或服务器错误，请稍后再试。");

    // 自定义状态码
    private final long code;

    // 自定义描述
    private final String msg;

    ReturnCode(long code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public long getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
