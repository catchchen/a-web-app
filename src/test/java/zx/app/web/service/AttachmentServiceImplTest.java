package zx.app.web.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

@SpringBootTest
class AttachmentServiceImplTest {
    @Test
    void testRealPath() {
       final String PATH = "src/main/resources/upload";
        File file = new File(PATH);
        System.out.println(file.getAbsolutePath());
    }

    @Test
    void test() {
        try {
            String s = ResourceUtils.getURL("classpath:").getPath().substring(1) + "static/img/";
            System.out.println(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}