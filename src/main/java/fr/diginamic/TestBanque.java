package fr.diginamic;

import fr.diginamic.entites.Adresse;
import fr.diginamic.entites.AssuranceVie;
import fr.diginamic.entites.Banque;
import fr.diginamic.entites.Client;
import fr.diginamic.entites.Compte;
import fr.diginamic.entites.LivretA;
import fr.diginamic.entites.Operation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestBanque {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("banque-jpa");
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Banque banque1 = new Banque("Grand Luxe");
        em.persist(banque1);

        Banque banque2 = new Banque("Super Banque");
        em.persist(banque2);

        Adresse adr1 = new Adresse(1, "rue des Poires", 44000, "Nantes");
        Adresse adr2 = new Adresse(2, "rue des Pommes", 34000, "Montpellier");
        Adresse adr3 = new Adresse(25, "rue des Cerises", 37000, "Tours");

        Client cli1 = new Client("LEE", "Pol", LocalDate.of(2000, 3, 28));
        cli1.setAdresse(adr1);
        em.persist(cli1);

        Client cli2 = new Client("LEE", "lil", LocalDate.of(2001, 7, 17));
        cli2.setAdresse(adr2);
        em.persist(cli2);

        Client cli3 = new Client("LEE", "Arg", LocalDate.of(2002, 12, 4));
        cli3.setAdresse(adr3);
        em.persist(cli2);

        LivretA la1 = new LivretA("FRLA00123", 15000.0, 2.25);
        em.persist(la1);

        AssuranceVie av1 = new AssuranceVie("FRAV00225", 25000.0, 2.25, LocalDate.of(2035, 12, 31));
        em.persist(av1);

        cli1.setBanque(banque1);
        cli2.setBanque(banque2);
        cli3.setBanque(banque2);

        // ICI se font les insertions dans la table ManyToMany comptes_clients
        // Les comptes et clients sont dans le contexte de persistence
        cli1.getComptes().add(la1); //=> insertion dans la table de liaison
        av1.getClients().add(cli2);

        Operation ope1 = new Operation(LocalDateTime.of(2025, 11, 28, 10, 23, 50), 15.5, "Retrait");
        ope1.setCompte(la1);
        em.persist(ope1);

        transaction.commit();
        em.close();
        factory.close();
    }
}
