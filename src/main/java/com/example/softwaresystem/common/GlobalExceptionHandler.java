package com.example.softwaresystem.common;

import com.example.softwaresystem.result.R;
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
     * @return
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> exceptionHandler(SQLIntegrityConstraintViolationException ex){
        log.error(ex.getMessage());
        if (ex.getMessage().contains("Duplicate entry")){ //查看报错信息是否包含 De 如果包含 说明是我们要捕获的账号重复异常,否则就返回未知错误
            String[] s = ex.getMessage().split(" ");// 以空格分隔符分割异常信息 第三位就是 '账号' 将相应的错误信息绑定到一起
            String msg="";
            if (s[5].equals("tbl_user.tbl_user_number")) {
                msg +="啊?身份证号为"+ s[2] + "的人已存在!";
            }else if(s[5].equals("tbl_user.tbl_user_name")){
                msg += "啊?账号" + s[2] + "已存在!";
            }else if(s[5].equals("tbl_user.tbl_user_tag")){
                msg += "啊?车牌" + s[2] + "已存在!";
            }

            return R.error(msg);
        }
        else return R.error("啊,未知错误?");
    }

}