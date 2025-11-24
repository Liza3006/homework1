package hw_11;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class BankTest {

  @Test
  void testNormal() {
    Bank bank = new Bank();
    BankAccount acc1 = new BankAccount(100);
    BankAccount acc2 = new BankAccount(50);

    bank.sendToAccount(acc1, acc2, 30);

    assert acc1.getBalance() == 70;
    assert acc2.getBalance() == 80;
  }

  @Test
  void testNotEnoughMoney() {
    Bank bank = new Bank();
    BankAccount acc1 = new BankAccount(10);
    BankAccount acc2 = new BankAccount(50);

    bank.sendToAccount(acc1, acc2, 20);

    assert acc1.getBalance() == 10;
    assert acc2.getBalance() == 50;
  }

  @Test
  @Timeout(2)
  void testDeadlock() throws InterruptedException {
    Bank bank = new Bank();
    BankAccount acc1 = new BankAccount(100);
    BankAccount acc2 = new BankAccount(100);

    Thread t1 = new Thread(() -> {
      bank.sendToAccountDeadlock(acc1, acc2, 10);
    });

    Thread t2 = new Thread(() -> {
      bank.sendToAccountDeadlock(acc2, acc1, 10);
    });

    t1.start();
    t2.start();
    t1.join();
    t2.join();
  }

  @Test
  void testMultiple() throws InterruptedException {
    Bank bank = new Bank();
    BankAccount acc1 = new BankAccount(100);
    BankAccount acc2 = new BankAccount(100);
    
    Thread t1 = new Thread(() -> {
      for (int i = 0; i < 5; i++) {
        bank.sendToAccount(acc1, acc2, 10);
      }
    });

    Thread t2 = new Thread(() -> {
      for (int i = 0; i < 5; i++) {
        bank.sendToAccount(acc2, acc1, 10);
      }
    });

    t1.start();
    t2.start();
    t1.join();
    t2.join();

    assert acc1.getBalance() + acc2.getBalance() == 200;
  }

}