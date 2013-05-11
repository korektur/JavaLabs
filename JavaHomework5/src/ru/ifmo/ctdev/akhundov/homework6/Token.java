package ru.ifmo.ctdev.akhundov.homework6;

public class Token {

    Expression acc;
    String rest;

    public Token(Expression acc, String rest) {
        this.acc = acc;
        this.rest = rest;
    }
}
