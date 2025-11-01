package hw_6;

public class ArrayUtil {
  public static <T> int findFirst(T[] array, T element) {
    for (int i = 0; i < array.length; ++i) {
      if (array[i].equals(element)) {return i;}
    }
    return -1;
  }
}
