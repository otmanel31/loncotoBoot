package com.loncoto.loncontoBoot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class LoncontoBootApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("in => " + LoncontoBootApplicationTests.class);
	}

}
