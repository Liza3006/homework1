package hw_7;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;

class CustomArrayListTest {
  private CustomArrayList<String> list;

  @BeforeEach
  void setUp() {
    list = new CustomArrayList<>();
  }

  @Test
  void testAddAndGet() {
    list.add("1");
    list.add("2");
    assertEquals("1", list.get(0));
    assertEquals("2", list.get(1));
    assertEquals(2, list.size());
  }

  @Test
  void testAddNullThrowsException() {
    assertThrows(IllegalArgumentException.class, () -> list.add(null));
  }

  @Test
  void testGetInvalidIndexThrowsException() {
    list.add("1");
    assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
  }

  @Test
  void testRemove() {
    list.add("A");
    list.add("B");
    list.add("C");

    String removed = list.remove(1);
    assertEquals("B", removed);
    assertEquals(2, list.size());
    assertEquals("A", list.get(0));
  }

  @Test
  void testRemoveInvalidIndexThrowsException() {
    list.add("1");
    assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
  }

  @Test
  void testIsEmpty() {
    assertTrue(list.isEmpty());
    list.add("1");
    assertFalse(list.isEmpty());
  }

  @Test
  void testSize() {
    assertEquals(0, list.size());
    list.add("1");
    assertEquals(1, list.size());
  }

  @Test
  void testIterator() {
    list.add("A");
    list.add("B");

    Iterator<String> iterator = list.iterator();
    assertTrue(iterator.hasNext());
    assertEquals("A", iterator.next());
    assertEquals("B", iterator.next());
    assertFalse(iterator.hasNext());
  }

  @Test
  void testDynamicExpansion() {
    CustomArrayList<Integer> testList = new CustomArrayList<>();

    for (int i = 0; i < 20; i++) {
      testList.add(i);
    }

    assertEquals(20, testList.size());
    assertEquals(19, testList.get(19));
  }
}