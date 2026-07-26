public class Demo{
    public static void main(String[] args){
        System.out.println("Hello, World!");

        // int status = PaymentStatus.SUCCESS;
        // System.out.println(status);
    }
}

// payment status -->success, failed , panding
//final

/*
Problem with this approach :
1. Type safety 
2. Poor Readabilty
3. No grouping odd related enitites
*/

class PaymentStatusConstants{

    // public static final int SUCCESS = 1;
    // public static final int FAILED = 2;
    // public static final int PENDING = 3;

    public static final String SUCCESS = "Success";
    public static final String FAILED = "Failed";
    public static final String PENDING = "Pending";
    
}

/**
 * Role
*/
class Role {
    public static final int USER = 1;
    public static final int ADMIN = 2;
}