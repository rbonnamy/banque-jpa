package fr.diginamic.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class LivretA extends Compte {

    private double taux;

    public LivretA(String numero, double solde, double taux) {
        super(numero, solde);
        this.taux = taux;
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
