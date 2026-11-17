package fr.diginamic.entites;

import jakarta.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Virement extends Operation {

    private String beneficiaire;

    public Virement(){

    }

    public Virement(LocalDateTime date, double montant, String motif, String beneficiaire) {
        super(date, montant, motif);
        this.beneficiaire = beneficiaire;
    }

    /**
     * Getter for beneficiaire
     *
     * @return beneficiaire
     */
    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }
}
