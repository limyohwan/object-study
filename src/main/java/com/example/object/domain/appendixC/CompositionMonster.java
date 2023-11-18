package com.example.object.domain.appendixC;

public class CompositionMonster {
    private Breed breed;

    public CompositionMonster(Breed breed) {
        this.breed = breed;
    }

    public String getAttack() {
        return breed.getAttack();
    }
}
