package ru.ifmo.ctdev.akhundov.homework6;

import java.util.Map;

public abstract class BinaryOp implements Expression {

    private Expression left, right;

    public BinaryOp(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public double evaluate(Map<String, Double> map) {
        return apply(left.evaluate(map), right.evaluate(map));
    }

    public abstract double apply(double x, double y);
}
