/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniludoteca.modelo;

import java.io.Serializable;

/**
 *
 * @author jvigual
 */
public abstract class Carta implements Serializable {
    private static final long serialVersionUID = 1L;

    protected static final int AS = 1;
    private int valor;
    private String rutaImagen;
    private boolean descubierta;
    
    public Carta(int valor, String rutaImagen) {
        this.valor = valor;
        this.rutaImagen = rutaImagen;
        this.descubierta = true;
    }
    
    protected int valor() {
        return this.valor;
    }
    
    public String rutaImagen() {
        return this.rutaImagen;
    }
    
    public void cambiarValor(int nuevoValor) {
        this.valor = nuevoValor;
    }
    
    public boolean descubierta() {
        return this.descubierta;
    }
    
    public void ocultar() {
        this.descubierta = false;
    }
    
    public boolean esAs() {
        return this.valor == AS;
    }
    
    public abstract boolean esFigura();
}
