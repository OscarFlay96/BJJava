/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniludoteca.modelo;

/**
 *
 * @author jvigual
 */
public class ResumenJuegoBlackJack extends ResumenJuego {
    private int partidasEmpatadas;

    public int partidasEmpatadas() {
        return this.partidasEmpatadas;
    }
 
    public void incrementarPartidasEmpatadas() {
        this.partidasEmpatadas += 1;
    }
}
