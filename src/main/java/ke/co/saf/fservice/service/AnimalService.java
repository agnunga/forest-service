package ke.co.saf.fservice.service;

import com.google.gson.Gson;
import ke.co.saf.fservice.models.Animal;
import ke.co.saf.fservice.models.Message;
import ke.co.saf.fservice.models.Sighting;
import ke.co.saf.fservice.models.enums.Age;
import ke.co.saf.fservice.models.enums.Health;
import ke.co.saf.fservice.repository.AnimalRepository;
import ke.co.saf.fservice.repository.Repository;
import spark.Request;

import java.util.List;

public class AnimalService {

    private Repository<Long, Animal> repository;

    public AnimalService() {
        this.repository = new AnimalRepository();
    }

    public List<Animal> findAll() {
        return repository.findAll();
    }

    public Animal findById(Request request) {
        Long id = request.attribute("id");
        return repository.findById(id);
    }

    public Animal save(Animal animal) {
        Animal animalx = new Animal("Lion", false, Health.HEALTHY, Age.ADULT);
        return repository.save(animal);
    }

    public Animal update(Request request, Gson gson) {
        Animal animal = gson.fromJson(request.body(), Animal.class);
        return repository.save(animal);
    }

    public Message delete(Request request) {
        Long id = request.attribute("id");
        repository.delete(id);
        return new Message("Animal with identifier " + id + " was deleted.");
    }

}
