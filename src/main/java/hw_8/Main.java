package hw_8;


public class Main {
  public static void main(String[] args) {
    final User user = new User();

    final ValidationResult result = Validator.validate(user);

    if (!result.isValid()) {
      System.out.println("Ошибки валидации:");
      result.getErrors().forEach(System.out::println);
    }
  }
}
