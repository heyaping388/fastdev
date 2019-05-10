package com.xhe.modules.controller;

import com.xhe.common.annotation.SysLog;
import com.xhe.common.utils.R;
import com.xhe.common.validator.ValidatorUtils;
import com.xhe.common.validator.group.AddGroup;
import com.xhe.modules.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Created By Xhe
 * Date: 2018/4/29
 * Time: 15:25
 * Desc:
 */
@Slf4j
@RestController
public class TestController {
    /**
     * 测试logback日志级别
     */
    @SysLog("测试log级别")
    @GetMapping("/testLog")
    public void index(){
        log.trace("trace：trace级别");
        log.debug("debug：debug级别");
        log.info("info：info级别");
        log.warn("warn：warn级别");
        log.error("error：error级别");
    }

    /**
     * 测试JSR303数据校验
     * @param user
     * @return
     */
    @PostMapping("/testValidator")
    public R test(@RequestBody UserEntity user){
        ValidatorUtils.validateEntity(user, AddGroup.class);
        log.info("接收到的数据为：{}",user);
        return R.ok();
    }
}
