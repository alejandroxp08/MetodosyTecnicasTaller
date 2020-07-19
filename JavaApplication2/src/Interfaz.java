/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author alejandroxp08
 */
public class Interfaz extends JFrame implements ActionListener {

    private JTextField textfield;
    private JLabel labell;
    private JButton boton1;

    public Interfaz(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        labell = new JLabel("Mensaje: ");
        labell.setBounds(15, 10, 100, 30);
        add(labell);

        textfield=new JTextField();
        textfield.setBounds(80, 16, 190, 20);
        add(textfield);

        boton1= new JButton("Mostrar");
        boton1.setBounds(10,60,100,30);
        add(boton1);
        boton1.addActionListener(this);
    }

    @Override

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==boton1){
            String cadena = textfield.getText();
            JOptionPane.showMessageDialog(null,cadena);
        }

    }

    public static void main(String[]args){
        Interfaz interfaz = new Interfaz();
        interfaz.setBounds(0, 0, 300, 150);
        interfaz.setVisible(true);
        interfaz.setLocationRelativeTo(null);
    }

}
