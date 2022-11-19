package org.kushinae.koudi.common.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class CollectionUtilsTest {

    private static final String message = "CollectionUtils工具类测试失败";

    @Test
    void isEmpty() {
        assertTrue(CollectionUtils.isEmpty(Stream.empty().toList()), message);
    }

    @Test
    void notEmpty() {
        assertTrue(CollectionUtils.notEmpty(Stream.of("1").toList()), message);
    }

    @Test
    void transferFromString() {
        assertEquals(Stream.of("1", "2", "3").toList(), CollectionUtils.transferFromString(",", "1,2,3"), message);
    }
}