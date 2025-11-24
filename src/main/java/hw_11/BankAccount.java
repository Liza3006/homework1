package hw_11;

public class BankAccount {
  private int balance;
  public BankAccount(int initialBalance) {
    this.balance = initialBalance;
  }

  public int getBalance() {
    return balance;
  }

  public void take(int amount) {
    balance -= amount;
  }

  public void add(int amount) {
    balance += amount;
  }
}
