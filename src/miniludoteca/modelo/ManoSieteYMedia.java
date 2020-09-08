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
public class ManoSieteYMedia extends Mano {
    private static final float VALOR_FIGURA = 0.5f;
    private static final float MEJOR_VALOR = 7.5f;
    private static final int CARTAS_A_REPARTIR = 1;
    
    public ManoSieteYMedia() {
        super(MEJOR_VALOR, CARTAS_A_REPARTIR);
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
}
