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
public class ResumenJuego implements Serializable {
    private static final long serialVersionUID = 1L;

    private int partidasGanadas;
    private int partidasPerdidas;
    
    public int partidasGanadas() {
        return this.partidasGanadas;
    }

    public int partidasPerdidas() {
        return this.partidasPerdidas;
    }
    
    public void incrementarPartidasGanadas() {
        this.partidasGanadas += 1;
    }
 
    public void incrementarPartidasPerdidas() {
        this.partidasPerdidas += 1;
    }
}
