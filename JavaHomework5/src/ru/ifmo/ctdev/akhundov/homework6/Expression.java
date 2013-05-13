package ru.ifmo.ctdev.akhundov.homework6;


import java.util.Map;


public interface Expression {

    public abstract double evaluate(Map<String, Double> map);
    
    public abstract String toString(int a);
    
    @Override
    public abstract String toString();
    
    public abstract Expression simplify();
}
