package ru.ifmo.ctdev.akhundov.homework6;

import java.util.Map;

public class Const implements Expression {

    private double value;

    public Const(double value) {
        this.value = value;
    }

    public double evaluate(Map<String, Double> map) {
        return value;
    }

    public String toString(int a) {
        return String.valueOf(value);
    }
    
    public String toString(){
        return String.valueOf(value);
    }

    public Expression simplify() {
        return this;
    }
}
