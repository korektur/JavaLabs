package ru.ifmo.ctdev.akhundov.homework6;

import java.util.Map;

public class Modulo extends BinaryOp {

    public Modulo(Expression left, Expression right) {
        super(left, right);
    }

    public double apply(double x, double y) {
        return x % y;
    }
    
    public String toString(int a) {
        String ans = left.toString(4) + " % " + right.toString(4);
        if (a == 3) {
            ans = "(" + ans + ")";
        }
        return ans;
    }

    protected Expression deepSimplify() {
        if (left.toString().equals(right.toString()) || 
                "1.0".equals(right.toString()) || "0.0".equals(left.toString())){
            return new Const(0);
        }
        return this;
    }

}
