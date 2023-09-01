package com.mycompany.paseoperroscod;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PaseoPerrosCod extends JFrame implements ActionListener{
    JLabel l1,l2,l3;
    String [] opciones = {"1","2","3","4","5"};
    JComboBox<String> comboBox = new JComboBox<>(opciones);
    JTextField t1;
    JButton boton;
    public static void main(String[] args) {
        PaseoPerrosCod perro = new PaseoPerrosCod();
    }
    public PaseoPerrosCod(){
        setBounds(400, 150, 600, 200);
        setLayout(new FlowLayout());
        l1 = new JLabel("Bienvenido, por favor ingrese los siguientes datos para continuar con el registro.");
        l2 = new JLabel("Seleccione el número de perros que desea pasear (Max 5)\n");
        comboBox = new JComboBox<>(opciones);
        l3 = new JLabel("Ingrese el número de horas de paseo");
        t1 = new JTextField(10);
        boton = new JButton("Siguiente");
        boton.addActionListener(this);
        add(l1);
        add(l2);
        add(comboBox);
        add(l3);
        add(t1);
        add(boton);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        if (accion.equals("Siguiente")) {
            double numPerro, horasP,tipo,costoG = 0,costoM = 0,costoP = 0,costoD,costoT1,costoT2;
            numPerro = Integer.parseInt((String) comboBox.getSelectedItem());
            horasP = Integer.parseInt(t1.getText());
            if (numPerro>1) {
                //horasP = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el número de horas que va a pasear a su(s) perro(s)"));
                for (int i = 0; i < numPerro; i++) {
                tipo = Integer.parseInt(JOptionPane.showInputDialog(this,"Ingresa el tipo de perro del perro (1 = grande, 2 = mediano, 3 = pequeño)"));
                if (tipo == 1) {
                    costoG = horasP * 10000+costoG;
                } else if(tipo == 2){
                    costoM = horasP *5000+costoM;
                } else if(tipo == 3){
                    costoP = horasP * 3000+costoP;
                }
            }
            costoD = (costoG+costoM+costoP)*0.10;
            costoT1 =(costoG+costoM+costoP)-costoD;
            JOptionPane.showMessageDialog(this, "El costo total es de :"+costoT1);
        } 
        else if(numPerro<=1){
            //horasP = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el número de horas que va a pasear a su(s) perro(s)"));
            tipo = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingresa el tipo de perro del perro (1 = grande, 2 = mediano, 3 = pequeño)"));
            if (tipo == 1) {
                costoG = horasP * 10000+costoG;
                } else if(tipo == 2){
                costoM = horasP *5000+costoM;
                } else if(tipo == 3){
                costoP = horasP * 3000+costoP;
                }
            costoT2 = costoG+costoM+costoP;
            JOptionPane.showMessageDialog(this, "Total a pagar :"+costoT2);
        }
        }
    }
    
}
