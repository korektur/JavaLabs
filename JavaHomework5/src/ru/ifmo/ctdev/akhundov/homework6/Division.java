package ru.ifmo.ctdev.akhundov.homework6;

public class Division extends BinaryOp {

    public Division(Expression left, Expression right) {
        super(left, right);
    }

    public double apply(double x, double y) {
        return x / y;
    }
    
    public String toString(int a){
        String ans = left.toString(2) + " / " + right.toString(3);
        if (a == 4){
            ans = "(" + ans + ")";
        }
        return ans;
    }

    protected Expression deepSimplify() {
        if (left.toString().equals(right.toString())){
            return new Const(1);
        }
        if ("0.0".equals(left.toString())){
            return new Const(0);
        }
        if ("1.0".equals(right.toString())){
            return left;
        }
        return this;
    }

    

}
