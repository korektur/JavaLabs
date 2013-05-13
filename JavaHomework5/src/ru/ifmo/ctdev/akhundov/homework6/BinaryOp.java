package ru.ifmo.ctdev.akhundov.homework6;

import java.util.Map;

public abstract class BinaryOp implements Expression {

    protected Expression left, right;

    public BinaryOp(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public double evaluate(Map<String, Double> map) {
        return apply(left.evaluate(map), right.evaluate(map));
    }
    
    public Expression simplify() {
        left = left.simplify();
        right = right.simplify();
        if (left instanceof Const && right instanceof Const) {
            return new Const(this.evaluate(null));
        }
        return deepSimplify();
    }

    protected abstract double apply(double x, double y);

    public String toString() {
        return this.toString(0);
    }

    protected abstract Expression deepSimplify();
}
