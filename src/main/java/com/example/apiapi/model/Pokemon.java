package com.example.apiapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int height;
    private int weight;

    @ElementCollection
    private List<Ability> abilities;

    @Embedded
    private Sprites sprites;

    // Getters and setters for Pokemon class fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    // Inner classes with their getters and setters

    @Embeddable
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Ability {
        @Embedded
        private AbilityDetail ability;

        // Getters and setters for Ability class fields
        public AbilityDetail getAbility() {
            return ability;
        }

        public void setAbility(AbilityDetail ability) {
            this.ability = ability;
        }
    }

    @Embeddable
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AbilityDetail {
        private String name;

        // Getters and setters for AbilityDetail class fields
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @Embeddable
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Sprites {
        private String front_default;

        // Getters and setters for Sprites class fields
        public String getFront_default() {
            return front_default;
        }

        public void setFront_default(String front_default) {
            this.front_default = front_default;
        }
    }
}

