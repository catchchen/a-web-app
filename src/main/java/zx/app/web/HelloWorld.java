package zx.app.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zx.app.web.model.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenk
 * 此类 致敬 写下的第一行代码。
 * 感谢学校教会我的知识，拓宽我的视野
 */
@RestController
public class HelloWorld {
    @GetMapping("/hello")
    Response hello() {
        Map I = new HashMap();
        I.put("school" ,"大连东软信息学院");
        I.put("name", "chenkaiqi");
        return Response.ok("success", I);
    }
}
