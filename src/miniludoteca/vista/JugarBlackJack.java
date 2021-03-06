/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniludoteca.vista;

import java.awt.Dimension;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import miniludoteca.modelo.Carta;
import miniludoteca.modelo.Historico;
import miniludoteca.modelo.JugadaBlackJack;
import miniludoteca.modelo.Jugador;
import miniludoteca.modelo.ManoBlackJack;
import miniludoteca.modelo.Partida;

/**
 *
 * @author jvigual
 */
public class JugarBlackJack extends javax.swing.JFrame {
    private static final int ESPACIO_CARTAS = 50;
    
    private Jugador jugador;
    private Historico historico;
    private Partida partida;
    private JugadaBlackJack jugada;
    
    public JugarBlackJack(Jugador jugador, Historico historico, int nPartida) {
        initComponents();
        
        this.jugador = jugador;
        this.historico = historico;
        this.partida = new Partida(Principal.BLACKJACK, nPartida, Calendar.getInstance().getTime());
        this.historico.agregarPartida(this.partida);
        this.historico.agregarJugador(jugador);
        
        this.jugador.decrementarFichasAcumuladas();
        
        this.nPartidaLabel.setText("Partida Nº" + nPartida);
        this.nombreLabel.setText(this.jugador.nombre());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                setVisible(false);
            }
        });
        
        this.comenzarJugada();
    }
    
    private void comenzarJugada() {        
        this.fichasLabel.setText(String.valueOf(this.partida.fichas()));
        SpinnerNumberModel modeloApuestaSpinner = new SpinnerNumberModel((double) JugadaBlackJack.NFICHAS_MINIMO_APUESTA, (double) JugadaBlackJack.NFICHAS_MINIMO_APUESTA, (double) this.partida.fichas(), (double) 1);
        JSpinner apuestaSpinner = new JSpinner(modeloApuestaSpinner);
        
        int opcion = JOptionPane.showOptionDialog(this, apuestaSpinner, "¿Cuál es tu Apuesta?", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (opcion == JOptionPane.OK_OPTION) {
            double apuesta = (double) apuestaSpinner.getValue();
            this.apuestaLabel.setText(String.valueOf(apuesta));
            JOptionPane.showMessageDialog(this, "¡Empieza el juego!", "¡Allá vamos!", JOptionPane.INFORMATION_MESSAGE);
            
            this.jugada = new JugadaBlackJack(apuesta);
            this.partida.agregarJugada(jugada);
            
            this.pedirCartaButton.setEnabled(true);
            this.pintarManoJugador();
            this.puntosJugadorLabel.setText(String.valueOf(this.jugada.manoJugador().valor()));
            this.pintarManoBanca();
            this.puntosBancaLabel.setText(String.valueOf(this.jugada.manoBanca().valor()));
        } else {
            this.setVisible(false);
        }
    }
    
    private void pintarManoJugador() {
        this.manoJugadorPanel.removeAll();
        
        int origenXCarta = this.manoJugadorPanel.getWidth() / 2 - (ImagenCarta.ANCHO_CARTA / 2);
        int origenYCarta = ESPACIO_CARTAS + this.manoJugadorPanel.getY();
        for (Carta carta: this.jugada.manoJugador().cartas()) {
            this.manoJugadorPanel.add(new ImagenCarta(carta.rutaImagen(), origenXCarta, origenYCarta));
            origenYCarta += ImagenCarta.ALTO_CARTA + ESPACIO_CARTAS;
        }
        this.manoJugadorPanel.setPreferredSize(new Dimension(this.manoJugadorPanel.getWidth(), origenYCarta));
        this.manoJugadorScrollPane.revalidate();
        this.manoJugadorScrollPane.repaint();
    }
    
    private void pintarManoBanca() {
        this.manoBancaPanel.removeAll();
        
        int origenXCarta = this.manoBancaPanel.getWidth() / 2 - (ImagenCarta.ANCHO_CARTA / 2);
        int origenYCarta = ESPACIO_CARTAS + this.manoBancaPanel.getY();
        for (Carta carta: this.jugada.manoBanca().cartas()) {
            if (carta.descubierta()) {
                this.manoBancaPanel.add(new ImagenCarta(carta.rutaImagen(), origenXCarta, origenYCarta));
            } else {
                this.manoBancaPanel.add(new ImagenCarta(origenXCarta, origenYCarta));
            }
            origenYCarta += ImagenCarta.ALTO_CARTA + ESPACIO_CARTAS;
        }
        this.manoBancaPanel.setPreferredSize(new Dimension(this.manoBancaPanel.getWidth(), origenYCarta));
        this.manoBancaScrollPane.revalidate();
        this.manoBancaScrollPane.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        mensajeNombreLabel = new javax.swing.JLabel();
        nombreLabel = new javax.swing.JLabel();
        mensajeApuestaLabel = new javax.swing.JLabel();
        mensajeFichasLabel = new javax.swing.JLabel();
        fichasLabel = new javax.swing.JLabel();
        apuestaLabel = new javax.swing.JLabel();
        nPartidaLabel = new javax.swing.JLabel();
        manoBancaLabel = new javax.swing.JLabel();
        manoJugadorScrollPane = new javax.swing.JScrollPane();
        manoJugadorPanel = new javax.swing.JPanel();
        manoBancaScrollPane = new javax.swing.JScrollPane();
        manoBancaPanel = new javax.swing.JPanel();
        mensajePuntosJugadorLabel = new javax.swing.JLabel();
        puntosJugadorLabel = new javax.swing.JLabel();
        mensajePuntosBancaLabel = new javax.swing.JLabel();
        puntosBancaLabel = new javax.swing.JLabel();
        pedirCartaButton = new javax.swing.JButton();
        plantarseButton = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("7 & 1/2");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setText("Tu mano es:");

        mensajeNombreLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        mensajeNombreLabel.setText("Nombre:");

        nombreLabel.setText("Javier Vergara Igual");

        mensajeApuestaLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        mensajeApuestaLabel.setText("Tu apuesta:");

        mensajeFichasLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        mensajeFichasLabel.setText("Fichas:");

        fichasLabel.setText("Fichas");

        apuestaLabel.setText("Apuesta");

        nPartidaLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        nPartidaLabel.setText("Partida Nº N");

        manoBancaLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        manoBancaLabel.setText("Banca:");

        manoJugadorPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout manoJugadorPanelLayout = new javax.swing.GroupLayout(manoJugadorPanel);
        manoJugadorPanel.setLayout(manoJugadorPanelLayout);
        manoJugadorPanelLayout.setHorizontalGroup(
            manoJugadorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 441, Short.MAX_VALUE)
        );
        manoJugadorPanelLayout.setVerticalGroup(
            manoJugadorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 379, Short.MAX_VALUE)
        );

        manoJugadorScrollPane.setViewportView(manoJugadorPanel);

        manoBancaPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout manoBancaPanelLayout = new javax.swing.GroupLayout(manoBancaPanel);
        manoBancaPanel.setLayout(manoBancaPanelLayout);
        manoBancaPanelLayout.setHorizontalGroup(
            manoBancaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 443, Short.MAX_VALUE)
        );
        manoBancaPanelLayout.setVerticalGroup(
            manoBancaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 379, Short.MAX_VALUE)
        );

        manoBancaScrollPane.setViewportView(manoBancaPanel);

        mensajePuntosJugadorLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        mensajePuntosJugadorLabel.setText("Puntos:");

        puntosJugadorLabel.setText("Puntos");

        mensajePuntosBancaLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        mensajePuntosBancaLabel.setText("Puntos:");

        puntosBancaLabel.setText("Puntos");

        pedirCartaButton.setText("Pedir Carta");
        pedirCartaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedirCartaButtonActionPerformed(evt);
            }
        });

        plantarseButton.setText("Plantarse");
        plantarseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plantarseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nPartidaLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mensajeNombreLabel)
                            .addComponent(mensajeFichasLabel)
                            .addComponent(mensajeApuestaLabel))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(apuestaLabel)
                            .addComponent(fichasLabel)
                            .addComponent(nombreLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(143, 143, 143)
                        .addComponent(pedirCartaButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(plantarseButton)
                        .addGap(34, 34, 34)
                        .addComponent(manoBancaLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(manoJugadorScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(mensajePuntosJugadorLabel)
                                .addGap(18, 18, 18)
                                .addComponent(puntosJugadorLabel)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(mensajePuntosBancaLabel)
                                .addGap(18, 18, 18)
                                .addComponent(puntosBancaLabel))
                            .addComponent(manoBancaScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {manoBancaScrollPane, manoJugadorScrollPane});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nPartidaLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mensajeNombreLabel)
                    .addComponent(nombreLabel))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mensajeFichasLabel)
                    .addComponent(fichasLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mensajeApuestaLabel)
                    .addComponent(apuestaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(manoBancaLabel)
                    .addComponent(pedirCartaButton)
                    .addComponent(plantarseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(manoJugadorScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manoBancaScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mensajePuntosJugadorLabel)
                    .addComponent(puntosJugadorLabel)
                    .addComponent(mensajePuntosBancaLabel)
                    .addComponent(puntosBancaLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {manoBancaScrollPane, manoJugadorScrollPane});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jugadaTerminada() {
        int opcion = JOptionPane.showConfirmDialog(this, "¿Quieres volver a jugar?", "Jugar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcion == JOptionPane.YES_OPTION) {
            if (this.partida.fichas() >= JugadaBlackJack.NFICHAS_MINIMO_APUESTA) {
                this.comenzarJugada();
            } else {
                JOptionPane.showMessageDialog(this, "La partida ha terminado. No tienes suficientes fichas para seguir jugando :(", "Partida Terminada", JOptionPane.INFORMATION_MESSAGE);
                this.jugador.actualizarFichasAcumuladas(partida.fichas());
                
                this.pedirCartaButton.setEnabled(false);
                this.plantarseButton.setEnabled(false);
            }
        } else {
            this.jugador.actualizarFichasAcumuladas(partida.fichas());
            
            this.pedirCartaButton.setEnabled(false);
            this.plantarseButton.setEnabled(false);
        }
    }
    
    private void partidaGanada() {
        this.jugada.establecerGanador(this.jugador.nombre());
        if (((ManoBlackJack)this.jugada.manoJugador()).esBlackJack()) {
            this.partida.incrementarFichas(this.jugada.apuesta() + (this.jugada.apuesta() * JugadaBlackJack.BENEFICIO));
        } else {
            this.partida.incrementarFichas(this.jugada.apuesta() * 2);
        }

        JOptionPane.showMessageDialog(this, "La jugada ha terminado. ¡Has ganado! :)", "Jugada Terminada", JOptionPane.INFORMATION_MESSAGE);
        this.jugador.resumenJuegoBlackJack().incrementarPartidasGanadas();
        this.jugadaTerminada();
    }
    
    private void partidaEmpatada() {
        this.jugada.establecerGanador("Empate");
        this.partida.incrementarFichas(this.jugada.apuesta());

        JOptionPane.showMessageDialog(this, "La jugada ha terminado. Ha quedado en tablas", "Jugada Terminada", JOptionPane.INFORMATION_MESSAGE);
        this.jugador.resumenJuegoBlackJack().incrementarPartidasEmpatadas();
        this.jugadaTerminada();
    }
  
    private void partidaPerdida() {
        this.jugada.establecerGanador("Banca");
        this.partida.decrementarFichas(this.jugada.apuesta());

        JOptionPane.showMessageDialog(this, "La jugada ha terminado. Ha ganado la banca :(", "Jugada Terminada", JOptionPane.INFORMATION_MESSAGE);
        this.jugador.resumenJuegoBlackJack().incrementarPartidasPerdidas();
        this.jugadaTerminada();
    }
    
    private void pedirCartaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedirCartaButtonActionPerformed
        this.jugada.jugarJugador();
        this.pintarManoJugador();
        this.puntosJugadorLabel.setText(String.valueOf(this.jugada.manoJugador().valor()));
        if (this.jugada.manoJugador().sobrepasaMejorValor()) {
            this.partidaPerdida();
        }
    }//GEN-LAST:event_pedirCartaButtonActionPerformed

    private void plantarseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plantarseButtonActionPerformed
        this.pedirCartaButton.setEnabled(false);
        
        this.jugada.jugarBanca();
        this.pintarManoBanca();
        this.puntosBancaLabel.setText(String.valueOf(this.jugada.manoBanca().valor()));
        if (this.jugada.manoBanca().sobrepasaMejorValor()) {
            this.partidaGanada();
        } else {
            if ((this.jugada.manoJugador().valor() < this.jugada.manoBanca().valor())) {
                this.partidaPerdida();
            } else if (this.jugada.manoJugador().valor() == this.jugada.manoBanca().valor()) {
                this.partidaEmpatada();
            } else {
                this.partidaGanada();
            }
        }
    }//GEN-LAST:event_plantarseButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apuestaLabel;
    private javax.swing.JLabel fichasLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel manoBancaLabel;
    private javax.swing.JPanel manoBancaPanel;
    private javax.swing.JScrollPane manoBancaScrollPane;
    private javax.swing.JPanel manoJugadorPanel;
    private javax.swing.JScrollPane manoJugadorScrollPane;
    private javax.swing.JLabel mensajeApuestaLabel;
    private javax.swing.JLabel mensajeFichasLabel;
    private javax.swing.JLabel mensajeNombreLabel;
    private javax.swing.JLabel mensajePuntosBancaLabel;
    private javax.swing.JLabel mensajePuntosJugadorLabel;
    private javax.swing.JLabel nPartidaLabel;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JButton pedirCartaButton;
    private javax.swing.JButton plantarseButton;
    private javax.swing.JLabel puntosBancaLabel;
    private javax.swing.JLabel puntosJugadorLabel;
    // End of variables declaration//GEN-END:variables
}
