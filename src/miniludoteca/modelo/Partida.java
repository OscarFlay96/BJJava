/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniludoteca.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jvigual
 */
public class Partida implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final int FICHAS_PARA_APOSTAR = 100;
    
    private String juego;
    private int n;
    private Date fecha;
    private double fichas;
    private ArrayList<Jugada> jugadas;
    
    public Partida(String juego, int n, Date fecha) {
        this.juego = juego;
        this.n = n;
        this.fecha = fecha;
        this.fichas = FICHAS_PARA_APOSTAR;
        this.jugadas = new ArrayList<>();
    }
    
    public int n() {
        return this.n;
    }
    
    public double fichas() {
        return this.fichas;
    }
    
    @Override
    public String toString() {
        return this.n + ". " + this.juego + " (" + this.fecha + ")";
    }
    
    public void incrementarFichas(double fichas) {
        this.fichas += fichas;
    }
    
    public void decrementarFichas(double fichas) {
        this.fichas -= fichas;
    }
    
    public void agregarJugada(Jugada jugada) {
        this.jugadas.add(jugada);
    }
    
    public String resumenPartida() {
        String resultado = "Número total de jugadas: " + this.jugadas.size() + "\n\n";
        int i = 1;
        for (Jugada jugada: this.jugadas) {
            resultado += "Jugada " + i + ":\n";
            resultado += "- " + jugada.ganador() + " ha ganado la partida\n";
            resultado += "- La apuesta del jugador ha sido de " + jugada.apuesta() + " fichas\n";
            resultado += "- Mano Banca:\n";
            resultado += "* Valor: " + jugada.manoBanca().valor() + "\n";
            resultado += "* Cartas:\n";
            resultado += jugada.manoBanca() + "\n";
            resultado += "- Mano Jugador: " + jugada.manoJugador().valor() + "\n\n";
            resultado += "* Valor: " + jugada.manoJugador().valor() + "\n";
            resultado += "* Cartas:\n";
            resultado += jugada.manoJugador() + "\n";
            
            i += 1;
        }
        return resultado;
    }
}
