package serviceDb;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntitiesDbService {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public EntitiesDbService() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("game_persistence_unit");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public static <T> T loadPlayer(EntityManager em, Class<T> playerClass, String playerName) {
        try {
            return em.createQuery("SELECT p FROM " + playerClass.getSimpleName() + " p WHERE p.name = :name", playerClass)
                    .setParameter("name", playerName)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
