package org.kushinae.koudi.genrate;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author bnyte
 * @since 1.0.0
 */
public class GenerateMain {

    public static void main(String[] args) {
        HashMap<OutputFile, String> pathInfoWindows = new HashMap<>();
        HashMap<OutputFile, String> pathInfoMacOS = new HashMap<>();
        pathInfoWindows.putAll(
                Stream.of(
                        Collections.singletonMap(OutputFile.xml, "D:\\workspace\\tome\\koudi\\koudi-product\\src\\main\\resources\\mapper"),
                        Collections.singletonMap(OutputFile.xml, "D:\\workspace\\tome\\koudi\\koudi-product\\src\\main\\resources\\mapper"),
                        Collections.singletonMap(OutputFile.xml, "D:\\workspace\\tome\\koudi\\koudi-product\\src\\main\\resources\\mapper"),
                        Collections.singletonMap(OutputFile.entity, "D:\\workspace\\tome\\koudi\\koudi-common\\src\\main\\java\\org\\kushinae\\koudi\\common\\entity")
                ).flatMap(e -> e.entrySet().stream()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (key, value) -> value))
        );

        pathInfoWindows.putAll(
                Stream.of(
                        Collections.singletonMap(OutputFile.xml, "D:\\workspace\\tome\\koudi\\koudi-product\\src\\main\\resources\\mapper"),
                        Collections.singletonMap(OutputFile.mapper, "D:\\workspace\\tome\\koudi\\koudi-product\\src\\main\\java\\org\\kushinae\\koudi\\product\\mapper"),
                        Collections.singletonMap(OutputFile.entity, "D:\\workspace\\tome\\koudi\\koudi-common\\src\\main\\java\\org\\kushinae\\koudi\\common\\entity\\product"),
                        Collections.singletonMap(OutputFile.controller, "D:\\workspace\\tome\\koudi\\koudi-product\\src\\main\\java\\org\\kushinae\\koudi\\product\\controller"),
                        Collections.singletonMap(OutputFile.service, "D:\\workspace\\tome\\koudi\\koudi-product\\src\\main\\java\\org\\kushinae\\koudi\\product\\service"),
                        Collections.singletonMap(OutputFile.serviceImpl, "D:\\workspace\\tome\\koudi\\koudi-product\\src\\main\\java\\org\\kushinae\\koudi\\product\\service\\impl")
                ).flatMap(e -> e.entrySet().stream()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (key, value) -> value))
        );

        String outputPathWindows = "D:\\workspace\\tome\\koudi\\koudi-common\\src\\main\\java";
        String outputPathMacOS = "/Users/bnyte/workspaces/tome/koudi/koudi-product/src/main/java";
        String packageName = "org.kushinae.koudi.product";
        List<String> tablePrefix = Stream.of("t_", "c_").toList();
        List<String> includeTables = Stream.of("t_spu").toList();

        generate(true, pathInfoWindows, pathInfoMacOS, "bnyte", outputPathWindows, outputPathMacOS, packageName, tablePrefix, includeTables);

    }

    public static void generate(boolean windows,
                                HashMap<OutputFile, String> pathInfoWindows,
                                HashMap<OutputFile, String> pathInfoMacOS,
                                String author,
                                String outputPathWindows,
                                String outputPathMacOS,
                                String packageName,
                                List<String> tablePrefix,
                                List<String> includeTables) {
        FastAutoGenerator.create("jdbc:mysql://121.40.209.124:6033/koudi_product?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai",
                        "root", "5c2891d9-45fb-4240-9f0e-50222099d9bd")
                .globalConfig(builder -> {
                    builder.author(author) // ????????????
                            .enableSwagger() // ?????? swagger ??????
                            .outputDir(windows ? outputPathWindows : outputPathMacOS); // ??????????????????
                })
                .packageConfig(builder -> {
                    builder.parent(packageName) // ???????????????
                            .pathInfo(windows ? pathInfoWindows : pathInfoMacOS); // ??????mapperXml????????????
                })
                .strategyConfig(builder -> builder
                        .addInclude(includeTables) // ???????????????????????????
                        .addTablePrefix(tablePrefix)// ?????????????????????

                        .controllerBuilder().enableRestStyle().enableHyphenStyle().formatFileName("%sController")
                        .entityBuilder())
                .templateEngine(new FreemarkerTemplateEngine())// ??????Freemarker???????????????????????????Velocity????????????


                .execute();
    }
}
