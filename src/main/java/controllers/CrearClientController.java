package controllers;

import file.FileManager;
import info.Mylib;
import moduls.ClientH;
import moduls.HabitacioH;
import moduls.HotelH;
import panel.ViewHotel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class CrearClientController implements ActionListener, KeyListener {
    private ViewHotel view;
    private HotelH hotel;
    private FileManager fileManager;

    public CrearClientController(ViewHotel view, HotelH hotel, FileManager fileManager) {
        this.view = view;
        this.hotel = hotel;
        this.fileManager = fileManager;

        this.view.JB_reset.addActionListener(this);
        this.view.JB_ok.addActionListener(this);
        this.view.JTF_nom.addKeyListener(this);
        this.view.JTF_cognom.addKeyListener(this);
        this.view.JTF_dni.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.JB_reset) {
            this.view.JTF_nom.setText(null);
            this.view.JTF_cognom.setText(null);
            this.view.JTF_dni.setText(null);

        } else if (e.getSource() == view.JB_ok) {
            if (this.view.JTF_nom.getText().equals("") || this.view.JTF_cognom.getText().equals("") || this.view.JTF_dni.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Falta informació!");
            } else {
                if (this.fileManager.comprovaDNI(this.view.JTF_dni.getText())) {
                  //  this.hotel.dniExists(this.view.JTF_dni.getText())
                    JOptionPane.showMessageDialog(null, "Aquest DNI ja està registrat!");
                } else {
                    this.hotel.addClient(new ClientH(this.view.JTF_nom.getText(), this.view.JTF_cognom.getText(), this.view.JTF_dni.getText()));
                    this.view.JTF_nom.setText(null);
                    this.view.JTF_cognom.setText(null);
                    this.view.JTF_dni.setText(null);
                    JOptionPane.showMessageDialog(null, "Client creat correctament!");
                }
            }
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
        if (e.getSource() == view.JTF_nom) {
            if (Mylib.nomCognomCheck(this.view.JTF_nom.getText())) {
                this.view.JTF_nom.setBorder(new LineBorder(Color.GREEN, 1, false));
                this.view.JB_ok.setEnabled(true);
            } else {
                this.view.JTF_nom.setBorder(new LineBorder(Color.RED, 1, false));
                this.view.JB_ok.setEnabled(false);
            }
        } else if (e.getSource() == view.JTF_cognom) {
            if (Mylib.nomCognomCheck(this.view.JTF_cognom.getText())) {
                this.view.JTF_cognom.setBorder(new LineBorder(Color.GREEN, 1, false));
                this.view.JB_ok.setEnabled(true);
            } else {
                this.view.JTF_cognom.setBorder(new LineBorder(Color.RED, 1, false));
                this.view.JB_ok.setEnabled(false);
            }
        } else if (e.getSource() == view.JTF_dni) {
            if (Mylib.dniCheck(this.view.JTF_dni.getText())) {
                this.view.JTF_dni.setBorder(new LineBorder(Color.GREEN, 1, false));
                this.view.JB_ok.setEnabled(true);
            } else {
                this.view.JTF_dni.setBorder(new LineBorder(Color.RED, 1, false));
                this.view.JB_ok.setEnabled(false);
            }
        }
    }
}
