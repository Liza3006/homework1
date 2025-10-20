package hw_6;

public class Calculator<T extends Number> {
  double zero = Double.NaN;

  public double sum(T a, T b) {
    if (a == null || b == null) return zero;
    return a.doubleValue() + b.doubleValue();
  }

  public double subtract(T a, T b) {
    if (a == null || b == null) return zero;
    return a.doubleValue() - b.doubleValue();
  }

  public double multiply(T a, T b) {
    if (a == null || b == null) return zero;
    return a.doubleValue() * b.doubleValue();
  }

  public double divide(T a, T b) {
    if (a == null || b == null) return  zero;
    if (b.doubleValue() == 0) return zero;
    return a.doubleValue() / b.doubleValue();
  }



  public static void main(String[] args) {
    // пример использования
    final Calculator<Integer> intCalc = new Calculator<>();
    final double result = intCalc.sum(5, 3); // 8.0
    System.out.println(result);

    final Calculator<Double> doubleCalc = new Calculator<>();
    final double div = doubleCalc.divide(10.0, 4.0); // 2.5
    System.out.println(div);
  }
}