package hw_8.annotations;

public @interface Range {
  long min();
  long max();
  String message();
}
