import java.sql.SQLOutput;
import java.util.ArrayList;

public class Rozwiazanie2  {

    public static double policz(String dzialanie){
        //String dzialanie = wyswietlacz.getText();
        //System.out.println(dzialanie.indexOf("("));


        int liczbadzialan=0;
        for(int i=0; i<dzialanie.length(); i++){
            String znak = dzialanie.substring(i,i+1);
            if (znak.equals("+")||znak.equals("-")||znak.equals("*")||znak.equals("/")){
                liczbadzialan++;
            }
        }
        ArrayList operatory = new ArrayList<Integer>();
        //int[] operatory = new int[liczbadzialan];
        for(int i=0; i<dzialanie.length(); i++){
            String znak = dzialanie.substring(i,i+1);
            if (znak.equals("+")||znak.equals("-")||znak.equals("*")||znak.equals("/")){
                operatory.add(i);
            }
        }
        operatory.add(0);

        int a=0;
        ArrayList liczby = new ArrayList<Double>();
        //Double [] liczby = new Double[liczbadzialan+1];
        for (int i = 0; i < liczbadzialan; i++) {
            liczby.add(Double.valueOf(dzialanie.substring(a, (Integer)operatory.get(i))));
            a=(Integer)operatory.get(i)+1;
        }
        liczby.add(Double.valueOf(dzialanie.substring(a)));
        liczby.add(0);


        System.out.println(liczby);
        System.out.println(operatory);


        double war1=0;
        try {
            for (int i = 0; i <= operatory.size()-1 ; ) {
                if (dzialanie.substring((Integer) operatory.get(i), (Integer) operatory.get(i) + 1).equals("*")) {
                    war1 = (double) liczby.get(i) * (double) liczby.get(i + 1);
                    liczby.set(i + 1, war1);
                    liczby.remove(i);
                    operatory.remove(i);



                } else if (dzialanie.substring((Integer) operatory.get(i), (Integer) operatory.get(i) + 1).equals("/")) {
                    war1 = (double) liczby.get(i) / (double) liczby.get(i + 1);
                    liczby.set(i + 1, war1);
                    liczby.remove(i);
                    operatory.remove(i);

                } else if (dzialanie.substring((Integer) operatory.get(i), (Integer) operatory.get(i) + 1).equals("+")) {
                    i++;
                } else if (dzialanie.substring((Integer) operatory.get(i), (Integer) operatory.get(i) + 1).equals("-")) {
                    i++;
                } else {

                }


            }
        }
        catch (IndexOutOfBoundsException iob) {


        }

        return 0;}
}



