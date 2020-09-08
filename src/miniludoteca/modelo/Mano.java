/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniludoteca.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author jvigual
 */
public abstract class Mano implements Serializable {
    private static final long serialVersionUID = 1L;

    private ArrayList<Carta> cartas;
    private float mejorValor;
    private int cartasARepartir;
    
    public Mano(float mejorValor, int cartasARepartir) {
        this.cartas = new ArrayList<>();
        this.mejorValor = mejorValor;
        this.cartasARepartir = cartasARepartir;
    }
    
    public ArrayList<Carta> cartas() {
        return this.cartas;
    }
    
    @Override
    public String toString() {
        String resultado = "";
        for (Carta carta: this.cartas) {
            resultado += "o " + carta + "\n";
        }
        return resultado;
    }
    
    public void repartirCartas(Mazo mazo) {
        for (int n = 1; n <= this.cartasARepartir; n++) {
            this.cartas.add(mazo.primeraCarta());
        }
    }
    
    public Carta pedirCarta(Mazo mazo) {
        Carta carta = mazo.primeraCarta();
        this.cartas.add(carta);
        return carta;
    }
    
    public void ocultarCarta() {
        Random selectorCartaAleatoria = new Random();
        int i = selectorCartaAleatoria.nextInt(this.cartas.size());
        this.cartas.get(i).ocultar();
    }
    
    public abstract float valor();
    
    public boolean sobrepasaMejorValor() {
        return this.valor() > this.mejorValor;
    }
}
