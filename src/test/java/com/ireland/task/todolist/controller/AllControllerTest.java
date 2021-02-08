package com.ireland.task.todolist.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;



@SpringBootTest
@AutoConfigureMockMvc
public class AllControllerTest {

    @Autowired
    private MockMvc mvc;


    @Test
    public void home() throws Exception{
        ResultMatcher ok = MockMvcResultMatchers.status()
                .isOk();
        ResultMatcher expected = MockMvcResultMatchers.view().name("home.html");
        mvc.perform(MockMvcRequestBuilders.get("/").with(SecurityMockMvcRequestPostProcessors.user("test").password("$2a$10$2rrQh/zbZENNOSveUd1iPuSiM9XCZu3IYj59wpeutwuWRtTYrDKIe"))).andExpect(ok).andExpect(expected);
    }

    @Test
    public void login() throws Exception{
        ResultMatcher ok = MockMvcResultMatchers.status()
                .isOk();
        ResultMatcher expected = MockMvcResultMatchers.view().name("auth/login");
        mvc.perform(MockMvcRequestBuilders.get("/login")).andExpect(ok).andExpect(expected);
    }

    @Test
    public void create() throws Exception{
        ResultMatcher ok = MockMvcResultMatchers.status()
                .isOk();
        ResultMatcher expected = MockMvcResultMatchers.view().name("addTodo.html");
        mvc.perform(MockMvcRequestBuilders.get("/create").with(SecurityMockMvcRequestPostProcessors.user("test").password("$2a$10$2rrQh/zbZENNOSveUd1iPuSiM9XCZu3IYj59wpeutwuWRtTYrDKIe"))).andExpect(ok).andExpect(expected);
    }

}
