import java.util.Scanner;

public class Admin {
    private int ID,Pass;
    private String Name ,Email;
    private Discount dis=new Overall_Discount();
    private Specific_Discount disc=new Specific_Discount();
    private Transactions tra=new Transactions();
    private Service ser;
    private Scanner scn = new Scanner(System.in);
 public Admin(){

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

    public Admin(int ID, int pass, String name, String email) {
        this.ID = ID;
        Pass = pass;
        Name = name;
        Email = email;
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

    public void add_discount(){
        int x;
        System.out.println("please choose service: \n1-Overall Discount\n2-Specific_Discount");
        x=scn.nextInt();
     if(x==1){
         System.out.println("please enter amount in fraction: ");
         double disco;
         disco=scn.nextDouble();
         dis=new Overall_Discount();
         dis.setDiscount(disco);
     }
     if (x==2){
         System.out.println("please enter amount in fraction: ");
         double disco;
         disco=scn.nextDouble();


         System.out.println("please choose service: \n1-Mobile charge\n2-Landline\n3-Internet Service\n4-Donations");
         x=scn.nextInt();

         if(x==1){
             disc.set_Service("mobile");
             disc.setDiscount(disco);
         }
         if(x==2){
             disc.set_Service("landline");
             disc.setDiscount(disco);
         }
         if(x==3){
             disc.set_Service("internet");
             disc.setDiscount(disco);
         }
         if(x==4){
             disc.set_Service("donation");
             disc.setDiscount(disco);
         }



     }

    }
    public void add_service(){
        int x;
        System.out.println("please choose service: \n1-Mobile charge\n2-Landline\n3-Internet Service\n4-Donations");
        x=scn.nextInt();

        if(x==1){
            ser=new Mobile_recharge();
            ser.createNewProvider();
        }
        if(x==2){
            ser=new Landline();
            ser.createNewProvider();
        }
        if(x==3){
            ser=new Internet_service();
            ser.createNewProvider();
        }
        if(x==4){
            ser=new Donations();
            ser.createNewProvider();
        }


    }
    public void request_refund(){
     tra.approveTransaction();
    }
    public void show_trans(){
     tra.list_transaction();
    }

}
