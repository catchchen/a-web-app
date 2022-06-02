package zx.app.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import zx.app.web.model.common.Admin;

@SpringBootTest
class WebApplicationTests {
	@Autowired
	private Admin admin;
	@Test
	void contextLoads() {
		System.out.println(admin.getUsername());
		System.out.println(admin.getPassword());
	}
}
