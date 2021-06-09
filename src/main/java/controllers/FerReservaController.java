package controllers;

import file.FileManager;
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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class FerReservaController implements ActionListener, KeyListener, ListSelectionListener, PropertyChangeListener {

    private ViewHotel view;
    private HotelH hotel;
    private FileManager fileManager;

    public FerReservaController(ViewHotel view, HotelH hotel, FileManager fileManager) {
        this.view = view;
        this.hotel = hotel;
        this.fileManager = fileManager;

        this.view.JB_fer_reserva.addActionListener(this);
        this.view.JB_confirmar.addActionListener(this);
        this.view.JLI_llistaClients.addListSelectionListener(this);
        this.view.JC_data_reserva.addPropertyChangeListener(this);
        this.view.JLI_llistaHabitacions.addListSelectionListener(this);
        this.view.JPM_JB_Gestio_habitacions.addActionListener(this);
        this.view.JPM_JB_Gestio_clients.addActionListener(this);
        this.view.JPM_JB_Gestio_reserves.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.JB_fer_reserva) {
            this.view.DLM_llistaClients.removeAllElements();
            ArrayList<ClientH> llistaClients = this.fileManager.llistarClients();
            int count = 0;
            for (ClientH c : llistaClients) {
                this.view.DLM_llistaClients.addElement(c);
                count++;
            }

            this.view.DLM_llistaHabitacions.removeAllElements();
            ArrayList<HabitacioH> llistaHabitacions = this.fileManager.llistarHabitacions();
            int count1 = 0;
            for (HabitacioH h : llistaHabitacions) {
                this.view.DLM_llistaHabitacions.addElement(h);
                count1++;
            }

        } else if (e.getSource() == view.JPM_JB_Gestio_habitacions) {
            this.view.DLM_gestio.removeAllElements();
            view.JLI_gestio.setVisibleRowCount(-1);
            view.JLI_gestio.setFixedCellHeight(35);
            view.JLI_gestio.setFixedCellWidth(50);
            ArrayList<HabitacioH> llistaHabitacions = this.fileManager.llistarHabitacions();
            for (HabitacioH h : llistaHabitacions) {
                this.view.DLM_gestio.addElement(h);
            }
        } else if (e.getSource() == view.JPM_JB_Gestio_clients) {
            this.view.DLM_gestio.removeAllElements();
            view.JLI_gestio.setVisibleRowCount(-1);
            view.JLI_gestio.setFixedCellHeight(-1);
            view.JLI_gestio.setFixedCellWidth(-1);
            ArrayList<ClientH> llistaClients = this.fileManager.llistarClients();
            for (ClientH c : llistaClients) {
                this.view.DLM_gestio.addElement(c);
            }
        } else if (e.getSource() == view.JPM_JB_Gestio_reserves) {
            this.view.DLM_gestio.removeAllElements();
            view.JLI_gestio.setVisibleRowCount(-1);
            view.JLI_gestio.setFixedCellHeight(-1);
            view.JLI_gestio.setFixedCellWidth(-1);
            for (ReservaH r : this.hotel.llistaReserves) {
                this.view.DLM_gestio.addElement(r);
            }

        } else if (e.getSource() == view.JB_confirmar) {
            this.hotel.buscarClient(this.view.JLI_llistaClients.getSelectedValue().getDni());
            this.hotel.addReserva(new ReservaH(this.view.JLI_llistaClients.getSelectedValue().getNom(), this.view.JLI_llistaClients.getSelectedValue().getCognom(), this.view.JLI_llistaClients.getSelectedValue().getDni(), this.view.JC_data_reserva.getDate(), this.view.JLI_llistaHabitacions.getSelectedValue()));
            this.view.DLM_llistaClients.removeElement(this.view.JLI_llistaClients.getSelectedValue());
            this.view.JLI_llistaHabitacions.getSelectedValue().setDisponible(false);
            this.view.DLM_llistaHabitacions.removeElement(this.view.JLI_llistaHabitacions.getSelectedValue());
            this.view.JB_confirmar.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Reserva feta correctament!");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getSource() == view.JLI_llistaClients) {
            if (this.view.JLI_llistaClients.getSelectedValue() != null && this.view.JC_data_reserva.getDate() != null && this.view.JLI_llistaHabitacions.getSelectedValue() != null) {
                this.view.JB_confirmar.setEnabled(true);
            }
        } else if (e.getSource() == view.JLI_llistaHabitacions) {
            if (this.view.JLI_llistaHabitacions.getSelectedValue() != null && this.view.JC_data_reserva.getDate() != null && this.view.JLI_llistaClients.getSelectedValue() != null) {
                this.view.JB_confirmar.setEnabled(true);
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getSource() == view.JC_data_reserva) {
            if (this.view.JC_data_reserva.getDate() != null && this.view.JLI_llistaClients.getSelectedValue() != null && this.view.JLI_llistaHabitacions.getSelectedValue() != null) {
                this.view.JB_confirmar.setEnabled(true);
            }
        }
    }
}
