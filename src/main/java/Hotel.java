import controllers.FerReservaController;
import controllers.GestioController;
import file.FileManager;
import moduls.HotelH;
import controllers.CrearClientController;
import controllers.MenuController;
import panel.ViewHotel;

public class Hotel {
    public static void main(String[] args) {
        ViewHotel Vista = new ViewHotel();
        FileManager fm = new FileManager();
        HotelH Hotel = new HotelH("Hotel - Jofre", fm);
        CrearClientController CrearClientController = new CrearClientController(Vista, Hotel, fm);
        MenuController MenuController = new MenuController(Vista);
        FerReservaController FerReservaController = new FerReservaController(Vista, Hotel, fm);
        GestioController GestioController = new GestioController(Vista, Hotel, fm);
    }
}
