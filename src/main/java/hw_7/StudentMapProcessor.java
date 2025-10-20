package hw_7;

import java.util.*;

public class StudentMapProcessor {

  static class Student {
    int id;
    String name;
    double grade;
    public Student(int id, String name, double grade) {
      this.id = id;
      this.name = name;
      this.grade = grade;
    }
    public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;
      Student other = (Student) obj;
      return id == other.id && name.equals(other.name) && grade == other.grade;
    }

    public int hashCode() {
      return id + name.hashCode() + (int)grade;
    }

    public String toString() {
      return id + " " + name + " " + grade;
    }
  }

  public static void main(String[] args) {
    HashMap<Integer, Student> hashMap = new HashMap<>();
    hashMap.put(1, new Student(1, "A", 4.5));
    hashMap.put(2, new Student(2, "B", 3));

    TreeMap<Integer, Student> treeMap = new TreeMap<>(Collections.reverseOrder());
    treeMap.put(1, new Student(1, "A", 4.5));
    treeMap.put(2, new Student(2, "B", 3));

  }

  public static List<Student> findStudentsByGradeRange(Map<Integer, Student> map, double min, double max) {
    List<Student> result = new ArrayList<>();
    for (Student s : map.values()) {
      if (s.grade >= min && s.grade <= max) {
        result.add(s);
      }
    }
    return result;
  }

  public static List<Student> getTopNStudents(TreeMap<Integer, Student> map, int n) {
    List<Student> result = new ArrayList<>();
    int count = 0;
    for (Student student : map.values()) {
      if (count >= n) break;
      result.add(student);
      count++;
    }
    return result;
  }
}