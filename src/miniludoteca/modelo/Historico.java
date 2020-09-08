/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniludoteca.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author jvigual
 */
public class Historico implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private static int partidasTotales = 1;
    
    private ArrayList<Jugador> jugadores;
    private ArrayList<Partida> partidas;
    
    public Historico() {
        this.jugadores = new ArrayList<>();
        this.partidas = new ArrayList<>();
    }
    
    public ArrayList<Jugador> jugadores() {
        return this.jugadores;
    }
    
    public ArrayList<Partida> partidas() {
        return this.partidas;
    }
    
    public static int partidasTotales() {
        return Historico.partidasTotales;
    }
    
    public void agregarJugador(Jugador jugador) {
        int i = this.jugadores.indexOf(jugador);
        if (i == -1) {
            this.jugadores.add(jugador);
        } else {
            this.jugadores.set(i, jugador);
        }
    }
    
    public void agregarPartida(Partida partida) {
        this.partidas.add(partida);
        
        Historico.partidasTotales++;
    }
    
    public void establecerPartidasTotales() {
        Historico.partidasTotales = this.partidas.size() + 1;
    }
    
    public Jugador buscarJugador(String nombre) {
        Jugador jugador = null;
        boolean encontrado = false;
        Iterator<Jugador> iteradorJugadores = this.jugadores.iterator();
        while ((!encontrado) && (iteradorJugadores.hasNext())) {
            jugador = iteradorJugadores.next();
            encontrado = jugador.esNombreIgualA(nombre);
        }
        
        if (!encontrado) {
            jugador = new Jugador(nombre);
        }
        
        return jugador;
    }
}
