import java.util.ArrayList;
import java.util.Scanner;

public class Mobile_recharge implements Service {
    public static double discount = 0.0;
    private static ArrayList<Mobile_form> mobile = new ArrayList<>();
    public static int zzzz=0;
    private Scanner scn = new Scanner(System.in);

    public Mobile_recharge() {
        if(zzzz==0){
            Mobile_form we= new Mobile_form("We");
            Mobile_form vodafone= new Mobile_form("Vodafone");
            Mobile_form orange= new Mobile_form("Orange");
            Mobile_form etisalat= new Mobile_form("Etisalat");
            mobile.add(we);
            mobile.add(vodafone);
            mobile.add(orange);
            mobile.add(etisalat);
            zzzz=1;

        }







    }
    public void createNewProvider(){
    int ok = 1 ;
        System.out.println("Please Enter Service Provider Name ");
        String Name= scn.next();



        for (Mobile_form value : mobile) {
            if (value.getReceipt().equals(Name)) {
                System.out.println("Service provider saved to the System before ");
                ok = 0;
                break;
            }
        }
        if (ok==1){

            Mobile_form temp= new Mobile_form(Name);
            mobile.add(temp);
            System.out.println("Service Provider Added Successful ");


        }


    }
    public void selectService(int id){
        int x=1;


        for (Mobile_form value : mobile) {
           
            System.out.println("Please Enter Your Choice : ");
            System.out.println(x+"- "+value.getReceipt());
            x++;
        }
        x=scn.nextInt();
        x=x-1;
        mobile.get(x).create_form(id,discount);


    }

    public void applyDiscount(double amount) {
        discount =  amount;
    }





    @Override
    public double getDiscount() {
        return discount;
    }
}