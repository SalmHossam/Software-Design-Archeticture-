import java.util.ArrayList;
import java.util.Scanner;

public class Donations implements Service{
    public static double discount = 0;

    private static ArrayList<Donations_form> donation = new ArrayList<>();
    private Scanner scn = new Scanner(System.in);
    public static int x=0;
    public Donations() {

        if(x==0){
            Donations_form canser= new Donations_form("Cancer's Hospital");
            Donations_form sc= new Donations_form("School");


            donation.add(canser);
            donation.add(sc);
            x=1;

        }




    }
    public void createNewProvider(){

        int ok = 1 ;
        System.out.println("Please Enter Service Provider Name ");
        String Name= scn.next();



        for (Donations_form value : donation) {
            if (value.getReceipt().equals(Name)) {
                System.out.println("Service provider saved to the System before ");
                ok = 0;
                break;
            }
        }
        if (ok==1){

            Donations_form temp= new Donations_form(Name);
            donation.add(temp);
            System.out.println("Service Provider Added Successful ");


        }


    }
    public void selectService(int id){
        int x=1;


        for (Donations_form value : donation) {
 
            System.out.println("Please Enter Your Choice : ");
            System.out.println(x+"- "+value.getReceipt());
            x++;
        }
        x=scn.nextInt();
        x=x-1;
        donation.get(x).create_form(id,discount);


    }

    public void applyDiscount(double amount) {
        discount = amount;
    }

    @Override
    public double getDiscount() {
        return discount;
    }
}
