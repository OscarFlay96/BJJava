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
public class JugadaSieteYMedia extends Jugada {
    public static final int NFICHAS_MINIMO_APUESTA = 25;
    private static final int MENOR_VALOR_BANCA = 5;
    public static final double BENEFICIO = 2;

    public JugadaSieteYMedia(double apuesta) {
        super(new MazoSieteYMedia(), apuesta, new ManoSieteYMedia(), new ManoSieteYMedia());
        
        /*
         * Inicialización del Juego 
         */
        this.mazo().mezclar();
        this.manoJugador().repartirCartas(this.mazo());
        this.manoBanca().repartirCartas(this.mazo());
    }

    @Override
    public void jugarBanca() {
        while (this.manoBanca().valor() < MENOR_VALOR_BANCA) {
            this.manoBanca().pedirCarta(this.mazo());
        }    
    }

    @Override
    public void jugarJugador() {
        this.manoJugador().pedirCarta(this.mazo());
    }
}
