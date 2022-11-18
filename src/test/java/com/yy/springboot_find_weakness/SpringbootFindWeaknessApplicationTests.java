package com.yy.springboot_find_weakness;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;

@SpringBootTest
class SpringbootFindWeaknessApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void getWeakestModule() {
		HelloController c = new HelloController();

		Map<String, Object> m = new HashMap<>();
		m.put("module_1", "a");
		m.put("module_2", "b");
		m.put("module_3", "c");
		m.put("mark_1", 20);
		m.put("mark_2", 30);
		m.put("mark_3", 40);

		Object[] exp = {"a", 23.0f};
		assertArrayEquals(exp, c.getWeakestModule(m));

	}

}
