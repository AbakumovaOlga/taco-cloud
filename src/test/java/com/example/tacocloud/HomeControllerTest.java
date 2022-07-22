package com.example.tacocloud;

import static org.hamcrest.Matchers.containsString;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest() /* Веб-тест для HomeController */

public class HomeControllerTest {

    @Autowired

    private MockMvc mockMvc; /* Внедряет MockMvc */

    @Test

    public void testHomePage() throws Exception {

        mockMvc.perform(get("/")) /* Выполняет GET */

                .andExpect(status().isOk()) /*-Ожидает HTTP 200*/
                .andExpect(view().name("home")) /* Ожидает home */

                .andExpect(content().string( /* Welcome to... */

                        containsString("Welcome to...")));
    }

}