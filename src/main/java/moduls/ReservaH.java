package moduls;

import java.util.Date;
import java.time.LocalDate;

public class ReservaH {
    private String nomClient, cognomClient, dni;
    private Date data;
    private HabitacioH habitacio;

    public ReservaH(String nomClient, String cognomClient, String dni, Date data, HabitacioH habitacio) {
        this.nomClient = nomClient;
        this.cognomClient = cognomClient;
        this.dni = dni;
        this.data = data;
        this.habitacio = habitacio;
    }

    public String getNomClient() {
        return nomClient;
    }

    public String getCognomClient() {
        return cognomClient;
    }

    public String getDni() {
        return dni;
    }

    public Date getData() {
        return data;
    }

    public HabitacioH getHabitacio() {
        return habitacio;
    }

    @Override
    public String toString() {
        return "Nom: " + nomClient+" "+cognomClient+" - DNI: "+dni+" - Habitacio: "+habitacio+" - Data: "+data;
    }
}
