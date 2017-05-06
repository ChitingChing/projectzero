package com.myprojects.projectzero;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Seeting
 */
public class MainController implements Initializable {

    @FXML
    private JFXHamburger hamburger;
    
    @FXML
    private JFXDrawer drawer;
    @FXML
    private AnchorPane root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            VBox vbox = FXMLLoader.load(getClass().getResource("/fxml/MenuOpciones.fxml"));
            drawer.setSidePane(vbox);
            
            HamburgerBackArrowBasicTransition burgertask = new HamburgerBackArrowBasicTransition(hamburger);
            
            burgertask.setRate(-1);
            hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
                burgertask.setRate(burgertask.getRate() * -1);
                burgertask.play();
                if (drawer.isShown()) {
                    drawer.close();
                } else {
                    drawer.open();
                }
                drawer.setOnDrawerClosed((event) -> drawer.toBack()); //On close bring to the back 
                drawer.setOnDrawerOpened((event) -> drawer.toFront());//On open bring to the front﻿

            });
            
            
        } catch (Exception ex) {
            System.out.println(ex.toString());

        }
    }

}
