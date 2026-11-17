package fr.diginamic.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private LocalDateTime date;

    private double montant;

    @Column(nullable = false)
    private String motif;

    @ManyToOne
    @JoinColumn(name="id_cpt")
    private Compte compte;

    public Operation(){

    }

    public Operation(LocalDateTime date, double montant, String motif) {
        this.date = date;
        this.montant = montant;
        this.motif = motif;
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
     * Getter for date
     *
     * @return date
     */
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * Getter for montant
     *
     * @return montant
     */
    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    /**
     * Getter for motif
     *
     * @return motif
     */
    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    /**
     * Getter for compte
     *
     * @return compte
     */
    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
