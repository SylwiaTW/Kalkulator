import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kalkulator implements ActionListener {

    double numer1=0, numer2=0, wynik=0;
    int obliczenia;

    Kalkulator(){       //konstruktor

        JFrame ramka=new JFrame("Kalkulator");
        JTextField wyswietlacz = new JTextField();
        JButton[] cyfry = new JButton[10];
        Font czcionka = new Font("Arial", Font.BOLD,30);
        JPanel panel = new JPanel();

        //przyciski funkcyjne
        JButton dodawanie = new JButton("+");
        JButton odejmowanie = new JButton("-");
        JButton mnozenie = new JButton("*");
        JButton dzielenie = new JButton("/");
        JButton przecinek = new JButton(",");
        JButton rownasie = new JButton("=");
        JButton nawias1 = new JButton ("(");
        JButton nawias2 = new JButton (")");
        JButton del = new JButton("del");
        JButton clr = new JButton("clr");

        dodawanie.addActionListener(this);
        odejmowanie.addActionListener(this);
        mnozenie.addActionListener(this);
        dzielenie.addActionListener(this);
        przecinek.addActionListener(this);
        rownasie.addActionListener(this);
        nawias1.addActionListener(this);
        nawias2.addActionListener(this);
        del.addActionListener(this);
        clr.addActionListener(this);

        dodawanie.setFont(czcionka);
        odejmowanie.setFont(czcionka);
        mnozenie.setFont(czcionka);
        dzielenie.setFont(czcionka);
        przecinek.setFont(czcionka);
        rownasie.setFont(czcionka);
        nawias1.setFont(czcionka);
        nawias2.setFont(czcionka);
        del.setFont(czcionka);
        clr.setFont(czcionka);

        //przyciski 0-9:
        for(int i=0; i<10; i++) {
            cyfry[i] = new JButton(String.valueOf(i));
            cyfry[i].addActionListener(this);
            cyfry[i].setFont(czcionka);
        }

        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setSize(650,600);
        ramka.setLayout(null);
        ramka.setVisible(true);

        wyswietlacz.setBounds(50, 35, 530, 50);
        wyswietlacz.setFont(czcionka);
        wyswietlacz.setEditable(false);
        ramka.add(wyswietlacz);

        panel.setBounds(50, 100, 530, 500);
        panel.setLayout(new GridLayout(6,5,6,6));
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
        panel.add(nawias1);
        panel.add(nawias2);
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


        }
}
