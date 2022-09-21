package at.kaindorf.jpaintro;

import at.kaindorf.jpaintro.pojos.Address;
import at.kaindorf.jpaintro.pojos.Customer;
import at.kaindorf.jpaintro.pojos.CustomerId;
import at.kaindorf.jpaintro.pojos.Gender;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

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

    public void initDB() {
        Customer customer1 = new Customer(new CustomerId("Entenhausen", 1L), "donald", "duck", LocalDate.now(), Gender.MALE);
        Address addr_donald = new Address( "Bllumenstr", "13", 95126);

        customer1.setAddress(addr_donald);
        addr_donald.setCustomer(customer1);
        // commits a OBJ
        // em.persist(addr_donald); must no be done when @OneToOne(cascade = CascadeType.persist)
        em.persist(customer1);

        Customer customer2 = new Customer(new CustomerId("Springfield", 2L), "lisa", "simpson", LocalDate.now(), Gender.FEMALE);
        em.persist(customer2);

        Customer customer3 = new Customer(new CustomerId("Rhode Island", 3L), "Peter", "Griffin", LocalDate.now(), Gender.MALE);
        em.persist(customer3);

        // commits all the persisted changes to the Database
        em.getTransaction().begin();
        em.getTransaction().commit();

        // keine Aktion danach wird ausgeführt
    }

    /**
     * use JPQL - Java Persistence Query Language for SELECT statements;
     */
    public void testDB() {
        // TypedQuery<Customer> tq = em.createQuery("SELECT c FROM Customer  c", Customer.class);
//        List<Customer> customerList = em.createQuery("SELECT c FROM Customer  c", Customer.class)
//                                        .getResultList();
        TypedQuery<Customer> tq = em.createNamedQuery("Customer.getByLastname", Customer.class);
        tq.setParameter("lastname", "%n");
        List<Customer> customerList = tq.getResultList();

        customerList.forEach(System.out::println);
    }

    public static void main(String[] args) {
        JPAMain main = new JPAMain();
        main.connect();
        //main.initDB();
        main.testDB();
        main.disconnect();
    }
}
