package hw_11;

public class Bank {
  public void sendToAccountDeadlock(BankAccount from, BankAccount to, int amount) {
    synchronized (from) {
      synchronized (to) {
        if (from.getBalance() >= amount) {
          from.take(amount);
          to.add(amount);
        }
      }
    }
  }
  public void sendToAccount(BankAccount from, BankAccount to, int amount) {
    BankAccount a = from;
    BankAccount b = to;

    if (System.identityHashCode(from) > System.identityHashCode(to)) {
      a = to;
      b = from;
    }

    synchronized (a) {
      synchronized (b) {
        if (from.getBalance() >= amount) {
          from.take(amount);
          to.add(amount);
        }
      }
    }
  }
}
