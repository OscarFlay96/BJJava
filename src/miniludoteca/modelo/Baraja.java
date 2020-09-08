/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniludoteca.modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author jvigual
 */
public class Baraja implements Serializable {
    private static final long serialVersionUID = 1L;

    private ArrayList<Carta> cartas;
    
    public Baraja() {
        this.cartas = new ArrayList<>();
    }
    
    protected ArrayList<Carta> cartas() {
        return this.cartas;
    }
    
    protected void agregarCarta(Carta carta) {
        this.cartas.add(carta);
    }
}
