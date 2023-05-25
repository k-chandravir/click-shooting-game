package com.training.clickshootinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

//@ExtendWith(MockitoExtension.class)
@WebMvcTest(ShootingService.class)
public class ShootingServiceTest {

//    @InjectMocks
    @Autowired
    private ShootingService shootingService;
    @BeforeEach
    void initialSetup(){
        shootingService.setHeroHealth(100);
        shootingService.setVillainHealth(100);
        shootingService.setArmour(false);
    }

    @Test
    void shouldReturnTheInitialHealthOfHeroAsHundred(){
//        Mockito.when(shootingService.getHeroHealth()).thenReturn(100);
        int initialHealth = shootingService.getHeroHealth();
//        assertEquals(initialHealth, 100);
        assertThat(initialHealth,is(equalTo(100)));
    }

    @Test
    void shouldReturnTheInitialHealthOfVillainAsHundred(){
        int initialHealth = shootingService.getVillainHealth();
        assertEquals(initialHealth, 100);
    }

    @Test
    void shouldDecreaseHealthOfHeroByTwentyWhenVillainAttacks(){
        shootingService.attack("hero");
        int health = shootingService.getHeroHealth();
        assertEquals(health, 80);
    }
}
