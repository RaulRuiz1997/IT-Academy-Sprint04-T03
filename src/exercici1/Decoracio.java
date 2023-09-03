package exercici1;

public class Decoracio {

    private TipusMaterial tipusMaterial;
    private double preu;

    public Decoracio(TipusMaterial tipusMaterial, double preu) {
        this.tipusMaterial = tipusMaterial;
        this.preu = preu;
    }

    public TipusMaterial getTipusMaterial() {
        return tipusMaterial;
    }

    public void setTipusMaterial(TipusMaterial tipusMaterial) {
        this.tipusMaterial = tipusMaterial;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    @Override
    public String toString() {
        return "Decoracio{" +
                "tipusMaterial=" + tipusMaterial +
                ", preu=" + preu +
                '}';
    }

}
