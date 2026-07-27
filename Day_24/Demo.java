public class Demo{
    public static void main(String[] args){
        // System.out.println("Hello World");
        Payment p = new DebitCard();
        p.pay();
    }
}


//polymorphism
interface Payment {
    void pay();
}

class CreditCard implements Payment {
    @Override
    public void pay() {
        System.out.println("Paying via credit card");
    }
}

class DebitCard implements Payment {
    @Override
    public void pay() {
        System.out.println("Paying via debit card");
    }
}