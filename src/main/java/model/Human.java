package model;

public class Human {
    private String firstName;
    private String lastName;
    private int age;
    private boolean isWorking;

    // kon
    public Human(String firstName, String lastName, int age, boolean isWorking) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isWorking = isWorking;
    }

    // get
    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public String getLastName() {
        return lastName;
    }

    // set

    public void setWorking(boolean working) {
        isWorking = working;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
