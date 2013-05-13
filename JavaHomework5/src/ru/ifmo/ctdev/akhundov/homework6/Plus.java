package ru.ifmo.ctdev.akhundov.homework6;

public class Plus extends BinaryOp {

    public Plus(Expression left, Expression right) {
        super(left, right);
    }

    public double apply(double x, double y) {
        return x + y;
    }
    
    public String toString(int a){
        String ans = left.toString(0) + " + " + right.toString(0);
        if (a > 0){
            ans = "(" + ans + ")";
        }
        return ans;
    }
    
    protected Expression deepSimplify() {
        if (left.toString().equals(right.toString())){
            return new Times(new Const(2), left);
        }
        if ("0.0".equals(left.toString())){
            return right;
        }
        if ("0.0".equals(right.toString())){
            return left;
        }
        return this;
    }
} 
