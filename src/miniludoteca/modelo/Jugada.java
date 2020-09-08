/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniludoteca.modelo;

import java.io.Serializable;

/**
 *
 * @author jvigual
 */
public abstract class Jugada implements Serializable {
    private static final long serialVersionUID = 1L;

    private Mazo mazo;
    private String ganador;
    private double apuesta;
    private Mano manoBanca;
    private Mano manoJugador;

    public Jugada(Mazo mazo, double apuesta, Mano manoBanca, Mano manoJugador) {
        this.mazo = mazo;
        this.apuesta = apuesta;
        this.manoBanca = manoBanca;
        this.manoJugador = manoJugador;
    }
    
    protected Mazo mazo() {
        return this.mazo;
    }
    
    public String ganador() {
        return this.ganador;
    }
    
    public double apuesta() {
        return this.apuesta;
    }
    
    public Mano manoBanca() {
        return this.manoBanca;
    }
    
    public Mano manoJugador() {
        return this.manoJugador;
    }
    
    public void establecerGanador(String ganador) {
        this.ganador = ganador;
    }
    
    public abstract void jugarBanca();
    
    public abstract void jugarJugador();
}
