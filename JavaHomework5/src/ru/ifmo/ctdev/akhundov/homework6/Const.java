package ru.ifmo.ctdev.akhundov.homework6;

import java.util.Map;

public class Const implements Expression {

    private double value;

    public Const(double value) {
        this.value = value;
    }

    public double evaluate(Map<String, Double> map) {
        return this.value;
    }
}
