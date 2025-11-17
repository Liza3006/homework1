package hw_8;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {
    public static void main(String[] args) {
      User good = new User();
      good.setName("I");
      good.setEmail("i@mail.com");
      good.setAge(25);
      good.setPassword("1234");

      ValidationResult res1 = Validator.validate(good);
      System.out.println("Правильно: " + res1.isValid());
      System.out.println("Ошибки: " + res1.getErrors());
      System.out.println();


      System.out.println("@NotNull");
      User nullUser = new User();
      nullUser.setName(null);
      nullUser.setEmail(null);

      ValidationResult res2 = Validator.validate(nullUser);
      System.out.println("Правильно: " + res2.isValid());
      System.out.println("Ошибки: " + res2.getErrors());
      System.out.println();


      System.out.println("@Size ");
      User sizeUser = new User();
      sizeUser.setName("A"); // короткое
      sizeUser.setEmail("test@mail.com");
      sizeUser.setAge(25);
      sizeUser.setPassword("123"); //короткий

      ValidationResult res3 = Validator.validate(sizeUser);
      System.out.println("Правильно: " + res3.isValid());
      System.out.println("Ошибки: " + res3.getErrors());
      System.out.println();


      System.out.println("@Range");
      User rangeUser = new User();
      rangeUser.setName("Ivan");
      rangeUser.setEmail("test@mail.com");
      rangeUser.setAge(200); // слишком большой
      rangeUser.setPassword("123456");

      ValidationResult res4 = Validator.validate(rangeUser);
      System.out.println("Правильно: " + res4.isValid());
      System.out.println("Ошибки: " + res4.getErrors());
      System.out.println();


      System.out.println("@Email");
      User emailUser = new User();
      emailUser.setName("Ivan");
      emailUser.setEmail("apdkdsin"); // невалидный email
      emailUser.setAge(25);
      emailUser.setPassword("123456");

      ValidationResult res5 = Validator.validate(emailUser);
      System.out.println("Правильно: " + res5.isValid());
      System.out.println("Ошибки: " + res5.getErrors());
      System.out.println();


      System.out.println("Все сразу");
      User allBad = new User();
      allBad.setName("A"); // короткое
      allBad.setEmail("fpdksjs"); // неправильный
      allBad.setAge(200); // слишком большой
      allBad.setPassword("123"); // короткий

      ValidationResult res6 = Validator.validate(allBad);
      System.out.println("Правильно: " + res6.isValid());
      System.out.println("Ошибки: " + res6.getErrors());
      System.out.println();


      System.out.println("Null");
      ValidationResult res7 = Validator.validate(null);
      System.out.println("Правильно: " + res7.isValid());
      System.out.println("Ошибки: " + res7.getErrors());
  }
}