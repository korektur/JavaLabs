package ru.ifmo.ctdev.akhundov.homework6;


public class Minus extends BinaryOp {

    public Minus(Expression left, Expression right) {
        super(left, right);
    }

    public double apply(double x, double y) {
        return x - y;
    }
}
