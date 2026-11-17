package fr.diginamic.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    @Column(name="date_naissance")
    private LocalDate dateNaissance;

    @ManyToOne
    @JoinColumn(name="id_ban")
    private Banque banque;

    @ManyToMany
    @JoinTable(name="comptes_clients",
            joinColumns= @JoinColumn(name="id_cli", referencedColumnName="id"),
            inverseJoinColumns= @JoinColumn(name="id_cpt", referencedColumnName="id")
    )
    private List<Compte> comptes  = new ArrayList<>();

    @Embedded
    private Adresse adresse;

    public Client(){

    }

    public Client(String nom, String prenom, LocalDate dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    /**
     * Getter for id
     *
     * @return id
     */
    public int getId() {
        return id;
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
     * Getter for prenom
     *
     * @return prenom
     */
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Getter for dateNaissance
     *
     * @return dateNaissance
     */
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * Getter for adresse
     *
     * @return adresse
     */
    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    /**
     * Getter for banque
     *
     * @return banque
     */
    public Banque getBanque() {
        return banque;
    }

    /**
     * Getter for comptes
     *
     * @return comptes
     */
    public List<Compte> getComptes() {
        return comptes;
    }
}
