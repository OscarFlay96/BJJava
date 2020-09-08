/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniludoteca.vista;

import java.awt.Graphics;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author jvigual
 */
public class ImagenCarta extends JPanel {
    public static final int ANCHO_CARTA = 200;
    public static final int ALTO_CARTA = 328;
    private static final String RUTA_TRASERA = "images" + File.separatorChar + "trasera.jpg";
    
    private String rutaImagen;
    
    public ImagenCarta(int x, int y) {
        this.rutaImagen = RUTA_TRASERA;
        this.setBounds(x, y, ANCHO_CARTA, ALTO_CARTA);
    }
    
    public ImagenCarta(String rutaImagen, int x, int y) {
        this.rutaImagen = rutaImagen;
        this.setBounds(x, y, ANCHO_CARTA, ALTO_CARTA);
    }
    
    @Override
    public void paint(Graphics lienzo) {
        ImageIcon imagen = new ImageIcon(this.rutaImagen);
        lienzo.drawImage(imagen.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
        this.setOpaque(false);
        super.paintComponent(lienzo);
    }
}
