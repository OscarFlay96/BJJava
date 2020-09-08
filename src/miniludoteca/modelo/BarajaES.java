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
public class BarajaES extends Baraja {
    private static final String IMGS = "images" + File.separatorChar + "barajaES";
    private static final String EXT = ".jpg";
    
    public BarajaES() {
        for (CartaES.Palo palo: CartaES.Palo.values()) {
            String directorio = palo.toString().toLowerCase();
            for (int valor: CartaES.VALORES) {
                String rutaImagen = IMGS + File.separatorChar + directorio + File.separatorChar + valor + EXT;
                this.agregarCarta(new CartaES(valor, palo, rutaImagen));
            }
        }
    }
}
