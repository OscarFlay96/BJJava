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
public class CartaES extends Carta {
    private static final int SOTA = 10;
    private static final int CABALLO = 11;
    private static final int REY = 12;
    public static final int[] VALORES = {AS, 2, 3, 4, 5, 6, 7, SOTA, CABALLO, REY};
    public enum Palo {
        Bastos, Copas, Espadas, Oros
    }
    
    private Palo palo;
    
    public CartaES(int valor, Palo palo, String rutaImagen) {
        super(valor, rutaImagen);
        this.palo = palo;
    }
    
    public Palo palo() {
        return this.palo;
    }
    
    @Override
    public boolean esFigura() {
        return this.valor() == SOTA || this.valor() == CABALLO || this.valor() == REY;
    }
}
