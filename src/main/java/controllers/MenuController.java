package controllers;

import panel.ViewHotel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuController implements ActionListener, MouseListener {
    private ViewHotel view;

    public MenuController(ViewHotel view) {
        this.view = view;

        this.view.JB_crear_client.addActionListener(this);
        this.view.JB_fer_reserva.addActionListener(this);
        this.view.JB_gestio.addActionListener(this);
        this.view.JB_query.addActionListener(this);
        this.view.JB_gestio.addMouseListener(this);
        this.view.JPM_JB_Gestio_habitacions.addActionListener(this);
        this.view.JPM_JB_Gestio_clients.addActionListener(this);
        this.view.JPM_JB_Gestio_reserves.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.JB_crear_client) {
            view.JP_panell_crear_client.setVisible(true);
            view.JP_panell_reserva.setVisible(false);
            view.JB_confirmar.setEnabled(false);
            view.JP_gestio.setVisible(false);
            view.JP_gestio_CRUD.setVisible(false);
        } else if (e.getSource() == view.JB_fer_reserva) {
            view.JP_panell_crear_client.setVisible(false);
            view.JP_panell_reserva.setVisible(true);
            view.JP_gestio.setVisible(false);
            view.JP_gestio_CRUD.setVisible(false);
        } else if (e.getSource() == view.JB_gestio) {
            view.JB_confirmar.setEnabled(false);
        } else if (e.getSource() == view.JB_query) {
            view.JP_panell_crear_client.setVisible(false);
            view.JP_panell_reserva.setVisible(false);
            view.JB_confirmar.setEnabled(false);
            view.JP_gestio.setVisible(false);
            view.JP_gestio_CRUD.setVisible(false);
        } else if (e.getSource() == view.JPM_JB_Gestio_habitacions) {
            view.JP_panell_crear_client.setVisible(false);
            view.JP_panell_reserva.setVisible(false);
            view.JB_confirmar.setEnabled(false);
            view.JP_gestio.setVisible(true);
            view.JP_gestio_CRUD.setVisible(true);
        } else if (e.getSource() == view.JPM_JB_Gestio_clients) {
            view.JP_panell_crear_client.setVisible(false);
            view.JP_panell_reserva.setVisible(false);
            view.JB_confirmar.setEnabled(false);
            view.JP_gestio.setVisible(true);
            view.JP_gestio_CRUD.setVisible(true);
        } else if (e.getSource() == view.JPM_JB_Gestio_reserves) {
            view.JP_panell_crear_client.setVisible(false);
            view.JP_panell_reserva.setVisible(false);
            view.JB_confirmar.setEnabled(false);
            view.JP_gestio.setVisible(true);
            view.JP_gestio_CRUD.setVisible(true);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == view.JB_gestio) {
            this.view.JPM_gestio.show(e.getComponent(), 0, -70);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == view.JB_gestio) {
            this.view.JPM_gestio.show(e.getComponent(), 0, -70);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
