package org.kushinae.koudi.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.kushinae.koudi.common.config.CurrentAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author bnyte
 * @since 1.0.0
 */
@Component
public class MyBatisPlusHandler implements MetaObjectHandler {

    private static final Logger log = LoggerFactory.getLogger(MyBatisPlusHandler.class);

    @Autowired
    CurrentAdmin currentAdmin;

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("current insert data intercept operation in mybatis-plus");
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "createAdminId", String.class, currentAdmin.id());
        this.strictInsertFill(metaObject, "createAdminName", String.class, currentAdmin.name());
        this.strictInsertFill(metaObject, "modifiedTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "modifiedAdminId", String.class, currentAdmin.id());
        this.strictInsertFill(metaObject, "modifiedAdminName", String.class, currentAdmin.name());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "modifiedTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "modifiedAdminId", String.class, currentAdmin.id());
        this.strictInsertFill(metaObject, "modifiedAdminName", String.class, currentAdmin.name());
    }
}
