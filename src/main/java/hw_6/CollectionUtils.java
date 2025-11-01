package hw_6;

import java.util.ArrayList;
import java.util.List;

public class CollectionUtils{
  public static <T> void addAll(List<? super T> destination, List<? extends T> source) {
    if (destination == null || source == null) {return;}
    destination.addAll(source);
  }
  public static <T> List<T> mergeLists(List<? extends T> list1, List<? extends T> list2) {
    final List<T> mer = new ArrayList<>();

    if (list1 != null) {CollectionUtils.addAll(mer, list1);}
    
    if (list2 != null) {CollectionUtils.addAll(mer, list2);}

    return mer;
  }
}
