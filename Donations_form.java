import java.util.Scanner;

public class Donations_form extends Service_provider {
    private double pay_amount;
    private Payment pay;

    private String receipt;

    public Donations_form() {
    }

    public Donations_form(String receipt) {
        this.receipt = receipt;
    }

    public void create_form(int id,double discount) {
        if(discount==0){
            discount=1;
        }
        System.out.println("Welcome in " + receipt );
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the amount you would like to pay for the service:");
        setPay_amount(sc.nextDouble());
        while (getPay_amount() < 1) {
            System.out.println("Please enter a number greater than one:");
            setPay_amount(sc.nextDouble());
        }
        String info="Type : Donation ,Provider : "+receipt;
        Transactions temp=new Transactions(info,pay_amount*discount,id);
        System.out.println("please choose type of payment \n 1.cash\n 2.credit\n 3.wallet");
        int x=sc.nextInt();
        if(x==1){
            pay =new CashPayment();
            pay.pay(pay_amount*discount,id);

        }
        if(x==2){
            pay =new CreditCardPayment();
            pay.pay(pay_amount*discount,id);

        }
        if(x==3){
            pay =new WalletPayment();
            pay.pay(pay_amount*discount,id);

        }


    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getReceipt() {
        return receipt;
    }

    public double getPay_amount() {
        return pay_amount;
    }

    public void setPay_amount(double pay_amount) {
        this.pay_amount = pay_amount;
    }


}
