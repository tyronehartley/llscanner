package lox;

import java.util.ArrayList;
import java.util.List;

class LoxRiver {
    final String name;
    double flow;
    final List<Double> catchment;

    LoxRiver(String name, double flow) {
        this.name = name;
        this.flow = flow;
        this.catchment = new ArrayList<>();
    }

    LoxRiver confluence(LoxRiver other) {
        return new LoxRiver(name + "+" + other.name, flow + other.flow);
    }

    void receive(LoxRiver upstream) {
        this.flow += upstream.flow; 
        this.catchment.addAll(upstream.catchment);
    }

    void addCatchment(double value) {
        catchment.add(value);
        flow += value;
    }

    double catchmentTotal() {
        double sum = 0;
        for (double c : catchment) sum += c;
        return sum;
    }


    @Override
    public String toString() {
        return name + " (" + flow + ")";
    }
}