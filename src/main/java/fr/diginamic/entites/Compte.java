package fr.diginamic.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String numero;


    private double solde;

    @ManyToMany
    @JoinTable(name="comptes_clients",
            joinColumns= @JoinColumn(name="id_cpt", referencedColumnName="id"),
            inverseJoinColumns= @JoinColumn(name="id_cli", referencedColumnName="id")
    )
    private List<Client> clients = new ArrayList<>();

    @OneToMany(mappedBy = "compte")
    private List<Operation> opes = new ArrayList<>();

    public Compte(){

    }

    public Compte(String numero, double solde) {
        this.numero = numero;
        this.solde = solde;
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
     * Getter for numero
     *
     * @return numero
     */
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Getter for solde
     *
     * @return solde
     */
    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    /**
     * Getter for clients
     *
     * @return clients
     */
    public List<Client> getClients() {
        return clients;
    }

    /**
     * Getter for opes
     *
     * @return opes
     */
    public List<Operation> getOpes() {
        return opes;
    }
}
