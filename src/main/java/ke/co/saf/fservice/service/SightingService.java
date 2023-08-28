package ke.co.saf.fservice.service;

import ke.co.saf.fservice.models.Message;
import ke.co.saf.fservice.models.Sighting;
import ke.co.saf.fservice.repository.Repository;
import ke.co.saf.fservice.repository.SightingRepository;
import java.util.List;

public class SightingService {

    private Repository<Long, Sighting> repository;

    public SightingService() {
        this.repository = new SightingRepository();
    }

    public List<Sighting> findAll() {
        return repository.findAll();
    }

    public Sighting findById(Long id) {
        return repository.findById(id);
    }

    public Sighting save(Sighting sighting) {
        return repository.save(sighting);
    }

    public Sighting update(Sighting sighting) {
        return repository.save(sighting);
    }

    public Message delete(Long id) {
        repository.delete(id);
        return new Message("Sighting with identifier " + id + " was deleted.");
    }

}
