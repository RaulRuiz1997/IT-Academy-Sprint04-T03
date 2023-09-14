package exercici1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ticket {

    private LocalDate data;
    private List<Arbre> arbres = new ArrayList<>();
    private List<Flor> flors = new ArrayList<>();
    private List<Decoracio> decoracions = new ArrayList<>();
    private double preuTotal = 0;

    public Ticket(List<Arbre> arbres, List<Flor> flors, List<Decoracio> decoracions) {
        setData();
        this.arbres = arbres;
        this.flors = flors;
        this.decoracions = decoracions;
    }

    public LocalDate getData() {
        return data;
    }

    private void setData() {
        this.data = LocalDate.now();
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

    public List<Decoracio> getDecoracions() {
        return decoracions;
    }

    public void setDecoracions(List<Decoracio> decoracions) {
        this.decoracions = decoracions;
    }

    public double getPreuTotal() {
        return preuTotal;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "data=" + data +
                ", arbres=" + arbres +
                ", flors=" + flors +
                ", decoracions=" + decoracions +
                ", preuTotal=" + preuTotal +
                '}';
    }

}
