package hw_6;

import java.util.*;

public class CollectionUtils {

  public static <T> List<T> mergeLists(List<? extends T> first, List<? extends T> second) {
    List<T> combined = new ArrayList<>();
    if (first != null) {
      combined.addAll(first);
    }
    if (second != null) {
      combined.addAll(second);
    }

    return combined;
  }


  public static <T> void addAll(List<? super T> target, List<? extends T> source) {
    if (target != null || source != null) {
      target.addAll(source);
    }
  }

  public static void main(String[] args) {
    final List<Integer> list1 = Arrays.asList(1, 2, 3);
    final List<Double> list2 = Arrays.asList(4.5, 5.6);
    final List<Number> merged = CollectionUtils.mergeLists(list1, list2);
    final List<Object> destination = new ArrayList<>();
    CollectionUtils.addAll(destination, list1);
  }
}