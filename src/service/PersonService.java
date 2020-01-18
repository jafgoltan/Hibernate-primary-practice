package service;

import common.JPA;
import entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class PersonService {
    public static void main(String[] args) {
    updateByMerge();

    }
    public static void updateByMerge()
    {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Person person = new Person();
        person.setId(7);
        person.setName("AA");
        entityManager.merge(person);


        entityTransaction.commit();
        entityManager.close();

    }
    public static void remove()
    {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Person person = entityManager.find(Person.class,8L);
        entityManager.remove(person);
        entityTransaction.commit();
        entityManager.close();

    }
    public static void updateAllByJPAQL ()
    {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        //entityManager.createNativeQuery("UPDATE PERSON SET FIRST_NAME='HASAN'").executeUpdate();//NATIVE!!!!
        entityManager.createQuery("UPDATE personEntity o SET o.name='HOSSEIN'").executeUpdate();
        entityTransaction.commit();
        entityManager.close();

    }
    public static void updateAll ()
    {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Query query = entityManager.createQuery("select o from personEntity o");
        List<Person> personList = query.getResultList();
        for (Person person : personList) {
            person.setName("jafar");
            entityManager.persist(person);
        }

        entityTransaction.commit();
        entityManager.close();

    }
    public static void update ()
    {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        /*Person person = new Person();
        person.setId(6);*/
        Person person = entityManager.find(Person.class,6L);

        //entityManager.detach(person);
        person.setName("nn");
        person.setFamily("jj");
        //entityManager.persist(person);

        entityTransaction.commit();
        entityManager.close();

    }

    public static void findByAllAndPagination() {
        EntityManager entityManager = JPA.getEntityManager();
        Query query = entityManager.createQuery("select oo from personEntity oo");
        query.setFirstResult(0);
        query.setMaxResults(5);
        List<Person> personList = query.getResultList();
        entityManager.close();

        for (Person person : personList) {
            System.out.println(person.getId());
            System.out.println(person.getName());
        }

    }

    public static void findByJPQLAndGetSingleResult() {
        EntityManager entityManager = JPA.getEntityManager();
        Query query = entityManager.createQuery("select oo from personEntity oo where oo.id=1");
        Person person = (Person) query.getSingleResult();
        entityManager.close();

        System.out.println(person.getId());
        System.out.println(person.getName());

    }

    public static void findByNamedQuery() {
        EntityManager entityManager = JPA.getEntityManager();
        Query query = entityManager.createNamedQuery("x1");
        List<Person> personList = query.getResultList();
        entityManager.close();
        for (Person person : personList) {
            System.out.println(person.getId());
            System.out.println(person.getName());
        }
    }

    public static void findByJPQL() {
        EntityManager entityManager = JPA.getEntityManager();
        Query query = entityManager.createQuery("select oo from personEntity oo");
        List<Person> personList = query.getResultList();
        entityManager.close();
        for (Person person : personList) {
            System.out.println(person.getId());
            System.out.println(person.getName());
        }
    }

    public static void findByWhere() {
        EntityManager entityManager = JPA.getEntityManager();
        Query query = entityManager.createNativeQuery("SELECT * FROM PERSON WHERE FIRST_NAME LIKE :N OR LAST_NAME LIKE :F", Person.class);
        query.setParameter("N", "%A%");
        query.setParameter("F", "%B%");
        List<Person> personList = query.getResultList();
        entityManager.close();
        for (Person person : personList) {
            System.out.println(person.getId());
            System.out.println(person.getName());
            System.out.println(person.getFamily());
        }

    }

    public static void findAll() {
        EntityManager entityManager = JPA.getEntityManager();
        Query query = entityManager.createNativeQuery("SELECT * FROM PERSON", Person.class);
        List<Person> personList = query.getResultList();
        entityManager.close();
        for (Person person : personList) {
            System.out.println(person.getId());
            System.out.println(person.getName());
            System.out.println(person.getFamily());
        }

    }

    public static void findOneById() {
        EntityManager entityManager = JPA.getEntityManager();
        Person person = entityManager.find(Person.class, 1L);
        entityManager.close();
        System.out.println(person.getId());
        System.out.println(person.getName());
        System.out.println(person.getFamily());
    }

    public static void save() {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Person person = new Person();
        person.setName("negin");
        person.setFamily("jafari");
        entityManager.persist(person);

        entityTransaction.commit();
        entityManager.close();
        System.out.println(person.getId());
    }
}
