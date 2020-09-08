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
public class JugadaBlackJack extends Jugada {
    private static final int AS_MENOR_VALOR = 1;
    private static final int AS_MAYOR_VALOR = 11;
    public static final int NFICHAS_MINIMO_APUESTA = 10;
    private static final int MENOR_VALOR_BANCA = 17;
    public static final double BENEFICIO = 1.5;
    
    public JugadaBlackJack(double apuesta) {
        super(new MazoBlackJack(), apuesta, new ManoBlackJack(), new ManoBlackJack());
        
        /*
         * Inicialización del Juego 
         */
        this.mazo().mezclar();

        this.manoJugador().repartirCartas(this.mazo());
        this.manoBanca().repartirCartas(this.mazo());
        this.manoBanca().ocultarCarta(); // Ocultamos una de las dos cartas de la banca
    }

    @Override
    public void jugarBanca() {
        while (this.manoBanca().valor() < MENOR_VALOR_BANCA) {
            Carta carta = this.manoBanca().pedirCarta(this.mazo());
            if (carta.esAs()) {
                if (((this.manoBanca().valor() + AS_MAYOR_VALOR) >= MENOR_VALOR_BANCA) && ((this.manoBanca().valor() + AS_MAYOR_VALOR) <= ManoBlackJack.MEJOR_VALOR)) {
                    carta.cambiarValor(AS_MAYOR_VALOR);
                } else {
                    carta.cambiarValor(AS_MENOR_VALOR);
                }
            }
        }
    }

    @Override
    public void jugarJugador() {
        this.manoJugador().pedirCarta(this.mazo());
    }
}
