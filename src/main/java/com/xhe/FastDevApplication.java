package com.xhe;

import com.xhe.datasources.DynamicDataSourceConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@Import({DynamicDataSourceConfig.class})
@MapperScan(basePackages = {"com.xhe.modules.dao"})
//@EnableScheduling  //启用定时任务
public class FastDevApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FastDevApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FastDevApplication.class);
    }
}
