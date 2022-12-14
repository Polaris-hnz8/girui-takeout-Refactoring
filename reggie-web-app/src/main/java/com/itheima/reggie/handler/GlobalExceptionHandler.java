package com.itheima.reggie.handler;

import com.itheima.reggie.common.CustomException;
import com.itheima.reggie.common.ResultInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//全局异常处理
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 预期异常处理方法
     * @param ex
     * @return
     */
    @ExceptionHandler(CustomException.class)
    public ResultInfo exceptionHandler(CustomException ex) {
        log.error(ex.getMessage());

        return ResultInfo.error(ex.getMessage());
    }

    /**
     * 非预期异常处理方法
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResultInfo exceptionHandler(Exception ex) {
        log.error(ex.getMessage());

        return ResultInfo.error("对不起,网络问题,请稍后再试");
    }

}