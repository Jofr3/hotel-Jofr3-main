package moduls;

import file.FileManager;

import java.util.ArrayList;

public class HotelH {
    private FileManager fileManager;
    public String nomHotel;
    public ArrayList<ClientH> llistaClients;
    public ArrayList<ReservaH> llistaReserves;
    public ArrayList<HabitacioH> llistaHabitacions;

    public HotelH(String nomHotel, FileManager fileManager) {
        this.fileManager = fileManager;
        this.nomHotel = nomHotel;
        llistaClients = new ArrayList<>();
        llistaReserves = new ArrayList<>();
        llistaHabitacions = new ArrayList<>();
    }

    public void addClient(ClientH client) {
        this.llistaClients.add(client);
        fileManager.nouClient(llistaClients);
    }

    public void addReserva(ReservaH reserva) {
        this.llistaReserves.add(reserva);
        fileManager.nouReserva(llistaReserves);
    }

    public void addHabitacio(HabitacioH habitacio){
        this.llistaHabitacions.add(habitacio);
        fileManager.nouHabitacio(llistaHabitacions);
    }

    public boolean dniExists(String dni) {
        for (ClientH c : llistaClients) {
            if (c.getDni().equals(dni)) {
                return true;
            }
        }
        return false;
    }

    public void buscarClient(String dni) {
        for (int i = 0; i < llistaClients.size(); i++) {
            if(dni.equals(llistaClients.get(i).getDni())){
                llistaClients.get(i).setTeReserva(true);
            }
        }
    }

    public void borrarClient(ClientH client) {
        fileManager.borrarClient(client);
    }

    public void borrarHabitacio(HabitacioH habitacio) {
        fileManager.borrarHabitacio(habitacio);
    }

    public void borrarReserva(ReservaH reserva) {
        fileManager.borrarReserva(reserva);
    }
}
