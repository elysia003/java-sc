package com.ciyo.common.exception;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ciyo.common.unitl.R;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public R<String> exceptionHandler(BaseException me) {
        return R.fail(me.getCode(),me.getDefaultMessage());
    }
}