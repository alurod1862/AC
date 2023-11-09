package classes;

import jakarta.persistence.*;

@Entity
public class comarca {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "nom_c")
    private String nomC;
    @Basic
    @Column(name = "provincia")
    private String provincia;

    public String getNomC() {
        return nomC;
    }

    public void setNomC(String nomC) {
        this.nomC = nomC;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
