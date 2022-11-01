package org.kushinae.koudi.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.kushinae.koudi.common.config.CurrentAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author bnyte
 * @since 1.0.0
 */
@Slf4j
@Component
public class MyBatisPlusHandler implements MetaObjectHandler {

    @Autowired
    CurrentAdmin currentAdmin;

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("current insert data intercept operation in mybatis-plus");
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "createAdminId", String.class, currentAdmin.id());
        this.strictInsertFill(metaObject, "createAdminName", String.class, currentAdmin.name());
        this.strictInsertFill(metaObject, "modifiedTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "modifiedAdminId", String.class, currentAdmin.id());
        this.strictInsertFill(metaObject, "modifiedAdminName", String.class, currentAdmin.name());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "modifiedTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "modifiedAdminId", String.class, currentAdmin.id());
        this.strictInsertFill(metaObject, "modifiedAdminName", String.class, currentAdmin.name());
    }
}
