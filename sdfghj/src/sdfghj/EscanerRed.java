package sdfghj;

/**
 * Trabajo Práctico - Escáner de Red (ENTREGA PARCIAL)
 * Curso: 5to año - Programación
 * Materia: Redes
 * Herramienta: Java (Eclipse IDE)
 * Descripción: Esta es una versión incompleta del escáner de red.
 * Permite ingresar un rango de IPs, realizar pings básicos y mostrar
 * los resultados en una tabla. Faltan mejoras que se entregarán en la versión final.
 */


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.InetAddress;

public class EscanerRed {
	
    JFrame ventana;
    JTextField campoInicio, campoFin;
    JTable tabla;
    DefaultTableModel modelo;
    JProgressBar barra;

    public static void main(String[] args) {
        EscanerRed app = new EscanerRed();
        app.crearInterfaz();
    }


    public void crearInterfaz() {
        ventana = new JFrame("Escaner de Red - Parcial");
        ventana.setSize(700, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        campoInicio = new JTextField(12);
        campoFin = new JTextField(12);
        JButton botonEscanear = new JButton("Escanear");

        panel.add(new JLabel("IP Inicio:"));
        panel.add(campoInicio);
        panel.add(new JLabel("IP Fin:"));
        panel.add(campoFin);
        panel.add(botonEscanear);

        modelo = new DefaultTableModel();
        modelo.addColumn("IP");
        modelo.addColumn("Activo");

        tabla = new JTable(modelo);
        barra = new JProgressBar();

        botonEscanear.addActionListener(this::iniciarEscaneo);

        ventana.add(panel, BorderLayout.NORTH);
        ventana.add(new JScrollPane(tabla), BorderLayout.CENTER);
        ventana.add(barra, BorderLayout.SOUTH);

        ventana.setVisible(true);
    }


    public void iniciarEscaneo(ActionEvent e) {
        String inicio = campoInicio.getText();
        String fin = campoFin.getText();

        if (!esIPValida(inicio) || !esIPValida(fin)) {
            JOptionPane.showMessageDialog(ventana, "Las IPs no son válidas");
            return;
        }

        new Thread(() -> escanear(inicio, fin)).start();
    }


    public void escanear(String ipInicio, String ipFin) {
        try {
            int desde = Integer.parseInt(ipInicio.substring(ipInicio.lastIndexOf('.') + 1));
            int hasta = Integer.parseInt(ipFin.substring(ipFin.lastIndexOf('.') + 1));
            String base = ipInicio.substring(0, ipInicio.lastIndexOf('.') + 1);

            barra.setMaximum(hasta - desde + 1);
            barra.setValue(0);
            modelo.setRowCount(0);

            for (int i = desde; i <= hasta; i++) {
                String ip = base + i;
                boolean activo = InetAddress.getByName(ip).isReachable(1000);
                modelo.addRow(new Object[]{ip, activo ? "SI" : "NO"});
                barra.setValue(i - desde + 1);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(ventana, "Error al escanear");
        }
    }

    
    public boolean esIPValida(String ip) {
        return ip.matches("(\\d{1,3}\\.){3}\\d{1,3}");
    }
}
