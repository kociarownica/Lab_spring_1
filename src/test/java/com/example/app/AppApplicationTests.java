package com.example.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AppApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() throws Exception{
        this.mockMvc.perform(get("/?d=10&t=5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{speed:2.0}"));
    }

    @Test
    void contextLoads1() throws Exception{
        this.mockMvc.perform(get("/?d=10&t=3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{speed:3.3333333333333335}"));
    }
}