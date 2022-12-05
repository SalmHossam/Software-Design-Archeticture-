import java.util.Scanner;

public class CreditCardPayment implements Payment{
    String creditID;
    public CreditCardPayment()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("please Enter credit no.");
        creditID=sc.nextLine();
    }
    public void pay(double a,int id){
        System.out.println(" thank you for paied "+a+"$  by card no."+creditID);

    }


}
