package zx.app.web.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zx.app.web.service.inter.UserService;

/**
 * @author chenk
 */

@RestController
@RequestMapping("/api/user/")
public class UserRestfulController {

    private final UserService userService;

    public UserRestfulController(UserService userService) {
        this.userService = userService;
    }

}
