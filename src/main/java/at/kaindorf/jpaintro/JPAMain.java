package at.kaindorf.jpaintro;

import at.kaindorf.jpaintro.pojos.Customer;
import at.kaindorf.jpaintro.pojos.CustomerId;
import at.kaindorf.jpaintro.pojos.Gender;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class JPAMain {
    private EntityManagerFactory emf;
    private EntityManager em;

    private void connect() {
        emf = Persistence.createEntityManagerFactory("PU_TestDB"); // Name got from persistence.xml
        em =  emf.createEntityManager();
    }

    private void disconnect() {
        em.close();
        emf.close(); // important -> disconnect
    }

    private void testDB() {
        Customer customer1 = new Customer(new CustomerId("Entenhausen", 1L), "donald", "duck", LocalDate.now(), Gender.MALE);
        // commits a OBJ
        em.persist(customer1);

        Customer customer2 = new Customer(new CustomerId("Entenhausen", 2L), "lisa", "simpson", LocalDate.now(), Gender.FEMALE);
        em.persist(customer2);

        // commits all the persisted changes to the Database
        em.getTransaction().begin();
        em.getTransaction().commit();

        // keine Aktion danach wird ausgeführt
    }

    public static void main(String[] args) {
        JPAMain main = new JPAMain();
        main.connect();
        main.testDB();
        main.disconnect();
    }
}
