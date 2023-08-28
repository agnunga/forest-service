package ke.co.saf.fservice.service;

import ke.co.saf.fservice.models.Animal;
import ke.co.saf.fservice.models.Message;
import ke.co.saf.fservice.models.enums.Age;
import ke.co.saf.fservice.models.enums.Health;
import ke.co.saf.fservice.repository.AnimalRepository;
import ke.co.saf.fservice.repository.Repository;
import java.util.List;

public class AnimalService {

    private Repository<Long, Animal> repository;

    public AnimalService() {
        this.repository = new AnimalRepository();
    }

    public List<Animal> findAll() {
        return repository.findAll();
    }

    public Animal findById(Long id) {
        return repository.findById(id);
    }

    public Animal save(Animal animal) {
        Animal animalx = new Animal("Lion", false, Health.HEALTHY, Age.ADULT);
        return repository.save(animal);
    }

    public Animal update(Animal animal) {
        return repository.save(animal);
    }

    public Message delete(Long id) {
        repository.delete(id);
        return new Message("Animal with identifier " + id + " was deleted.");
    }

}
