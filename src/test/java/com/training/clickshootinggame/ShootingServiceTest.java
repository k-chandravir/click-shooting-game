package com.training.clickshootinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
//@ExtendWith(MockitoExtension.class)
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

    @Test
    void shouldDecreaseHealthOfVillainByTwentyWhenHeroAttacks(){
        shootingService.attack("villain");
        int health = shootingService.getVillainHealth();
        assertThat("after getting a hit from hero, villain", health, is(equalTo(80)));
    }

    @Test
    void shouldTurnOnArmour(){
        shootingService.toggleArmour(true);
        assertThat(shootingService.armourStatus, is(true));
    }

    @Test
    void shouldGiveHalfDamageToVillainWhenHeHasArmour(){
        shootingService.toggleArmour(true);
        shootingService.attack("villain");
        int healthOfVillainAfterHit = shootingService.getVillainHealth();

        assertThat( healthOfVillainAfterHit, is( equalTo(90)));
    }

    @Test
    void shouldStillDamageTwentyToHeroWhenArmourIsOn(){
        shootingService.toggleArmour(true);
        shootingService.attack("hero");
        int healthOfHeroAfterHit = shootingService.getHeroHealth();

        assertThat( healthOfHeroAfterHit, is( equalTo(80)));
    }
}

