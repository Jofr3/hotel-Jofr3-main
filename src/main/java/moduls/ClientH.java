package moduls;

public class ClientH {
    private String nom, cognom, dni;
    private boolean teReserva;

    public ClientH(String nom, String cognom, String dni) {
        this.nom = nom;
        this.cognom = cognom;
        this.dni = dni;
        this.teReserva = false;
    }

    public String getDni() {
        return dni;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setTeReserva(boolean teReserva) {
        this.teReserva = teReserva;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public boolean isTeReserva() {
        return teReserva;
    }

    @Override
    public String toString() {
        return "Nom:  "+nom+" "+cognom+"  -  DNI:  "+dni;
    }
}
