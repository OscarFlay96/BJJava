/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniludoteca.modelo;

import java.io.File;

/**
 *
 * @author jvigual
 */
public class BarajaFR extends Baraja {
    private static final String IMGS = "images" + File.separatorChar + "barajaFR";
    private static final String EXT = ".png";
    
    public BarajaFR() {
        for (CartaFR.Palo palo: CartaFR.Palo.values()) {
            String directorio = palo.toString().toLowerCase();
            for (int valor: CartaFR.VALORES) {
                String rutaImagen = IMGS + File.separatorChar + directorio + File.separatorChar + valor + EXT;
                this.agregarCarta(new CartaFR(valor, palo, rutaImagen));
            }
        }
    }
}
