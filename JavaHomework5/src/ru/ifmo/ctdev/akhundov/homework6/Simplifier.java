
package ru.ifmo.ctdev.akhundov.homework6;

public class Simplifier {
    String exp; 
    
    public Simplifier(Expression exp){
        this.exp = exp.simplify().toString(0);
    }
    
    public void print(){
        System.out.println(exp);
    } 
}
