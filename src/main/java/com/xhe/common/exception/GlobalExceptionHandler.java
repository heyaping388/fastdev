package com.xhe.common.exception;

import com.xhe.common.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

/**
 * Created By Xhe
 * Date: 2018/5/11
 * Time: 8:53
 * Desc: 异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(BusinessException.class)
    public R handleTRException(BusinessException e){
        R tr = new R();
        tr.put("code",e.getCode());
        tr.put("msg",e.getMessage());
        return tr;
    }
    @ExceptionHandler(DuplicateKeyException.class)
    public R handleDuplicateKeyException(DuplicateKeyException e){
        logger.error(e.getMessage(), e);
        return R.error("数据库中已存在该记录");
    }
    //处理上传文件过大异常
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public R handleMaxUploadSizeExceededException(MaxUploadSizeExceededException e){
        logger.error(e.getMessage(), e);
        return R.error("上传文件大小不能超过5MB");
    }

    @ExceptionHandler(Exception.class)
    public R handleException(Exception e){
        logger.error(e.getMessage(), e);
        return R.error();
    }
}
