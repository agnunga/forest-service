package ke.co.saf.fservice.repository;

import ke.co.saf.fservice.models.Sighting;
import ke.co.saf.fservice.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class SightingRepository implements Repository<Long, Sighting>{

    private SessionFactory sessionFactory;

    public SightingRepository() {
        this.sessionFactory = HibernateUtils.getSessionFactory();
    }

    @Override
    public Sighting save(Sighting entity) {
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
            Sighting sighting = session.get(Sighting.class, id);
            session.delete(sighting);
            session.flush();
            session.close();
        }
    }

    @Override
    public List<Sighting> findAll() {
        try (Session session = sessionFactory.openSession()) {
            TypedQuery<Sighting> query = session.createQuery("from Sighting ", Sighting.class);
            List<Sighting> sightings = query.getResultList();
            session.close();
            return sightings;
        }
    }

    @Override
    public Sighting findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Sighting sighting = session.get(Sighting.class, id);
            session.close();
            return sighting;
        }
    }
}
