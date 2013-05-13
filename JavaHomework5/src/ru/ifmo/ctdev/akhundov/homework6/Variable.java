package ru.ifmo.ctdev.akhundov.homework6;

import java.util.Map;

public class Variable implements Expression {

    private String name;

    public Variable(String name) {
        this.name = name;
    }

    public double evaluate(Map<String, Double> map) {
        return map.get(name);
    }
    
    public String toString(int a){
        return name;
    }
    
    public String toString(){
        return name;
    }

    public Expression simplify() {
        return this;
    }
}
