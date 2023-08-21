package ke.co.saf.fservice;

public class Animal {

    private int id;
    private String name;
    private boolean EndangeredAnimal;
    private Health health;
    private Age age;

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
        return EndangeredAnimal;
    }

    public void setEndangeredAnimal(boolean endangeredAnimal) {
        EndangeredAnimal = endangeredAnimal;
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