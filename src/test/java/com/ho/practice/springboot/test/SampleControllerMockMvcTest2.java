package com.ho.practice.springboot.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(value = SampleController.class)
@ExtendWith(OutputCaptureExtension.class)
class SampleControllerMockMvcTest2 {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private SampleService sampleService;
	
	@Test
	void testHello(CapturedOutput output) throws Exception {
		when(sampleService.getName()).thenReturn("test");
		
		mockMvc.perform(get("/hello"))
			.andExpect(status().isOk())
			.andExpect(content().string("hello test"))
			.andDo(print());
		
		assertThat(output.toString())
			.contains("Slf4j log")
			.contains("System log");
	}

}
