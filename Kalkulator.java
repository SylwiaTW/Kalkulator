import javax.swing.*;
import java.awt.*;

public class Kalkulator {
    JFrame ramka=new JFrame("Kalkulator");
    JTextField wyswietlacz = new JTextField();
    Font czcionka = new Font("Arial", Font.BOLD,30);
    JPanel panel = new JPanel();

    JButton cyfra0 = new JButton("0");
    JButton cyfra1 = new JButton("1");
    JButton cyfra2 = new JButton("2");
    JButton cyfra3 = new JButton("3");
    JButton cyfra4 = new JButton("4");
    JButton cyfra5 = new JButton("5");
    JButton cyfra6 = new JButton("6");
    JButton cyfra7 = new JButton("7");
    JButton cyfra8 = new JButton("8");
    JButton cyfra9 = new JButton("9");
    JButton dodawanie = new JButton("+");
    JButton odejmowanie = new JButton("-");
    JButton mnozenie = new JButton("*");
    JButton dzielenie = new JButton("/");
    JButton przecinek = new JButton(",");
    JButton rownasie = new JButton("=");
    JButton potega = new JButton ("x\u00B2");
    JButton pierwiastek = new JButton ("\u221A");
    JButton del = new JButton("del");
    JButton clr = new JButton("clr");


    Kalkulator(){       //konstruktor
        interfejs();
        dodajPrzyciski();
    }

    public void interfejs(){
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setSize(650,600);
        ramka.setLayout(null);
        ramka.setVisible(true);
    }

    public void dodajPrzyciski(){
        wyswietlacz.setBounds(50, 35, 530, 50);
        wyswietlacz.setFont(czcionka);
        wyswietlacz.setEditable(false);
        ramka.add(wyswietlacz);

        panel.setBounds(50, 100, 530, 500);
        panel.setLayout(new GridLayout(6,5,6,6));
        panel.add(cyfra1);
        panel.add(cyfra2);
        panel.add(cyfra3);
        panel.add(mnozenie);
        panel.add(cyfra4);
        panel.add(cyfra5);
        panel.add(cyfra6);
        panel.add(dzielenie);
        panel.add(cyfra7);
        panel.add(cyfra8);
        panel.add(cyfra9);
        panel.add(odejmowanie);
        panel.add(cyfra0);
        panel.add(potega);
        panel.add(pierwiastek);
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
}
