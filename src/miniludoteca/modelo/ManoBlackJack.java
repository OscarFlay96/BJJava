/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniludoteca.modelo;

import java.util.Iterator;

/**
 *
 * @author jvigual
 */
public class ManoBlackJack extends Mano {
    private static final int VALOR_FIGURA = 10;
    public static final float MEJOR_VALOR = 21f;
    private static final int CARTAS_A_REPARTIR = 2;
    
    public ManoBlackJack() {
        super(MEJOR_VALOR, CARTAS_A_REPARTIR);
    }
    
    public boolean esBlackJack() {
        if (this.cartas().size() == 2) {
            return this.valor() == MEJOR_VALOR;
        }
        return false;
    }
    
    @Override
    public float valor() {
        float total = 0;
        for (Carta carta: this.cartas()) {
            if (carta.esFigura()) {
                total += VALOR_FIGURA;
            } else {
                total += carta.valor();
            }
        }
        return total;
    }
    
    public boolean hayAs() {
        boolean asEncontrado = false;
        Iterator<Carta> iteradorCartas = this.cartas().iterator();
        while ((!asEncontrado) || (iteradorCartas.hasNext())) {
            Carta carta = iteradorCartas.next();
            asEncontrado = carta.esAs();
        }
        return asEncontrado;
    }
}
