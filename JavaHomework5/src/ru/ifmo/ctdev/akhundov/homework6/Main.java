package ru.ifmo.ctdev.akhundov.homework6;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Double> map = new TreeMap<String, Double>();
        String expr = in.readLine();
        Expression x = Parser.parse(expr);
        while (true) {
            String[] parsed = in.readLine().split(" ");
            if (parsed.length < 3) {
                break;
            }
            double y = Double.parseDouble(parsed[2]);
            map.put(parsed[0], y);
        }
        System.out.println(x.evaluate(map));
    }
}
