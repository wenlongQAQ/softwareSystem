package com.zzut.softwaresystem.common;

import com.zzut.softwaresystem.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice(annotations = {RestController.class, Controller.class})
@ResponseBody //拦截异常后返回R对象转换为json数据
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 异常处理方法
     *
     * @return
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R exceptionHandler(SQLIntegrityConstraintViolationException ex){
        log.error(ex.getMessage());
        String msg="";
        if (ex.getMessage().contains("Duplicate entry")){
            String[] s = ex.getMessage().split(" ");
            if ("'tbl_user.tbl_user_number'".equals(s[5])) {
                msg +="啊?身份证号为"+ s[2] + "的人已存在!";
            }else if(s[5].equals("'tbl_user.tbl_user_name'")){
                msg += "啊?账号" + s[2] + "已存在!";
            }else if(s[5].equals("'tbl_user.tbl_user_tag'")){
                msg += "啊?车牌" + s[2] + "已存在!";
            }
            return R.error(msg);

        }
        else {
            return R.error("您的网络不佳请稍后再试");
        }
    }

}