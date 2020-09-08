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
public class CartaFR extends Carta {
    private static final int J = 11; // Sota
    private static final int Q = 12; // Reina
    private static final int K = 13; // Rey
    public static final int[] VALORES = {AS, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K};
    public enum Palo {
        Corazones, Diamantes, Picas, Treboles
    }
    
    private Palo palo;
    
    public CartaFR(int valor, Palo palo, String rutaImagen) {
        super(valor, rutaImagen);
        this.palo = palo;
    }
    
    public Palo palo() {
        return this.palo;
    }
    
    @Override
    public boolean esFigura() {
        return this.valor() == J || this.valor() == Q || this.valor() == K;
    }
}
