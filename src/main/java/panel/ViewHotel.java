package panel;

import com.toedter.calendar.JCalendar;
import moduls.ClientH;
import moduls.HabitacioH;
import moduls.HotelH;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.time.LocalDate;

public class ViewHotel extends JFrame {

    public JPanel JP_panell_crear_client, JP_panell_menu, JP_panell_reserva, JP_gestio, JP_gestio_CRUD;
    public JLabel JL_titol1, JL_nom, JL_cognom, JL_dni, JL_sel_client, JL_sel_data, JL_sel_habita, JS_sel_element;
    public JTextField JTF_nom, JTF_cognom, JTF_dni;
    public JButton JB_reset, JB_ok, JB_crear_client, JB_fer_reserva, JB_gestio, JB_query, JB_confirmar;
    public DefaultListModel<ClientH> DLM_llistaClients;
    public DefaultListModel<HabitacioH> DLM_llistaHabitacions;
    public DefaultListModel<Object> DLM_gestio;
    public JList<ClientH> JLI_llistaClients;
    public JList<HabitacioH> JLI_llistaHabitacions;
    public JList<Object> JLI_gestio;
    public JCalendar JC_data_reserva;
    public JPopupMenu JPM_gestio;
    public JMenuItem JPM_JB_Gestio_habitacions, JPM_JB_Gestio_clients, JPM_JB_Gestio_reserves;
    public JButton IMG_read, IMG_create, IMG_update, IMG_delete;


    public ViewHotel() {
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setSize(new Dimension(701, 600));
        setTitle("Hotel");
        iniciar();
        setSize(new Dimension(700, 600));
    }

    public void iniciar() {
        loadPanell();
        load();
    }

    private void loadPanell() {
        JP_gestio_CRUD = new JPanel();
        JP_gestio_CRUD.setLayout(null);
        JP_gestio_CRUD.setBackground(Color.DARK_GRAY);
        JP_gestio_CRUD.setBounds(310, 0, 390, 500);
        getContentPane().add(JP_gestio_CRUD);
        JP_gestio_CRUD.setVisible(false);

        JP_gestio = new JPanel();
        JP_gestio.setLayout(null);
        JP_gestio.setBackground(Color.DARK_GRAY);
        JP_gestio.setBounds(0, 0, 310, 500);
        getContentPane().add(JP_gestio);
        JP_gestio.setVisible(false);

        JP_panell_reserva = new JPanel();
        JP_panell_reserva.setLayout(null);
        JP_panell_reserva.setBackground(Color.DARK_GRAY);
        JP_panell_reserva.setBounds(0, 0, 700, 500);
        getContentPane().add(JP_panell_reserva);
        JP_panell_reserva.setVisible(false);

        JP_panell_crear_client = new JPanel();
        JP_panell_crear_client.setLayout(null);
        JP_panell_crear_client.setBackground(Color.DARK_GRAY);
        JP_panell_crear_client.setBounds(0, 0, 700, 500);
        getContentPane().add(JP_panell_crear_client);
        JP_panell_crear_client.setVisible(true);

        JP_panell_menu = new JPanel();
        JP_panell_menu.setLayout(null);
        JP_panell_menu.setBackground(Color.GRAY);
        JP_panell_menu.setBounds(0, 700, 700, 150);
        getContentPane().add(JP_panell_menu);
        JP_panell_menu.setVisible(true);
    }

    private void load() {

        // Panell menú

        JB_crear_client = new JButton("Crear client");
        JB_crear_client.setBounds(50, 510, 130, 40);
        JB_crear_client.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        JB_crear_client.setVisible(true);
        JB_crear_client.setBackground(Color.LIGHT_GRAY);
        JB_crear_client.setFocusPainted(false);
        JB_crear_client.setBorder(null);
        JP_panell_menu.add(JB_crear_client);

        JB_fer_reserva = new JButton("Fer reserva");
        JB_fer_reserva.setBounds(200, 510, 130, 40);
        JB_fer_reserva.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        JB_fer_reserva.setVisible(true);
        JB_fer_reserva.setBackground(Color.LIGHT_GRAY);
        JB_fer_reserva.setFocusPainted(false);
        JB_fer_reserva.setBorder(null);
        JP_panell_menu.add(JB_fer_reserva);

        JB_gestio = new JButton("Gestió");
        JB_gestio.setBounds(350, 510, 130, 40);
        JB_gestio.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        JB_gestio.setVisible(true);
        JB_gestio.setBackground(Color.LIGHT_GRAY);
        JB_gestio.setFocusPainted(false);
        JB_gestio.setBorder(null);
        JP_panell_menu.add(JB_gestio);

        JB_query = new JButton("Query");
        JB_query.setBounds(500, 510, 130, 40);
        JB_query.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        JB_query.setVisible(true);
        JB_query.setBackground(Color.LIGHT_GRAY);
        JB_query.setFocusPainted(false);
        JB_query.setBorder(null);
        JP_panell_menu.add(JB_query);

        JPM_gestio = new JPopupMenu();
        JPM_JB_Gestio_habitacions = new JMenuItem("Gestió d'habitacions");
        JPM_JB_Gestio_clients = new JMenuItem("Gestió de clients");
        JPM_JB_Gestio_reserves = new JMenuItem("Gestió de reserves");
        JPM_gestio.add(JPM_JB_Gestio_habitacions);
        JPM_gestio.add(JPM_JB_Gestio_clients);
        JPM_gestio.add(JPM_JB_Gestio_reserves);
        JPM_gestio.setBackground(Color.GRAY);
        JPM_JB_Gestio_habitacions.setBackground(Color.GRAY);
        JPM_JB_Gestio_habitacions.setFocusPainted(false);
        JPM_JB_Gestio_habitacions.setBorder(null);
        JPM_JB_Gestio_clients.setBackground(Color.GRAY);
        JPM_JB_Gestio_clients.setFocusPainted(false);
        JPM_JB_Gestio_clients.setBorder(null);
        JPM_JB_Gestio_reserves.setBackground(Color.GRAY);
        JPM_JB_Gestio_reserves.setFocusPainted(false);
        JPM_JB_Gestio_reserves.setBorder(null);
        JPM_gestio.setBounds(600, 600, 100, 100);
        JP_panell_menu.add(JPM_gestio);

        // Panell crear client

        JL_titol1 = new JLabel("HOTEL - JOFRE", SwingConstants.CENTER);
        JL_titol1.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
        JL_titol1.setBounds(140, 0, 400, 100);
        JL_titol1.setForeground(Color.WHITE);
        JP_panell_crear_client.add(JL_titol1);

        JL_nom = new JLabel("Nom - ", SwingConstants.CENTER);
        JL_nom.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 30));
        JL_nom.setBounds(100, 100, 110, 100);
        JL_nom.setForeground(Color.WHITE);
        JP_panell_crear_client.add(JL_nom);

        JTF_nom = new JTextField();
        JTF_nom.setBounds(220, 130, 300, 40);
        JTF_nom.setFont(new Font("Arial", Font.PLAIN, 15));
        JTF_nom.setForeground(Color.BLACK);
        JTF_nom.setBackground(Color.LIGHT_GRAY);
        JTF_nom.setBorder(null);
        JP_panell_crear_client.add(JTF_nom);

        JL_cognom = new JLabel("Cognom -", SwingConstants.CENTER);
        JL_cognom.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 30));
        JL_cognom.setBounds(50, 170, 150, 100);
        JL_cognom.setForeground(Color.WHITE);
        JP_panell_crear_client.add(JL_cognom);

        JTF_cognom = new JTextField();
        JTF_cognom.setBounds(220, 200, 300, 40);
        JTF_cognom.setFont(new Font("Arial", Font.PLAIN, 15));
        JTF_cognom.setForeground(Color.BLACK);
        JTF_cognom.setBackground(Color.LIGHT_GRAY);
        JTF_cognom.setBorder(null);
        JP_panell_crear_client.add(JTF_cognom);

        JL_dni = new JLabel("DNI -", SwingConstants.CENTER);
        JL_dni.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 30));
        JL_dni.setBounds(100, 240, 100, 100);
        JL_dni.setForeground(Color.WHITE);
        JP_panell_crear_client.add(JL_dni);

        JTF_dni = new JTextField();
        JTF_dni.setBounds(220, 270, 300, 40);
        JTF_dni.setFont(new Font("Arial", Font.PLAIN, 15));
        JTF_dni.setForeground(Color.BLACK);
        JTF_dni.setBackground(Color.LIGHT_GRAY);
        JTF_dni.setBorder(null);
        JP_panell_crear_client.add(JTF_dni);

        JB_reset = new JButton("reset");
        JB_reset.setBounds(450, 340, 80, 30);
        JB_reset.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
        JB_reset.setVisible(true);
        JB_reset.setBackground(Color.GRAY);
        JB_reset.setFocusPainted(false);
        JB_reset.setBorder(null);
        JP_panell_crear_client.add(JB_reset);

        JB_ok = new JButton("OK");
        JB_ok.setBounds(310, 360, 60, 60);
        JB_ok.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        JB_ok.setVisible(true);
        JB_ok.setBackground(Color.GRAY);
        JB_ok.setFocusPainted(false);
        JB_ok.setBorder(null);
        JP_panell_crear_client.add(JB_ok);

        // Panell fer reserva

        DLM_llistaClients = new DefaultListModel<>();
        JL_sel_client = new JLabel("Sel·lecciona un client");
        JL_sel_client.setBounds(20, 50, 500, 50);
        JL_sel_client.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        JL_sel_client.setForeground(Color.WHITE);
        JL_sel_client.setVisible(true);
        JP_panell_reserva.add(JL_sel_client);

        JLI_llistaClients = new JList<>(DLM_llistaClients);
        JLI_llistaClients.setBounds(30, 100, 240, 250);
        JLI_llistaClients.setForeground(Color.GRAY);
        JLI_llistaClients.setBackground(Color.LIGHT_GRAY);
        JLI_llistaClients.setVisible(true);
        JScrollPane scrollPane = new JScrollPane(JLI_llistaClients, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(30, 100, 240, 250);
        scrollPane.setVisible(true);
        scrollPane.setBorder(null);
        JP_panell_reserva.add(scrollPane);

        JB_confirmar = new JButton("Confirmar reserva");
        JB_confirmar.setBounds(230, 430, 200, 50);
        JB_confirmar.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));
        JB_confirmar.setVisible(true);
        JB_confirmar.setBackground(Color.GRAY);
        JB_confirmar.setFocusPainted(false);
        JB_confirmar.setBorder(null);
        JB_confirmar.setEnabled(false);
        JP_panell_reserva.add(JB_confirmar);

        JL_sel_data = new JLabel("Sel·lecciona una data");
        JL_sel_data.setBounds(370, 10, 500, 50);
        JL_sel_data.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        JL_sel_data.setForeground(Color.WHITE);
        JL_sel_data.setVisible(true);
        JP_panell_reserva.add(JL_sel_data);

        JC_data_reserva = new JCalendar();
        JC_data_reserva.setBounds(370, 60, 240, 200);
        JC_data_reserva.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));
        JC_data_reserva.setVisible(true);
        JC_data_reserva.setBackground(Color.GRAY);
        JC_data_reserva.setBorder(null);
        JC_data_reserva.setTodayButtonVisible(true);
        JC_data_reserva.setTodayButtonText("Avui");
        JC_data_reserva.setMaxDayCharacters(1);
        Date data = java.util.Calendar.getInstance().getTime();
        JC_data_reserva.setMinSelectableDate(data);
        JP_panell_reserva.add(JC_data_reserva);

        JL_sel_habita = new JLabel("Sel·lecciona una habitació");
        JL_sel_habita.setBounds(340, 270, 500, 50);
        JL_sel_habita.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        JL_sel_habita.setForeground(Color.WHITE);
        JL_sel_habita.setVisible(true);
        JP_panell_reserva.add(JL_sel_habita);

        DLM_llistaHabitacions = new DefaultListModel<>();
        JLI_llistaHabitacions = new JList<>(DLM_llistaHabitacions);
        JLI_llistaHabitacions.setBounds(340, 320, 300, 90);
        JLI_llistaHabitacions.setForeground(Color.GRAY);
        JLI_llistaHabitacions.setBackground(Color.LIGHT_GRAY);
        JLI_llistaHabitacions.setVisible(true);
        JLI_llistaHabitacions.setVisibleRowCount(-1);
        JLI_llistaHabitacions.setFixedCellHeight(35);
        JLI_llistaHabitacions.setFixedCellWidth(50);
        JLI_llistaHabitacions.setLayoutOrientation(JList.VERTICAL_WRAP);
        JScrollPane scrollPane1 = new JScrollPane(JLI_llistaHabitacions, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane1.setBounds(340, 320, 300, 90);
        scrollPane1.setVisible(true);
        scrollPane1.setBorder(null);
        JP_panell_reserva.add(scrollPane1);

        // Panell gestió general

        DLM_gestio = new DefaultListModel<>();
        JLI_gestio = new JList<>(DLM_gestio);
        JLI_gestio.setBounds(30, 100, 240, 250);
        JLI_gestio.setForeground(Color.GRAY);
        JLI_gestio.setBackground(Color.LIGHT_GRAY);
        JLI_gestio.setVisible(true);
        JLI_gestio.setLayoutOrientation(JList.VERTICAL_WRAP);
        JScrollPane scrollPane2 = new JScrollPane(JLI_gestio, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane2.setBounds(30, 100, 240, 250);
        scrollPane2.setVisible(true);
        scrollPane2.setBorder(null);
        JP_gestio.add(scrollPane2);

        JS_sel_element = new JLabel("Sel·lecciona un element");
        JS_sel_element.setBounds(20, 50, 500, 50);
        JS_sel_element.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        JS_sel_element.setForeground(Color.WHITE);
        JS_sel_element.setVisible(true);
        JP_gestio.add(JS_sel_element);

        // Panell gestió de habitacions

        ImageIcon read = new ImageIcon("src/main/java/imatges/read.png");
        IMG_read = new JButton(read);
        IMG_read.setBounds(70, 100, 100,100);
        IMG_read.setVisible(true);
        IMG_read.setBorder(null);
        IMG_read.setBackground(null);
        IMG_read.setFocusPainted(false);
        JP_gestio_CRUD.add(IMG_read);

        ImageIcon create = new ImageIcon("src/main/java/imatges/create.png");
        IMG_create = new JButton(create);
        IMG_create.setBounds(70, 220, 100,100);
        IMG_create.setVisible(true);
        IMG_create.setBorder(null);
        IMG_create.setBackground(null);
        IMG_create.setFocusPainted(false);
        JP_gestio_CRUD.add(IMG_create);

        ImageIcon update = new ImageIcon("src/main/java/imatges/update.png");
        IMG_update = new JButton(update);
        IMG_update.setBounds(200, 100, 100,100);
        IMG_update.setVisible(true);
        IMG_update.setBorder(null);
        IMG_update.setBackground(null);
        IMG_update.setFocusPainted(false);
        JP_gestio_CRUD.add(IMG_update);

        ImageIcon delete = new ImageIcon("src/main/java/imatges/delete.png");
        IMG_delete = new JButton(delete);
        IMG_delete.setBounds(200, 220, 100,100);
        IMG_delete.setVisible(true);
        IMG_delete.setBorder(null);
        IMG_delete.setBackground(null);
        IMG_delete.setFocusPainted(false);
        JP_gestio_CRUD.add(IMG_delete);
    }
}

