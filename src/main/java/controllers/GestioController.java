package controllers;

import file.FileManager;
import info.Mylib;
import moduls.ClientH;
import moduls.HabitacioH;
import moduls.HotelH;
import moduls.ReservaH;
import panel.ViewHotel;


import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestioController implements ActionListener, ListSelectionListener {
    private ViewHotel view;
    private HotelH hotel;
    private String tipus;
    private FileManager fileManager;

    public GestioController(ViewHotel view, HotelH hotel, FileManager fileManager) {
        this.view = view;
        this.hotel = hotel;
        this.fileManager = fileManager;

        this.view.JPM_JB_Gestio_habitacions.addActionListener(this);
        this.view.JPM_JB_Gestio_clients.addActionListener(this);
        this.view.JPM_JB_Gestio_reserves.addActionListener(this);

        this.view.IMG_read.addActionListener(this);
        this.view.IMG_update.addActionListener(this);
        this.view.IMG_create.addActionListener(this);
        this.view.IMG_delete.addActionListener(this);

        this.view.JLI_gestio.addListSelectionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.JPM_JB_Gestio_reserves) {
            tipus = "reserves";
        } else if (e.getSource() == view.JPM_JB_Gestio_clients) {
            tipus = "clients";
        } else if (e.getSource() == view.JPM_JB_Gestio_habitacions) {
            tipus = "habitacions";
        } else if (e.getSource() == view.IMG_create) {
            switch (tipus) {
                case "habitacions":
                    String[] options = {"A", "B", "C"};
                    String[] options1 = new String[100];
                    for (int i = 0; i < 100; i++) {
                        options1[i] = Integer.toString(i);
                    }
                    String pis = (String) JOptionPane.showInputDialog(null, "Introdueix el pis [A-B-C]:", "Crear habitació", 1, null, options, options[0]);
                    String numero = (String) JOptionPane.showInputDialog(null, "Introdueix el numero:", "Crear habitació", 1, null, options1, options1[0]);
                    if (pis != null || numero != null) {
                        JOptionPane.showMessageDialog(null, "Habitació creada correctament!", "Crear habitació", 1);
                        this.view.DLM_gestio.removeAllElements();
                        this.hotel.addHabitacio(new HabitacioH(pis, Integer.parseInt(numero)));
                        for (HabitacioH h : this.hotel.llistaHabitacions) {
                            this.view.DLM_gestio.addElement(h);
                        }
                    }
                    break;

                case "reserves":
                    view.JP_panell_crear_client.setVisible(false);
                    view.JP_panell_reserva.setVisible(true);
                    view.JP_gestio.setVisible(false);
                    view.JP_gestio_CRUD.setVisible(false);
                    break;

                case "clients":
                    String nom = (String) JOptionPane.showInputDialog(null, "Introdueix el nom del client:", "Crear client", 1);
                    while (!Mylib.nomCognomCheck(nom)) {
                        JOptionPane.showMessageDialog(null, "Format incorrecte!", "Crear client", 2);
                        nom = (String) JOptionPane.showInputDialog(null, "Introdueix el nom del client:", "Crear client", 1);
                    }
                    String cognom = (String) JOptionPane.showInputDialog(null, "Introdueix el cognom del client:", "Crear client", 1);
                    while (!Mylib.nomCognomCheck(cognom)) {
                        JOptionPane.showMessageDialog(null, "Format incorrecte!", "Crear client", 2);
                        cognom = (String) JOptionPane.showInputDialog(null, "Introdueix el cognom del client:", "Crear client", 1);
                    }
                    String dni = (String) JOptionPane.showInputDialog(null, "Introdueix el dni del client:", "Crear client", 1);
                    while (!Mylib.dniCheck(dni)) {
                        JOptionPane.showMessageDialog(null, "Format incorrecte!", "Crear client", 2);
                        dni = (String) JOptionPane.showInputDialog(null, "Introdueix el cognom del client:", "Crear client", 1);
                    }
                    this.hotel.addClient(new ClientH(nom, cognom, dni));
                    JOptionPane.showMessageDialog(null, "Client creat correctament!", "Crear client", 1);
                    this.view.DLM_gestio.removeAllElements();
                    for (ClientH c : this.hotel.llistaClients) {
                        this.view.DLM_gestio.addElement(c);
                    }
                    break;
            }

        } else if (e.getSource() == view.IMG_update) {
            switch (tipus) {
                case "habitacions":
                    JOptionPane.showMessageDialog(null, "Opció no disponible!", "Editar habitacio", 2);
                    break;
                case "reserves":
                    JOptionPane.showMessageDialog(null, "Opció no disponible!", "Editar reserva", 2);
                    break;
                case "clients":
                    if (view.JLI_gestio.getSelectedValue() != null) {
                        String nom = (String) JOptionPane.showInputDialog(null, "Introdueix el nom del client:", "Editar client", 1);
                        while (!Mylib.nomCognomCheck(nom)) {
                            JOptionPane.showMessageDialog(null, "Format incorrecte!", "Editar client", 2);
                            nom = (String) JOptionPane.showInputDialog(null, "Introdueix el nom del client:", "Editar client", 1);
                        }
                        String cognom = (String) JOptionPane.showInputDialog(null, "Introdueix el cognom del client:", "Editar client", 1);
                        while (!Mylib.nomCognomCheck(cognom)) {
                            JOptionPane.showMessageDialog(null, "Format incorrecte!", "Editar client", 2);
                            cognom = (String) JOptionPane.showInputDialog(null, "Introdueix el cognom del client:", "Editar client", 1);
                        }
                        String dni = (String) JOptionPane.showInputDialog(null, "Introdueix el dni del client:", "Editar client", 1);
                        while (!Mylib.dniCheck(dni)) {
                            JOptionPane.showMessageDialog(null, "Format incorrecte!", "Editar client", 2);
                            dni = (String) JOptionPane.showInputDialog(null, "Introdueix el cognom del client:", "Editar client", 1);
                        }
                        ClientH clientTemp = new ClientH(nom, cognom, dni);
                        this.fileManager.updateClient((ClientH) view.JLI_gestio.getSelectedValue(), clientTemp);
//                        this.hotel.llistaClients.get(view.JLI_gestio.getSelectedIndex()).setNom(nom);
//                        this.hotel.llistaClients.get(view.JLI_gestio.getSelectedIndex()).setCognom(cognom);
//                        this.hotel.llistaClients.get(view.JLI_gestio.getSelectedIndex()).setDni(dni);
                        JOptionPane.showMessageDialog(null, "Client actualitzat correctament!", "Editar client", 1);
                        this.view.DLM_gestio.removeAllElements();
                        for (ClientH c : this.hotel.llistaClients) {
                            this.view.DLM_gestio.addElement(c);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Sel·lecciona un element!", "Editar client", 2);
                    }
                    break;
            }

        } else if (e.getSource() == view.IMG_delete) {
            switch (tipus) {
                case "habitacions":
                    if (view.JLI_gestio.getSelectedValue() == null) {
                        JOptionPane.showMessageDialog(null, "Sel·lecciona un element!", "Eliminar habitacio", 2);
                    } else {
                        // BORRAR HABITACIO
                        hotel.borrarHabitacio((HabitacioH) view.JLI_gestio.getSelectedValue());
                        this.hotel.llistaHabitacions.remove(view.JLI_gestio.getSelectedValue());
                        JOptionPane.showMessageDialog(null, "Habitacio eliminada correctament", "Eliminar habitacio", 1);
                        this.view.DLM_gestio.removeAllElements();
                        for (HabitacioH h : this.hotel.llistaHabitacions) {
                            this.view.DLM_gestio.addElement(h);
                        }
                    }
                    break;
                case "reserves":
                    if (view.JLI_gestio.getSelectedValue() == null) {
                        JOptionPane.showMessageDialog(null, "Sel·lecciona un element!", "Eliminar reserva", 2);
                    } else {
                        // BORRAR RESERVES
                        hotel.borrarReserva((ReservaH) view.JLI_gestio.getSelectedValue());
                        this.hotel.llistaReserves.remove(view.JLI_gestio.getSelectedValue());
                        JOptionPane.showMessageDialog(null, "Reserva eliminada correctament", "Eliminar reserva", 1);
                        this.view.DLM_gestio.removeAllElements();
                        for (ReservaH r : this.hotel.llistaReserves) {
                            this.view.DLM_gestio.addElement(r);
                        }
                    }
                    break;
                case "clients":
                    if (view.JLI_gestio.getSelectedValue() == null) {
                        JOptionPane.showMessageDialog(null, "Sel·lecciona un element!", "Eliminar client", 2);
                    } else {
                        // BORRAR CLIENTS
                        hotel.borrarClient((ClientH) view.JLI_gestio.getSelectedValue());
                        this.hotel.llistaClients.remove(view.JLI_gestio.getSelectedValue());
                        JOptionPane.showMessageDialog(null, "Client eliminat correctament", "Eliminar client", 1);
                        this.view.DLM_gestio.removeAllElements();
                        for (ClientH c : this.hotel.llistaClients) {
                            this.view.DLM_gestio.addElement(c);
                        }
                    }
                    break;
            }
        } else if (e.getSource() == view.IMG_read) {
            switch (tipus) {
                case "habitacions":
                    JOptionPane.showMessageDialog(null, "Opció no disponible!", "Llegit habitacio", 2);
                    break;
                case "reserves":
                    JOptionPane.showMessageDialog(null, "Opció no disponible!", "Llegir reserva", 2);
                    break;
                case "clients":
                    JOptionPane.showMessageDialog(null, "Opció no disponible!", "Llegir clients", 2);
                    break;
            }
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }
}
