package ke.co.saf.fservice.models;

import ke.co.saf.fservice.models.enums.Age;
import ke.co.saf.fservice.models.enums.Health;

import javax.persistence.*;

@Entity
@Table(name = "animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "animal_sequence")
    @SequenceGenerator(name = "animal_sequence", sequenceName = "animal_id_seq", allocationSize = 1)
    private Long id;
    private String name;
    private boolean endangeredAnimal;
    private Health health;
    private Age age;

    public Animal(){

    }

    public Animal(String name, boolean endangeredAnimal, Health health, Age age) {
        this.name = name;
        this.endangeredAnimal = endangeredAnimal;
        this.health = health;
        this.age = age;
    }

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

    public boolean isEndangeredAnimal() {
        return endangeredAnimal;
    }

    public void setEndangeredAnimal(boolean endangeredAnimal) {
        this.endangeredAnimal = endangeredAnimal;
    }

    public Health getHealth() {
        return health;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }
}

