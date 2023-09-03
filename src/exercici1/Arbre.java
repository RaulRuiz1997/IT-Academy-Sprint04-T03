package exercici1;

public class Arbre {

    private String nom;
    private double alcada;
    private double preu;

    public Arbre(String nom, double alcada, double preu) {
        this.nom = nom;
        this.alcada = alcada;
        this.preu = preu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getAlcada() {
        return alcada;
    }

    public void setAlcada(double alcada) {
        this.alcada = alcada;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    @Override
    public String toString() {
        return "Arbre{" +
                "nom='" + nom + '\'' +
                ", alcada=" + alcada +
                ", preu=" + preu +
                '}';
    }

}
