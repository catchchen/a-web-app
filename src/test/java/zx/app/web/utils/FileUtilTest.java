package zx.app.web.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FileUtilTest {

    @Test
    void testFilename(){

        System.out.println(FileUtil.getExtension("aaa.txt"));
        System.out.println(FileUtil.getBasename("aaa.txt"));

    }

}