package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora de Números Complexos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize( 800,  400);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 6));

        JTextField inputField1 = new JTextField();
        JTextField inputField2 = new JTextField();
        JTextField inputField3 = new JTextField();
        JTextField inputField4 = new JTextField();
        JTextField outputField = new JTextField();
        JTextField outputField2 = new JTextField();
        JTextField outputField3 = new JTextField();
        outputField.setEditable(false);
        outputField2.setEditable(false);
        outputField2.setBorder(null);
        outputField3.setEditable(false);

        inputField1.setFont((new Font("Arial", Font.PLAIN, 15)));
        inputField2.setFont((new Font("Arial", Font.PLAIN, 15)));
        inputField3.setFont((new Font("Arial", Font.PLAIN, 15)));
        inputField4.setFont((new Font("Arial", Font.PLAIN, 15)));
        outputField.setFont((new Font("Arial", Font.PLAIN, 15)));

        JLabel complex1 = new JLabel("Números Reais:");
        complex1.setFont((new Font("Arial", Font.BOLD, 20)));
        JLabel complex2 = new JLabel("Números imaginários:");
        complex2.setFont((new Font("Arial", Font.BOLD, 20)));
        JLabel result = new JLabel("Resultado");
        result.setFont((new Font("Arial", Font.BOLD,  20)));
        JLabel result1 = new JLabel("Resultado");
        result1.setFont((new Font("Arial", Font.BOLD,  20)));
        JLabel imagin = new JLabel("i");
        JLabel imagin1 = new JLabel("i");
        JLabel label = new JLabel();
        label.setFont((new Font("Arial", Font.BOLD, 20)));
        JLabel label1 = new JLabel();
        label.setFont((new Font("Arial", Font.BOLD, 20)));


        panel.add(complex1);
        panel.add(complex2);
        panel.add(label);
        panel.add(inputField1);
        panel.add(inputField2);
        panel.add(imagin);
        panel.add(inputField3);
        panel.add(inputField4);
        panel.add(imagin1);
        panel.add(result);
        panel.add(result1);
        panel.add(label1);
        panel.add(outputField);
        panel.add(outputField3);

        String[] buttonLabels = {"Somar", "Subtrair", "Módulo"};


        for(String buttons: buttonLabels){
        JButton button = new JButton(buttons);



            button.setFont(new Font("Arial", Font.PLAIN, 30));
            panel.add(button);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    double numReal1, numReal2, result1=0, result2=0, imaginario1, imaginario2;
                    Complexo complexo = new Complexo();

                    try{
                        numReal1 = Double.parseDouble(inputField1.getText());
                        numReal2 = Double.parseDouble(inputField3.getText());
                        imaginario1 = Double.parseDouble(inputField2.getText());
                        imaginario2 = Double.parseDouble(inputField4.getText());


                        if (buttons.equals("Somar")){

                            result1 = complexo.somaReais(numReal1, numReal2);
                            result2 = complexo.somaImaginario(imaginario1, imaginario2);
                        }
                        else if (buttons.equals("Subtrair")){
                            result1 = complexo.subReais(numReal1, numReal2);
                            result2 = complexo.subImaginario(numReal1, numReal2);
                        }
                        else if (buttons.equals("Módulo")){
                            result2 = Complexo.modulo(numReal1, imaginario1);
                        }
                        outputField.setText(Double.toString(result1));
                        outputField3.setText(result2+"i");
                    }
                    catch (NumberFormatException ex){
                        outputField.setText("Erro: Entrada inválida");
                    }
                }
            });
        }
        frame.add(panel);
        frame.setVisible(true);
    }
}

//Resposta:
