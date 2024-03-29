package com.jesus.truck.inspect.commom.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BusinessException extends RuntimeException{
    private long code;
    private String msg;

    public BusinessException(long code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
