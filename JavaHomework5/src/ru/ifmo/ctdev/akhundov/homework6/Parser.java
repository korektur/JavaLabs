package ru.ifmo.ctdev.akhundov.homework6;

public class Parser {

    private static Token PlusMinus(String s) {
        Token current = mulDiv(s);
        Expression acc = current.acc;

        while (current.rest.length() > 0) {
            if (current.rest.charAt(0) != '+' && current.rest.charAt(0) != '-') {
                break;
            }

            char sign = current.rest.charAt(0);
            String next = current.rest.substring(1);

            current = mulDiv(next);
            if (sign == '+') {
                acc = new Plus(acc, current.acc);
            } else {
                acc = new Minus(acc, current.acc);
            }
        }
        return new Token(acc, current.rest);
    }

    private static Token Bracket(String s) {
        char zeroChar = s.charAt(0);
        if (zeroChar == '(') {
            Token r = PlusMinus(s.substring(1));
            if (!r.rest.isEmpty() && r.rest.charAt(0) == ')') {
                r.rest = r.rest.substring(1);
            }
            return r;
        }
        return num(s);
    }

    private static Token mulDiv(String s) {
        Token current = Bracket(s);
        Expression acc = current.acc;
        while (true) {
            if (current.rest.length() == 0) {
                return current;
            }
            char sign = current.rest.charAt(0);
            if ((sign != '*' && sign != '/' && sign != '%')) {
                return current;
            }

            String next = current.rest.substring(1);
            Token right = Bracket(next);

            if (sign == '*') {
                acc = new Times(acc, right.acc);
            } else if (sign == '/') {
                acc = new Division(acc, right.acc);
            } else {
                acc = new Modulo(acc, right.acc);
            }

            current = new Token(acc, right.rest);
        }
    }

    private static Token num(String s) {
        int i = 0;
        boolean negative = false;
        if (s.charAt(0) == '-') {
            negative = true;
            s = s.substring(1);
        }
        if (Character.isDigit(s.charAt(i))) {

            while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '.')) {
                i++;
            }
            double number = Double.parseDouble(s.substring(0, i));
            if (negative) {
                number = -number;
            }
            String restPart = s.substring(i);

            return new Token(new Const(number), restPart);
        } else {
            String var = "";
            while (i < s.length() && Character.isAlphabetic(s.charAt(i))) {
                var += s.charAt(i);
                i++;
            }
            if (negative) {
                return new Token(new Minus(new Const(0), new Variable(var)), s.substring(i));
            }
            return new Token(new Variable(var), s.substring(i));
        }
    }

    public static Expression parse(String s) {
        return PlusMinus(s.replace(" ", "")).acc;
    }
}
