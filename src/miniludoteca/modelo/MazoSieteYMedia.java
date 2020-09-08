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
public class MazoSieteYMedia extends Mazo {
    private static final int BARAJAS = 1;
    
    public MazoSieteYMedia() {
        super();
        
        for (int n = 1; n <= BARAJAS; n++) {
            this.agregarBaraja(new BarajaES());
        }
    }
}
