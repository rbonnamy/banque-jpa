package fr.diginamic.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.time.LocalDate;

@Entity
public class AssuranceVie extends Compte {

    private double taux;

    @Column(name="date_fin", nullable = false)
    private LocalDate dateFin;

    public AssuranceVie(){

    }

    public AssuranceVie(String numero, double solde, double taux, LocalDate dateFin) {
        super(numero, solde);
        this.taux = taux;
        this.dateFin = dateFin;
    }

    /**
     * Getter for taux
     *
     * @return taux
     */
    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}
