package com.training.clickshootinggame;

import org.springframework.stereotype.Service;


@Service
public class ShootingService {


    int heroHealth = 100;
    int villainHealth = 100;
    public int getHeroHealth() {
        return this.heroHealth;
    }


    public void attack(String characterGettingShot) {
        if(characterGettingShot == "hero"){
            this.heroHealth -= 20;
        }else{
            this.villainHealth -=20;
        }
    }


    public int getVillainHealth() {
        return this.villainHealth;
    }


    public void toggleArmour() {

    }

    public void setHeroHealth(int i) {
        heroHealth = i;
    }

    public void setVillainHealth(int i) {
        villainHealth = i;
    }

    public void setArmour(boolean b) {

    }
}
