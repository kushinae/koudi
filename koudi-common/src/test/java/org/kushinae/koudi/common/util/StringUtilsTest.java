package org.kushinae.koudi.common.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class StringUtilsTest {

    private static final String message = "StringUtils工具类测试失败";

    @Test
    void hasText() {
        assertTrue(StringUtils.hasText("1"), message);
    }

    @Test
    void notText() {
        assertTrue(StringUtils.notText(""), message);
    }

    @Test
    void transferFromList() {
        assertEquals("1,2,3", StringUtils.transferFromList(",", Stream.of("1", "2", "3").toList()), message);
    }
}