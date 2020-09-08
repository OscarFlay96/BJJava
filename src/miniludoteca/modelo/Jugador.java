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
public class Jugador implements Comparable<Jugador>, Serializable {
    private static final long serialVersionUID = 1L;

    private static final int FICHAS_INICIALES = 100;
    
    private String nombre;
    private double fichasAcumuladas;
    private ResumenJuegoBlackJack resumenBlackJack;
    private ResumenJuego resumenSieteYMedia;
    
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.fichasAcumuladas = FICHAS_INICIALES;
        this.resumenBlackJack = new ResumenJuegoBlackJack();
        this.resumenSieteYMedia = new ResumenJuego();
    }
    
    public String nombre() {
        return this.nombre;
    }
    
    public double fichasAcumuladas() {
        return this.fichasAcumuladas;
    }
    
    public ResumenJuegoBlackJack resumenJuegoBlackJack() {
        return this.resumenBlackJack;
    }
    
    public ResumenJuego resumenJuego() {
        return this.resumenSieteYMedia;
    }
    
    @Override
    public String toString() {
        return this.nombre + ": [FA: " + this.fichasAcumuladas + 
                ", PGBJ: " + this.resumenBlackJack.partidasGanadas() + ", PEBJ: " + this.resumenBlackJack.partidasEmpatadas() + ", PPBJ: " + this.resumenBlackJack.partidasPerdidas() +
                ", PG7Y1/2: " + this.resumenSieteYMedia.partidasGanadas() + ", PP7Y1/2: " + this.resumenSieteYMedia.partidasPerdidas() +
                "]";
    }
    
    public void actualizarFichasAcumuladas(double fichas) {
        this.fichasAcumuladas += fichas;
    }
    
    public void decrementarFichasAcumuladas() {
        this.fichasAcumuladas -= Partida.FICHAS_PARA_APOSTAR;
    }
    
    public boolean esNombreIgualA(String nombre) {
        return this.nombre.equalsIgnoreCase(nombre);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }
        
        Jugador otroJugador = (Jugador) obj;
        return this.nombre.equalsIgnoreCase(otroJugador.nombre);
    }
    
    @Override
    public int compareTo(Jugador otroJugador) {
        int resultado = 0;
        if (this.fichasAcumuladas < otroJugador.fichasAcumuladas) {
            resultado = -1;
        } else if (this.fichasAcumuladas > otroJugador.fichasAcumuladas) {
            resultado = 1;
        }
        return resultado;
    }
}    
