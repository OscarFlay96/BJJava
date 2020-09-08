/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniludoteca.modelo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author jvigual
 */
public class Mazo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private LinkedList<Carta> cartas;
    
    public Mazo() {
        this.cartas = new LinkedList<>();
    }
    
    protected void agregarBaraja(Baraja baraja) {
        for (Carta carta: baraja.cartas()) {
            this.cartas.add(carta);
        }
    }
    
    public void mezclar() {
        LinkedList<Carta> cartasMezcladas = new LinkedList<>();
        
        Random selectorCartaAleatoria = new Random();
        while (!this.cartas.isEmpty()) {
            int i = selectorCartaAleatoria.nextInt(this.cartas.size());
            cartasMezcladas.addFirst(this.cartas.get(i));
            this.cartas.remove(i);
        }
        
        this.cartas = cartasMezcladas;
    }
    
    public Carta primeraCarta() {
        return this.cartas.removeFirst();
    }
}
