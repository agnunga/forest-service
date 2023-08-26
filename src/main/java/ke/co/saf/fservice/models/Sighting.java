package ke.co.saf.fservice.models;

import ke.co.saf.fservice.models.enums.Location;

import javax.persistence.*;

@Entity
@Table(name = "sightings")
public class Sighting {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sighting_sequence")
    @SequenceGenerator(name = "sighting_sequence", sequenceName = "sighting_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(optional = false)
    private Animal animal;
    @Column(nullable = false)
    private Location location;
    @Column(nullable = false)
    private String rangerName;

    public Sighting() {
    }

    public Sighting(Long id, Animal animal, Location location, String rangerName) {
        this.id = id;
        this.animal = animal;
        this.location = location;
        this.rangerName = rangerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

