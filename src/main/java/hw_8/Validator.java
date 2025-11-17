package hw_8;

import hw_8.annotations.Email;
import hw_8.annotations.NotNull;
import hw_8.annotations.Range;
import hw_8.annotations.Size;

import java.lang.reflect.Field;

public class Validator {

  public static ValidationResult validate(Object object) {
    ValidationResult result = new ValidationResult();

    if (object == null) {
      result.addError("Object is null");
      return result;
    }

    Class<?> clazz = object.getClass();
    Field[] fields = clazz.getDeclaredFields();

    for (Field field : fields) {
      field.setAccessible(true);

      try {
        Object value = field.get(object);

        // Проверка @NotNull
        if (field.isAnnotationPresent(NotNull.class)) {
          NotNull annotation = field.getAnnotation(NotNull.class);
          if (value == null) {
            result.addError(annotation.message());
          }
        }

        // Проверка @Size
        if (field.isAnnotationPresent(Size.class)) {
          Size annotation = field.getAnnotation(Size.class);
          if (value instanceof String) {
            String str = (String) value;
            int length = str.length();
            if (length < annotation.min() || length > annotation.max()) {
              result.addError(annotation.message());
            }
          }
        }

        // Проверка @Range
        if (field.isAnnotationPresent(Range.class)) {
          Range annotation = field.getAnnotation(Range.class);
          if (value instanceof Integer) {
            int num = (Integer) value;
            if (num < annotation.min() || num > annotation.max()) {
              result.addError(annotation.message());
            }
          }
        }

        // Проверка @Email
        if (field.isAnnotationPresent(Email.class)) {
          Email annotation = field.getAnnotation(Email.class);
          if (value instanceof String) {
            String email = (String) value;
            if (!email.contains("@") || !email.contains(".")) {
              result.addError(annotation.message());
            }
          }
        }

      } catch (Exception e) {
        result.addError("Error checking field: " + field.getName());
      }
    }

    return result;
  }
}

