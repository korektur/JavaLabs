package ru.ifmo.ctdev.akhundov.homework6;

public class Division extends BinaryOp {

    public Division(Expression left, Expression right) {
        super(left, right);
    }

    public double apply(double x, double y) {
        return x / y;
    }
}
