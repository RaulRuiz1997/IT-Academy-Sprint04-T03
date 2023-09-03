package exercici1;

import java.util.List;

public class Floristeria {

    private String nom;
    private List<Arbre> arbres;
    private List<Flor> flors;
    private List<Decoracio> decoracio;

    public Floristeria(String nom, List<Arbre> arbres, List<Flor> flors, List<Decoracio> decoracio) {
        this.nom = nom;
        this.arbres = arbres;
        this.flors = flors;
        this.decoracio = decoracio;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Arbre> getArbres() {
        return arbres;
    }

    public void setArbres(List<Arbre> arbres) {
        this.arbres = arbres;
    }

    public List<Flor> getFlors() {
        return flors;
    }

    public void setFlors(List<Flor> flors) {
        this.flors = flors;
    }

    public List<Decoracio> getDecoracio() {
        return decoracio;
    }

    public void setDecoracio(List<Decoracio> decoracio) {
        this.decoracio = decoracio;
    }

    // Los siguientes 3 métodos es para obtener el stock de cada uno de los productos de la floristeria

    public int getStockArbres() {
        return arbres.size();
    }

    public int getStockFlors() {
        return flors.size();
    }

    public int getStockDecoracio() {
        return decoracio.size();
    }

    // Obtenemos el valor total de stock sumando todos los valores de todos los productos de la floristeria
    public double getValorTotalStock() {

        double valorTotal = 0;

        for (Arbre arbre : arbres) {
            valorTotal = arbre.getPreu();
        }

        for (Flor flor : flors) {
            valorTotal = flor.getPreu();
        }

        for (Decoracio decoracio1 : decoracio) {
            valorTotal = decoracio1.getPreu();
        }

        return valorTotal;

    }

    @Override
    public String toString() {
        return "Floristeria{" +
                "nom='" + nom + '\'' +
                ", arbres=" + arbres +
                ", flors=" + flors +
                ", decoracio=" + decoracio +
                '}';
    }

}
