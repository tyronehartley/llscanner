package lox;

import java.util.ArrayList;
import java.util.List;

class LoxRiver {
  final String name;
  final List<Double> series;                       // daily rainfall, editable
  final List<LoxRiver> upstream = new ArrayList<>(); // rivers flowing into this one
  double flow;                                     // the number literal passed downstream

  LoxRiver(String name, List<Double> series) {
    this.name = name;
    this.series = new ArrayList<>(series);
    recompute();
  }

  // Sum of this river's own rainfall (all days).
  double catchment() {
    return catchment(series.size());
  }

  // Sum of the first n days, e.g. catchment(3) for (0+0+1).
  double catchment(int days) {
    double sum = 0;
    for (int i = 0; i < Math.min(days, series.size()); i++) sum += series.get(i);
    return sum;
  }

  // Own catchment + flow from every upstream river.
  double recompute() {
    flow = catchment();
    for (LoxRiver r : upstream) flow += r.recompute();
    return flow;
  }

  // Editing the catchment
  void setDay(int day, double rain) {
    series.set(day, rain);
    recompute();
  }

  void addDay(double rain) {
    series.add(rain);
    recompute();
  }

  // 'source -> main' means main.connect(source)
  void connect(LoxRiver from) {
    upstream.add(from);
    recompute();
  }

  @Override
  public String toString() {
    return name + " " + series + " flow=" + flow;
  }
}