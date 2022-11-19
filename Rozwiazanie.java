public class Rozwiazanie {

    public static double policz(String rownanie) {
        return new Object() {
            int pozycja = -1, znak;

            void kolejnyZnak() {
                znak = (++pozycja < rownanie.length()) ? rownanie.charAt(pozycja) : -1;
            }

            boolean usun(int doUsuniecia) {
                while (znak == ' ') kolejnyZnak();
                if (znak == doUsuniecia) {
                    kolejnyZnak();
                    return true;
                }
                return false;
            }

            double parse() {
                kolejnyZnak();
                double x = parseExpression();
                if (pozycja < rownanie.length()) throw new RuntimeException("Unexpected: " + (char)znak);
                return x;
            }


            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (usun('+')) x += parseTerm(); // addition
                    else if (usun('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (usun('*')) x *= parseFactor(); // multiplication
                    else if (usun('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (usun('+')) return +parseFactor(); // unary plus
                if (usun('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pozycja;
                if (usun('(')) { // parentheses
                    x = parseExpression();
                    if (!usun(')')) throw new RuntimeException("Missing ')'");
                } else if ((znak >= '0' && znak <= '9') || znak == '.') { // numbers
                    while ((znak >= '0' && znak <= '9') || znak == '.') kolejnyZnak();
                    x = Double.parseDouble(rownanie.substring(startPos, this.pozycja));
                } else if (znak >= 'a' && znak <= 'z') { // functions
                    while (znak >= 'a' && znak <= 'z') kolejnyZnak();
                    String func = rownanie.substring(startPos, this.pozycja);
                    if (usun('(')) {
                        x = parseExpression();
                        if (!usun(')')) throw new RuntimeException("Missing ')' after argument to " + func);
                    } else {
                        x = parseFactor();
                    }


                } else {
                    throw new RuntimeException("Unexpected: " + (char)znak);
                }


                return x;
            }
        }.parse();
    }


    }
