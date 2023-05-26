import com.sun.jdi.Value;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

/**
 * <a href="https://www.geeksforgeeks.org/java-program-to-convert-currency-using-awt/">Conversor de Moeda</a>
 */

public class ConversorMoedas implements ActionListener {
        JFrame frame;
        JTextPane t1,t2,cotacao;
        JLabel label1,label2, label3, labelErro;
        JButton bt1,bt2,bt3;


        ConversorMoedas() {
            frame = new JFrame("Conversor de Moedas");

            label1 = new JLabel("Real:");
            label2 = new JLabel("Dolar:");
            label3 = new JLabel("Cotação: ");
            labelErro = new JLabel();

            cotacao = new JTextPane();
            t1 = new JTextPane();
            t2 = new JTextPane();

            labelErro = new JLabel();

            bt1 = new JButton("Real");
            bt2 = new JButton("Dolar");
            bt3 = new JButton("Fechar");

            label1.setBounds(50, 50, 50, 50);
            label2.setBounds(200, 50, 50, 50);
            label3.setBounds(50,10,200,50);

            t1.setBounds(90, 65, 50, 20);
            t2.setBounds(240, 65, 50, 20);
            cotacao.setBounds(100,25,50,20);
            bt1.setBounds(50, 100, 100, 20);
            bt2.setBounds(200, 100, 100, 20);
            bt3.setBounds(140, 180, 100, 20);

            labelErro.setBounds(50,100,300,100);

            Font fonte = new Font("Arial", Font.BOLD, 15);
            labelErro.setFont(fonte);
            labelErro.setForeground(Color.red);

            frame.setSize(400, 300);
            frame.add(label1);
            frame.add(label2);
            frame.add(label3);
            frame.add(t1);
            frame.add(t2);
            frame.add(cotacao);
            frame.add(bt1);
            frame.add(bt2);
            frame.add(bt3);
            frame.add(labelErro);

            frame.setLayout(null);
            frame.setVisible(true);

            bt1.addActionListener(this);
            bt2.addActionListener(this);
            bt3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                }
            });



            cotacao.setText("5.04");
        }
    @Override
    public void actionPerformed(ActionEvent e) {
            try {
                labelErro.setText("");
                String s1 =t1.getText();
                String s2 = t2.getText();
                String cotacao2 = cotacao.getText();
                double cotacao3 = Double.parseDouble(cotacao2);


                if (e.getSource() == bt1) {
                    double dolar = Double.parseDouble(s2);
                    t1.setText(String.format("%.2f", dolar * cotacao3));
                } else if (e.getSource() == bt2) {
                    double real = Double.parseDouble(s1);
                    t2.setText(String.format("%.2f",real / cotacao3));
                }
            } catch (NumberFormatException t){
                labelErro.setText("Número Inválido - Entre Novamente");
                System.err.println("Número Inválido" + t.getStackTrace());

            }
    }

    public static void main(String[] args) {
         new ConversorMoedas();
    }
}


