package com.training.clickshootinggame;

import org.springframework.stereotype.Service;


@Service
public class ShootingService {


    int heroHealth = 100;
    int villainHealth = 100;
    Boolean armourStatus = false;

    public void setHeroHealth(int heroHealth) {
        this.heroHealth = heroHealth;
    }
    public void setVillainHealth(int villainHealth) {
        this.villainHealth = villainHealth;
    }
    public void setArmour(boolean armourStatus) {
        this.armourStatus = armourStatus;
    }

    public int getHeroHealth() {
        return this.heroHealth;
    }

    public void attack(String characterGettingShot) {
        if(characterGettingShot.equals("hero")){
            this.heroHealth -= 20;
        }else if(characterGettingShot.equals("villain")){
            if(this.armourStatus == false){
                this.villainHealth -= 20;
            }else{
                this.villainHealth -= 10;
            }

        }
    }


    public int getVillainHealth() {
        return this.villainHealth;
    }


    public void toggleArmour(Boolean armourStatus) {
        this.armourStatus = armourStatus;
    }


}
