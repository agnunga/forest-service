package ke.co.saf.fservice.repository;

import ke.co.saf.fservice.models.Animal;
import ke.co.saf.fservice.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import java.util.List;

public class AnimalRepository implements Repository<Long, Animal>{


    private SessionFactory sessionFactory;

    public AnimalRepository() {
        this.sessionFactory = HibernateUtils.getSessionFactory();
    }

    @Override
    public Animal save(Animal entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(entity);
            session.flush();
            session.close();
            return entity;
        }
    }

    @Override
    public void delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Animal animal = session.get(Animal.class, id);
            session.delete(animal);
            session.flush();
            session.close();
        }
    }

    @Override
    public List<Animal> findAll() {
        try (Session session = sessionFactory.openSession()) {
            TypedQuery<Animal> query = session.createQuery("from Animal ", Animal.class);
            List<Animal> animals = query.getResultList();
            session.close();
            return animals;
        }
    }

    @Override
    public Animal findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Animal animal = session.get(Animal.class, id);
            session.close();
            return animal;
        }
    }
}
