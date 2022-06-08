package zx.app.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zx.app.web.model.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenk
 * 写下的第一行代码。
 */
@RestController
@CrossOrigin(origins = "*")
public class Hello {
    @GetMapping("/hello")
    Response hello() {
        Map I = new HashMap();
        I.put("school" ,"大连东软信息学院");
        I.put("name", "chenkaiqi");
        I.put("msg", "感谢学校教会我的知识，拓宽我的视野" +
                "让我在计算机的宽阔天地中获得知识，为解决问题而设计程序" +
                "老师也让我明白了学校学的知识 还是不够的，这个项目的功能是我自学springboot和vue3，" +
                "完成了这个项目 我获得的是巨大的提升，这个提升不仅仅在编程能力上，" +
                "更是在软件思维上，程序设计思想上的提升。<br>感谢老师的领路"
        );
        return Response.ok("success", I);
    }
}
