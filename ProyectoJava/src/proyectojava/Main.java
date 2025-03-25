/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojava;

import controlador.TareaController;
import vista.ConsolaVista;

/**
 *
 * @author GAMER
 */
public class Main {
    public static void main(String[] args) {
        ConsolaVista vista = new ConsolaVista();
        TareaController controlador = new TareaController(vista);
        controlador.iniciar();
    }

    
}
