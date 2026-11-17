package fr.diginamic.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Adresse {

    private int numero;
    private String rue;

    @Column(name="code_postal")
    private int codePostal;
    private String ville;

    public Adresse(){

    }

    public Adresse(int numero, String rue, int codePostal, String ville) {
        this.numero = numero;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    /**
     * Getter for numero
     *
     * @return numero
     */
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Getter for rue
     *
     * @return rue
     */
    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    /**
     * Getter for codePostal
     *
     * @return codePostal
     */
    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    /**
     * Getter for ville
     *
     * @return ville
     */
    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
