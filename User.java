import java.util.Scanner;

public class User {
    private int ID,Pass;
    private String Name ,Email;
    private Service ser;
    private Transactions tr=new Transactions();
    private WalletPayment wall =new WalletPayment();
    private Scanner scn = new Scanner(System.in);



    public void applyservice(){
        int x;
        System.out.println("please choose service: \n1-Mobile charge\n2-Landline\n3-Internet Service\n4-Donations");
        x=scn.nextInt();
        if(x==1){
            ser=new Mobile_recharge();
            ser.selectService(ID);
        }
        if(x==2){
            ser=new Landline();
            ser.selectService(ID);
        }
        if(x==3){
            ser=new Internet_service();
            ser.selectService(ID);
        }
        if(x==4){
            ser=new Donations();
            ser.selectService(ID);
        }

    }
    public void get_discount(){
        double temp;

        ser=new Mobile_recharge();
        temp=ser.getDiscount();
        System.out.println("Mobile Recharger discount : "+temp);
        ser=new Landline();

        temp=ser.getDiscount();
        System.out.println("Landline discount : "+temp);

        ser=new Internet_service();
        temp=ser.getDiscount();
        System.out.println("Internet service : "+temp);

        ser=new Donations();
        temp=ser.getDiscount();
        System.out.println("Donations discount : "+temp);
    }
    public void wallet(){

        double temp;
        System.out.println("please enter amount :");
        temp=scn.nextDouble();
        wall.add(temp,ID);

    }
    public void history(){
        tr.show_Request(ID);
    }
    public void refund(){
        tr.createRefund(ID);
    }

    public void setPass(int pass) {
        Pass = pass;
    }

    public void setName(String name) {
        Name = name;

    }

    public void setEmail(String email) {
        Email = email;
    }

    public User(int ID, int pass, String name, String email) {
        this.ID = ID;
        Pass = pass;
        Name = name;
        Email = email;
        wall.add_WalletPayment(ID);
    }


    public String getEmail() {
        return Email;
    }

    public int getID() {
        return ID;
    }

    public int getPass() {
        return Pass;
    }

    public String getName() {
        return Name;
    }

}
