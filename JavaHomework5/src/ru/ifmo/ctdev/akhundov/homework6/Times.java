package ru.ifmo.ctdev.akhundov.homework6;

public class Times extends BinaryOp {

    public Times(Expression left, Expression right) {
        super(left, right);
    }

    public double apply(double x, double y) {
        return x * y;
    }
    
    public String toString(int a){
        String ans = left.toString(2) + " * " + right.toString(2);
        if (a > 2){
            ans = "(" + ans + ")";
        }
        return ans;
    }

    protected Expression deepSimplify() {
        if ("0.0".equals(left.toString()) || "0.0".equals(right.toString())){
            return new Const(0);
        }
        if ("1.0".equals(right.toString())){
            return left;
        }
        if ("1.0".equals(left.toString())){
            return right;
        }
        return this;
    }


    
    
}
