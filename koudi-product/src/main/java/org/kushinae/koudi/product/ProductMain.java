package org.kushinae.koudi.product;

import com.dtflys.forest.springboot.annotation.ForestScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * 商品服务启动程序
 * @author bnyte
 * @since 1.0.0
 */
@SpringBootApplication
@ComponentScans({
        @ComponentScan("org.kushinae.koudi.common.config"),
        @ComponentScan("org.kushinae.koudi.common.handler"),
        @ComponentScan("org.kushinae.koudi.common.aop"),
        @ComponentScan("org.kushinae.koudi.common.properties"),
        @ComponentScan("org.kushinae.koudi.common.forest"),
})
@MapperScan("org.kushinae.koudi.product.mapper")
@ForestScan("org.kushinae.koudi.common.forest")
public class ProductMain {
    public static void main(String[] args) {
        SpringApplication.run(ProductMain.class, args);
    }
}
