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
    private int base_experience;
    
    @ElementCollection
    private List<Stat> stats;

    @ElementCollection
    private List<Ability> abilities;

    @ElementCollection
    private List<Type> types;

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

    public int getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(int base_experience) {
        this.base_experience = base_experience;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }
    

    @Embeddable
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Stat {
        private int base_stat;

        @Embedded
        private StatDetail stat;

        // Getters and setters...

        public int getBase_stat() {
            return base_stat;
        }

        public void setBase_stat(int base_stat) {
            this.base_stat = base_stat;
        }

        public StatDetail getStat() {
            return stat;
        }

        public void setStat(StatDetail stat) {
            this.stat = stat;
        }
    }

    @Embeddable
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class StatDetail {
        private String name;

        // Getters and setters...

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    @Embeddable
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Ability {
        @Embedded
        private AbilityDetail ability;

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @Embeddable
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Type {
        @Embedded
        private TypeDetail type;

        public TypeDetail getType() {
            return type;
        }

        public void setType(TypeDetail type) {
            this.type = type;
        }
    }

    @Embeddable
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TypeDetail {
        private String name;

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

        public String getFront_default() {
            return front_default;
        }

        public void setFront_default(String front_default) {
            this.front_default = front_default;
        }
    }
}
