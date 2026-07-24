public class Demo {
    public static void main(String[] args) {
        // 1. Accessing a static member of the static inner class
        System.out.println("Static value: " + Outer.Inner.staticValue);

        // 2. Creating an instance of the static inner class
        // Note: We don't need an instance of 'Outer' to create 'Inner'
        Outer.Inner inner = new Outer.Inner();
        inner.display();

        // 3. Accessing instance members of Outer via a reference
        Outer outerInstance = new Outer();
        inner.showOuterInstance(outerInstance);
    }
}

class Outer {
    static String outerStaticField = "Outer Static Field";
    String outerInstanceField = "Outer Instance Field";

    static class Inner {
        static String staticValue = "Inner Static Value";

        void display() {
            // Static inner classes can access static members of the outer class directly
            System.out.println("Accessing: " + outerStaticField);

            // Cannot access outerInstanceField directly:
            // System.out.println(outerInstanceField); // This would cause a compilation
            // error
        }

        void showOuterInstance(Outer outer) {
            // To access non-static members, we must pass an instance of the outer class
            System.out.println("Accessing instance field: " + outer.outerInstanceField);
        }
    }
}

class BankAccount {
    private double balance = 1000.0;

    // Private non-static inner class
    private class TransactionLogger {
        void log(String action, double amount) {
            // Can access private members of the outer class directly
            System.out.println("Log: " + action + " of $" + amount);
            System.out.println("New Balance: " + balance);
        }
    }

    public void withdraw(double amount) {
        balance -= amount;
        TransactionLogger logger = new TransactionLogger();
        logger.log("Withdrawal", amount);
    }
}