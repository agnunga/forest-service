package ke.co.saf.fservice;

public class Animal {

    private int id;
    private String name;
    private boolean endangeredAnimal;
    private Health health;
    private Age age;

    public Animal(int id, String name, boolean endangeredAnimal, Health health, Age age) {
        this.id = id;
        this.name = name;
        this.endangeredAnimal = endangeredAnimal;
        this.health = health;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        endangeredAnimal = endangeredAnimal;
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

enum Health {
    HEALTHY,
    ILL,
    OKAY
}

enum Age {
    NEWBORN,
    YOUNG,
    ADULT
}