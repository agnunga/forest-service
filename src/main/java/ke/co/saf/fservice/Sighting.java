package ke.co.saf.fservice;

public class Sighting {
    private int id;
    private Animal animal;
    private Location location;
    private String rangerName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getRangerName() {
        return rangerName;
    }

    public void setRangerName(String rangerName) {
        this.rangerName = rangerName;
    }
}

enum Location {
    ZONE_A("Zone A"),
    NEAR_THE_RIVER("Near_the_River"),
    NE_QUADRANT("NE_Quadrant");
    private String description;

    private Location(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
