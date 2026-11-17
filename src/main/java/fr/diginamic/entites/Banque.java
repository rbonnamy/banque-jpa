package fr.diginamic.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Banque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String nom;

    @OneToMany(mappedBy = "banque")
    private List<Client> clients = new ArrayList<>();

    public Banque(){

    }

    public Banque(String nom) {
        this.nom = nom;
    }

    /**
     * Getter for nom
     *
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter for id
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for clients
     *
     * @return clients
     */
    public List<Client> getClients() {
        return clients;
    }
}
