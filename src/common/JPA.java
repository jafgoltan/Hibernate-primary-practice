package common;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPA {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("BOX");
    public static EntityManager getEntityManager()
    {
        return factory.createEntityManager();
    }

}
