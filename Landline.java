import java.util.ArrayList;
import java.util.Scanner;

public class Landline implements Service {
    public static double discount = 0.0;
    public static int x=0;

    private static ArrayList<Landline_form> landline = new ArrayList<>();
    private Scanner scn = new Scanner(System.in);
    public Landline() {
        if(x==0){
            Landline_form month= new Landline_form("Month");
            Landline_form quartet= new Landline_form("Quartet");
            landline.add(month);
            landline.add(quartet);
            x=1;

        }




    }
    public void createNewProvider(){
        int ok = 1 ;
        System.out.println("Please Enter Service Provider Name ");
        String Name= scn.next();



        for (Landline_form value : landline) {
            if (value.getReceipt().equals(Name)) {
                System.out.println("Service provider saved to the System before ");
                ok = 0;
                break;
            }
        }
        if (ok==1){

            Landline_form temp= new Landline_form(Name);
            landline.add(temp);
            System.out.println("Service Provider Added Successful ");


        }


    }
    public void selectService(int id){
        int x=1;


        for (Landline_form value : landline) {
           
            System.out.println("Please Enter Your Choice : ");
            System.out.println(x+"- "+value.getReceipt());
            x++;
        }
        x=scn.nextInt();
        x=x-1;
        landline.get(x).create_form(id,discount);


    }
    

    public void applyDiscount(double amount) {
        discount =  amount;
    }
    @Override
    public double getDiscount() {
        return discount;
    }
}

