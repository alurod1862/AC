package classes;

import jakarta.persistence.*;

@Entity
public class institut {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codi")
    private String codi;
    @Basic
    @Column(name = "nom")
    private String nom;
    @Basic
    @Column(name = "adreca")
    private String adreca;
    @Basic
    @Column(name = "numero")
    private String numero;
    @Basic
    @Column(name = "codpostal")
    private Integer codpostal;
    @Basic
    @Column(name = "cod_m")
    private Integer codM;
    @ManyToOne
    @JoinColumn(name = "cod_m", referencedColumnName = "cod_m")
    private classes.poblacio poblacio;

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(Integer codpostal) {
        this.codpostal = codpostal;
    }

    public Integer getCodM() {
        return codM;
    }

    public void setCodM(Integer codM) {
        this.codM = codM;
    }

    public classes.poblacio getPoblacio() {
        return poblacio;
    }

    public void setPoblacio(classes.poblacio poblacio) {
        this.poblacio = poblacio;
    }
}
