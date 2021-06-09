package moduls;

public class HabitacioH {
    private String planta; // A-B-C
    private int numero; //1-100 per planta
    private boolean disponible;

    public HabitacioH(String planta, int numero) {
        this.planta = planta;
        this.numero = numero;
        this.disponible = true;
    }

    public String getPlanta() {
        return planta;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return planta+"  -  "+numero;
    }
}
