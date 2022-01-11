package com.chige;

import com.chige.controller.TestController;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootSwaggerApplication.class)
@WebAppConfiguration
class SpringBootSwaggerApplicationTests {

    private MockMvc mockMvc;

    @Before
    private void setUp() {
//        mockMvc = MockMvcBuilders.standaloneSetup(new TestController()).build();
    }

    @Test
    public void contextLoads() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/health/test").accept(MediaType.APPLICATION_JSON))
//               .andExpect(status().isOk())
//               .andExpect(content().string(equalTo("OK!")));
    }

}
