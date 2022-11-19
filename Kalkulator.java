import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.*;

public class Kalkulator implements ActionListener {

    double numer1 = 0, numer2 = 0, wynik = 0;
    char dzialanie;

    JFrame ramka = new JFrame("Kalkulator");
    JTextField wyswietlacz = new JTextField();
    JButton[] cyfry = new JButton[10];
    Font czcionka = new Font("Arial", Font.BOLD, 30);
    JPanel panel = new JPanel();

    //przyciski funkcyjne
    JButton dodawanie = new JButton("+");
    JButton odejmowanie = new JButton("-");
    JButton mnozenie = new JButton("*");
    JButton dzielenie = new JButton("/");
    JButton przecinek = new JButton(",");
    JButton rownasie = new JButton("=");
    JButton pierwiastek = new JButton("\u221A");
    JButton minus = new JButton("'-'");
    JButton del = new JButton("del");
    JButton clr = new JButton("clr");

    Kalkulator() {       //konstruktor
        dodawanie.addActionListener(this);
        odejmowanie.addActionListener(this);
        mnozenie.addActionListener(this);
        dzielenie.addActionListener(this);
        przecinek.addActionListener(this);
        rownasie.addActionListener(this);
        pierwiastek.addActionListener(this);
        minus.addActionListener(this);
        del.addActionListener(this);
        clr.addActionListener(this);

        dodawanie.setFont(czcionka);
        odejmowanie.setFont(czcionka);
        mnozenie.setFont(czcionka);
        dzielenie.setFont(czcionka);
        przecinek.setFont(czcionka);
        rownasie.setFont(czcionka);
        pierwiastek.setFont(czcionka);
        minus.setFont(czcionka);
        del.setFont(czcionka);
        clr.setFont(czcionka);

        //przyciski 0-9:
        for (int i = 0; i < 10; i++) {
            cyfry[i] = new JButton(Integer.toString(i));
            cyfry[i].addActionListener(this);
            cyfry[i].setFont(czcionka);
        }

        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setSize(650, 600);
        ramka.setLayout(null);
        ramka.setVisible(true);

        wyswietlacz.setBounds(50, 35, 530, 50);
        wyswietlacz.setFont(czcionka);
        wyswietlacz.setEditable(false);
        ramka.add(wyswietlacz);

        panel.setBounds(50, 100, 530, 500);
        panel.setLayout(new GridLayout(6, 5, 6, 6));
        panel.add(cyfry[1]);
        panel.add(cyfry[2]);
        panel.add(cyfry[3]);
        panel.add(mnozenie);
        panel.add(cyfry[4]);
        panel.add(cyfry[5]);
        panel.add(cyfry[6]);
        panel.add(dzielenie);
        panel.add(cyfry[7]);
        panel.add(cyfry[8]);
        panel.add(cyfry[9]);
        panel.add(odejmowanie);
        panel.add(cyfry[0]);
        panel.add(pierwiastek);
        panel.add(minus);
        panel.add(dodawanie);
        panel.add(del);
        panel.add(clr);
        panel.add(przecinek);
        panel.add(rownasie);

        ramka.add(panel);
    }


    public static void main(String[] args) {
        Kalkulator kalk = new Kalkulator();  // obiekt klasy kalkulator
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object input = e.getSource();

        for (int i = 0; i < 10; i++) {
            if (input == cyfry[i]) {
                wyswietlacz.setText(wyswietlacz.getText().concat(Integer.toString(i)));
            }
        }
        if (input == przecinek) {
            wyswietlacz.setText(wyswietlacz.getText().concat("."));
        } else if (input == dodawanie) {
            numer1=Double.valueOf(wyswietlacz.getText());
            wyswietlacz.setText("");
            dzialanie='+';
        } else if (input == odejmowanie) {
            numer1=Double.valueOf(wyswietlacz.getText());
            wyswietlacz.setText("");
            dzialanie='-';
        } else if (input == mnozenie) {
            numer1=Double.valueOf(wyswietlacz.getText());
            wyswietlacz.setText("");
            dzialanie='*';
        } else if (input == dzielenie) {
            numer1=Double.valueOf(wyswietlacz.getText());
            wyswietlacz.setText("");
            dzialanie='/';
        } else if (input == pierwiastek) {
            numer1=Double.valueOf(wyswietlacz.getText());
            dzialanie='p';
        } else if (input == minus) {
           double temp = Double.valueOf(wyswietlacz.getText());
           temp*=-1;
           wyswietlacz.setText(String.valueOf(temp));

        } else if (input == del) {
            wyswietlacz.setText("");
        } else if (input == clr) {
            try {
                wyswietlacz.setText(wyswietlacz.getText(0, wyswietlacz.getText().length() - 1));
            } catch (BadLocationException ex) {
                wyswietlacz.setText("error");
            }
        } else if (input == rownasie){
            numer2=Double.valueOf(wyswietlacz.getText());
            switch(dzialanie) {
                case '+' -> wynik = numer1 + numer2;
                case '-' -> wynik = numer1 - numer2;
                case '*' -> wynik = numer1 * numer2;
                case '/' -> wynik = numer1 / numer2;
                case 'p' -> wynik = sqrt(numer2);
            }

                wyswietlacz.setText(String.valueOf(wynik));


            }
    }


}

