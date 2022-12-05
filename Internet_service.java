import java.util.ArrayList;
import java.util.Scanner;
public class Internet_service implements Service {
    public static double discount = 0.0;
    private static ArrayList<Internet_form>  internet = new ArrayList<>();
    private Scanner scn = new Scanner(System.in);


    public static int x=0;
    public Internet_service() {
        if(x==0){Internet_form we= new Internet_form("We");
            Internet_form vodafone= new Internet_form("Vodafone");
            Internet_form orange= new Internet_form("Orange");
            Internet_form etisalat= new Internet_form("Etisalat");
            internet.add(we);
            internet.add(vodafone);
            internet.add(orange);
            internet.add(etisalat);
            x=1;

        }


    }
    public void createNewProvider(){
        int ok = 1 ;
        System.out.println("Please Enter Service Provider Name ");
        String Name= scn.next();



        for (Internet_form value : internet) {
            if (value.getReceipt().equals(Name)) {
                System.out.println("Service provider saved to the System before ");
                ok = 0;
                break;
            }
        }
        if (ok==1){

            Internet_form temp= new Internet_form(Name);
            internet.add(temp);
            System.out.println("Service Provider Added Successful ");


        }


    }
    public void selectService(int id){
        int x=1;


        for (Internet_form value : internet) {
           
            System.out.println("Please Enter Your Choice : ");
            System.out.println(x+"- "+value.getReceipt());
            x++;
        }
        x=scn.nextInt();
        x=x-1;
        internet.get(x).create_form(id,discount);


    }

    public void applyDiscount(double amount) {
        discount = amount;
    }

    @Override
    public double getDiscount() {
        return discount;
    }
}
