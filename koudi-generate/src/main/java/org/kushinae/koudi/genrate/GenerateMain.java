package org.kushinae.koudi.genrate;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author bnyte
 * @since 1.0.0
 */
public class GenerateMain {

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://121.40.209.124:6033/koudi_product?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai",
                "root", "5c2891d9-45fb-4240-9f0e-50222099d9bd")
                .globalConfig(builder -> {
                    builder.author("bnyte") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir("D:\\workspace\\tome\\koudi\\koudi-product\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("org.kushinae.koudi") // 设置父包名
                            .moduleName("product") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\workspace\\tome\\koudi\\koudi-product\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_product_attr_group") // 设置需要生成的表名
                            .addTablePrefix("t_product", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
