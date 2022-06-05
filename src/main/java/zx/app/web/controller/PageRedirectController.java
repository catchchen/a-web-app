package zx.app.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chenk
 */
@Controller
public class PageRedirectController {
    /**
     * Index redirect uri.
     * 页面跳转
     */
    private static final String INDEX_REDIRECT_URI = "/about-me.html";
//    private static final String INDEX_REDIRECT_URI = "user/dist/index.html";
    private static final String ADMIN_REDIRECT_URI = "admin/dist/index.html";
    @GetMapping("/user-login")
    public void login(HttpServletResponse response) throws IOException {
        response.sendRedirect("http://localhost:8090/admin");

//        response.sendRedirect(INDEX_REDIRECT_URI);
    }

    @GetMapping("/admin-login")
    public void admin(HttpServletResponse response) throws IOException {
        response.sendRedirect(ADMIN_REDIRECT_URI);
    }

}
