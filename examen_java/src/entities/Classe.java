package entities;

import java.util.List;

public class Classe {
    private int id;
    private Filiere Filiere;
    private Niveau Niveau;
    List<Inscription> inscription;
    public Classe(){
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Filiere getFiliere() {
        return Filiere;
    }
    public void setFiliere(Filiere filiere) {
        Filiere = filiere;
    }
    public Niveau getNiveau() {
        return Niveau;
    }
    public void setNiveau(entities.Niveau niveau) {
        Niveau = niveau;
    }
    
    
}
