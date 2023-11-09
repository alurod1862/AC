package classes;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Collection;

@Entity
public class poblacio {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cod_m")
    private int codM;
    @Basic
    @Column(name = "nom")
    private String nom;
    @Basic
    @Column(name = "poblacio")
    private Integer habitants;
    @Basic
    @Column(name = "extensio")
    private BigDecimal extensio;
    @Basic
    @Column(name = "altura")
    private Integer altura;
    @Basic
    @Column(name = "longitud")
    private String longitud;
    @Basic
    @Column(name = "latitud")
    private String latitud;
    @Basic
    @Column(name = "llengua")
    private String llengua;
    @OneToMany(mappedBy = "poblacio")
    private Collection<institut> instituts;
    @ManyToOne
    @JoinColumn(name = "nom_c", referencedColumnName = "nom_c")
    private classes.comarca comarca;

    public int getCodM() {
        return codM;
    }

    public void setCodM(int codM) {
        this.codM = codM;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getHabitants() {
        return habitants;
    }

    public void setHabitants(Integer habitants) {
        this.habitants = habitants;
    }

    public BigDecimal getExtensio() {
        return extensio;
    }

    public void setExtensio(BigDecimal extensio) {
        this.extensio = extensio;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLlengua() {
        return llengua;
    }

    public void setLlengua(String llengua) {
        this.llengua = llengua;
    }

    public Collection<institut> getInstituts() {
        return instituts;
    }

    public void setInstituts(Collection<institut> instituts) {
        this.instituts = instituts;
    }

    public classes.comarca getComarca() {
        return comarca;
    }

    public void setComarca(classes.comarca comarca) {
        this.comarca = comarca;
    }
}
