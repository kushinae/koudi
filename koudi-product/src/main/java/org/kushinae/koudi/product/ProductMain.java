package org.kushinae.koudi.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 商品服务启动程序
 * @author bnyte
 * @since 1.0.0
 */
@MapperScan("org.kushinae.koudi.product.mapper")
@SpringBootApplication
public class ProductMain {
    public static void main(String[] args) {
        SpringApplication.run(ProductMain.class, args);
    }
}
