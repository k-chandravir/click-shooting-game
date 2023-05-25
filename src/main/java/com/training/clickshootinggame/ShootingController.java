package com.training.clickshootinggame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShootingController {
    @Autowired
    private ShootingService shootingService;

    @GetMapping("/hero-health")
    public int getHealthOfHero(){
        return shootingService.getHeroHealth();
    }

    @GetMapping("/villain-health")
    public int getHealthOfVillain(){
        return shootingService.getVillainHealth();
    }

//    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/shoot")
    public ResponseEntity<Object> attack(@RequestParam("hero-or-villain") String character){
        shootingService.attack(character);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/armour")
    public ResponseEntity<Object> toggleArmour(@RequestParam("on-or-off") Boolean armourStatus){
        shootingService.toggleArmour(armourStatus);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
