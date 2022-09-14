package at.kaindorf.jpaintro;

import at.kaindorf.jpaintro.pojos.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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

    public static void main(String[] args) {
        JPAMain main = new JPAMain();
        main.connect();
        Customer customer = new Customer();
        main.disconnect();
    }
}
