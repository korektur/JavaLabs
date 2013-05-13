package ru.ifmo.ctdev.akhundov.homework6;


public class Minus extends BinaryOp {

    public Minus(Expression left, Expression right) {
        super(left, right);
    }

    public double apply(double x, double y) {
        return x - y;
    }
    
    public String toString(int a){
        String ans = left.toString(0) + " - " + right.toString(1);
        if (a > 1){
            ans = "(" + ans + ")";
        }
        return ans;
    }

    protected Expression deepSimplify() {
        if (left.toString().equals(right.toString())){
            return new Const(0);
        }
        if ("0.0".equals(right.toString())){
            return left;
        }
        return this;
        
    }

    
}
