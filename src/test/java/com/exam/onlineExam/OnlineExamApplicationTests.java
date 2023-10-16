package com.exam.onlineExam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@Disabled
@SpringBootTest
class OnlineExamApplicationTests {

	@Test
	public void test(){
		OnlineExamApplication.main(new String[]{});
			Assertions.assertNotNull(OnlineExamApplication.class);
	}


}
