package zx.app.web.utils;

import org.junit.jupiter.api.Test;
class MarkdownUtilTest {
    @Test
    void testRenderHtml() {
        String markdown = "### 这是标题<br> - list1 - list2 - list 3";
        String format = MarkdownUtil.renderHtml(markdown);
        System.out.println(format);
    }
    @Test
    void testRenderHtml2() {
        String markdown = "# Thymeleaf\n" +
                "\n" +
                "why Thymeleaf?\n" +
                "\n" +
                "> Thymeleaf is a modern server-side Java template engine for both web and standalone environments, capable of processing HTML, XML, JavaScript, CSS and even plain text\n" +
                "> The main goal of Thymeleaf is to provide an elegant and highly-maintainable way of creating templates. To achieve this, it builds on the concept of Natural Templates to inject its logic into template files in a way that doesn’t affect the template from being used as a design prototype. This improves communication of design and bridges the gap between design and development teams.\n" +
                "> Thymeleaf has also been designed from the beginning with Web Standards in mind – especially HTML5 – allowing you to create fully validating templates if that is a need for you.\n" +
                "\n" +
                "Thymeleaf can process six kinds of templates \n" +
                "\n" +
                "- html\n" +
                "- XML\n" +
                "- TEXT\n" +
                "- JAVASCRIPT\n" +
                "- CSS\n" +
                "- RAW\n" +
                "\n" +
                "There are two markup template modes ( HTML and XML ), three textual template modes ( TEXT , JAVASCRIPT and CSS ) and a no-op template mode ( RAW )\n" +
                "\n" +
                "## 页面跳转\n" +
                "1. 静态文件 static或public中的文件 使用http://localhost:8080/pro-name/hello.html 直接访问 (图片啥的就用这种方式引入)\n" +
                "也可以通过controller跳转\n" +
                "```java\n" +
                "@Controller\n" +
                "public class HelloController{\n" +
                "\t@RequestMapping(\"/\")\n" +
                "\tpublic String sayHello() {\n" +
                "\treturn \"hello.html\";\n" +
                "\t}\n" +
                "// 若不加上后缀  默认跳转到  template/index.html\n" +
                "}\n" +
                "```\n" +
                "\n" +
                "2. 动态文件 templeate\n" +
                "\n" +
                "```java\n" +
                "@Controller\n" +
                "public class HelloController{\n" +
                "\t@RequestMapping(\"/hi\")\n" +
                "\tpublic ModelAndView sayHello() {\n" +
                "\tModelAndView mav = new ModelAndView();\n" +
                "\tmav.setViewName(\"hello\");\n" +
                "\tmav.addObject(\"key\", 123)\n" +
                "\treturn mav;\n" +
                "\t}\n" +
                "}\n" +
                "```\n" +
                "\n" +
                "3. 动态跳静态 可以使用重定向\n" +
                "return \"redirect:/index.html\"\n" +
                "> tip  拦截的url 最后不要跟视图重合，否则会报 Circular view path循环视图错误";
        String format = MarkdownUtil.renderHtml(markdown);
        System.out.println("test------------>");
        System.out.println(format);
        System.out.println("test2------------>");
        System.out.println(MarkdownUtil.renderHtml("目标：\n" +
                "- 了解Swagger作用概念\n" +
                "- 了解前后端分离\n" +
                "- 在Springboot中集成Swagger\n" +
                "\n" +
                "## Swagger简介\n" +
                "## 前后端分离\n" +
                "Vue+SpringBoot\n" +
                "- 后端：后端控制层，服务层，数据访问层\n" +
                "- 前端：前端控制层，视图层\n" +
                "\t- 伪造后端数据，json。\n" +
                "- 前后端交互? ==> api\n" +
                "- 前后端相对独立，松耦合\n" +
                "- 前后端甚至都可以部署在不同不同服务器上；\n" +
                "\n" +
                "一个问题：\n" +
                "- 前后端集成联调，前后端无法做到即使协商，尽早解决，最终问题集中爆发。\n" +
                "- 首先制定schema[计划的提纲]，实时更新API，降低集成的风险；\n" +
                "- 前后端分离：\n" +
                "\t- 前端测试\n" +
                "## Swagger \n" +
                "\n" +
                "- 号称世界上最流行的Api框架\n" +
                "- Restful Api在线文档生成工具 Api文档与API定义同步更新\n" +
                "- 直接运行，可以在线测试接口；\n" +
                "\n" +
                "官网[swagger](https://swagger.io)\n" +
                "\n" +
                "在项目使用Swagger需要springbox;\n" +
                "- swagger2\n" +
                "- ui\n" +
                "\n" +
                "Springboot集成Swagger\n" +
                "- 新建web应用 \n" +
                "- 导入相关依赖\n" +
                "    implementation \"io.springfox:springfox-boot-starter:$swaggerVersion\"\n" +
                "SwaggerConfig\n" +
                "\n" +
                "@Config\n" +
                "@EnableSwagger2\n" +
                "public class SwaggerConfig {\n" +
                "}\n" +
                "\n" +
                "测试\n" +
                "\n" +
                "四个部分\n" +
                "Swaggr信息\n" +
                "组信息 group\n" +
                "接口信息\n" +
                "实体类信息\n" +
                "\n" +
                "配置类中写入\n" +
                "\n" +
                "@Bean\n" +
                "Docket docket(){\n" +
                "\treturn new Docket(Document.SWAGGER_2)\n" +
                "\t.apiInfo(apiInfo())\n" +
                "\t.select()\n" +
                "\t// RequestHandlerSelectors,\n" +
                "\t// basePackage\t配置扫描的包\n" +
                "\t// none(); 扫描全部\n" +
                "\t.apis(RequestHandlerSelectors.basePackage(\"com.ch.controller\")) // .withClassAnnotation(Restcontroller.class) 至扫描有该注解标注的\n" +
                "\t// \n" +
                "\t//.paths(PathSelector.ant(\"/ch/**\")) //  只扫描\n" +
                "\t.bulid();\n" +
                "}\n" +
                "\n" +
                "// 配置Swagger信息 = apiInfo\n" +
                "private ApiInfo apiInfo(){\n" +
                "// 作者信息\n" +
                "Contact contact = new Contect(\"name\",\"url\",\"email\")\n" +
                "\treturn new ApiInfo(\n" +
                "\t\"SwaggerAPI\")// title\n" +
                "\t,\"\" //description\n" +
                "\t,\"\" // version\n" +
                "\t,\"\" // license\n" +
                "\t,\"\" // licenseUrl,\n" +
                "\tnew ArrayList());\n" +
                "}\n" +
                "\n" +

                "## Model\n" +
                "> 实体类配置\n" +
                "@Api() // 用于模块上\n" +
                "@ApiModel(\"\") // 对类的说明\n" +
                "@ApiModleProperty(\"\") // 给类的属性标注注释说明\n" +
                "只要返回值中存在就会被扫描到\n" +
                "\n" +
                "## Controller\n" +
                "发布的时候关闭，安全，节省运行内存；\n"));
    }

}