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
public class MazoBlackJack extends Mazo {
    private static final int BARAJAS = 2;
    
    public MazoBlackJack() {
        super();
        
        for (int n = 1; n <= BARAJAS; n++) {
            this.agregarBaraja(new BarajaFR());
        }
    }
}
