package ru.ifmo.ctdev.akhundov.homework6;

import java.util.Map;

public class Modulo extends BinaryOp {

    public Modulo(Expression left, Expression right) {
        super(left, right);
    }

    public double apply(double x, double y) {
        return x % y;
    }
}
