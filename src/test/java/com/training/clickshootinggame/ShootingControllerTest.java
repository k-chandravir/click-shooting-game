package com.training.clickshootinggame;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ShootingController.class)
public class ShootingControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ShootingService shootingService;
    @Test
    void shouldReturnHeroHealthAsHundred() throws Exception{
        Mockito.when(shootingService.getHeroHealth()).thenReturn(100);

        mockMvc.perform(MockMvcRequestBuilders.get("/hero-health"))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(100)));

    }

    @Test
    void shouldReturnVillainHealthAsHundred() throws Exception {
        Mockito.when(shootingService.getVillainHealth()).thenReturn(100);

        mockMvc.perform(MockMvcRequestBuilders.get("/villain-health"))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(100)));
    }

    @Test
    void shouldHeroHitVillain() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/shoot?hero-or-villain=villain"))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldVillainHitHero() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/shoot?hero-or-villain=hero"))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldEnableArmour() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/armour?on-or-off=true"))
                .andExpect(status().is(201));
    }
}
