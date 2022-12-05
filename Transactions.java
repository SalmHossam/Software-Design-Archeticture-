import java.util.*;
public class Transactions {
    private String info;
    private double price;
    static private int trans=0;
    private int id_user;
    private boolean refund;

    public Transactions() {
    }

     private static ArrayList<ArrayList> prov_trans = new ArrayList(new ArrayList<>());
    private static HashMap<Integer, String> ref = new HashMap<Integer, String>();
    private Scanner scn = new Scanner(System.in);

    public Transactions(String info, double price, int id_user) {
        this.info = info;
        this.price = price;
        this.id_user = id_user;
        ArrayList temp=new ArrayList();
        temp.add(trans);
        temp.add(id_user);
        temp.add(price);
        temp.add(info);
        prov_trans.add(temp);
        trans+=1;
    }
    public void show_Request(int id){
        if(prov_trans.size()>0){
            for(int i=0;i<prov_trans.size();i++){
                if (prov_trans.get(i).get(1).equals(id)){

                        System.out.println("transaction Id : "+prov_trans.get(i).get(0));
                        System.out.println("Price : "+prov_trans.get(i).get(2));
                        System.out.println("Info. : "+prov_trans.get(i).get(3));
                        System.out.println("Refund : "+ref.get(prov_trans.get(i).get(0)));
                        System.out.println("-----------------------------------------------------");
                        System.out.println("-----------------------------------------------------");


                }

            }

        }



    }
    public void createRefund(int id){

        int x=5;
        System.out.println("Create refund");
        if(prov_trans.size()<x){
            x= prov_trans.size();

        }

        for(int i=0;i<x;i++) {
            if (prov_trans.get(i).get(1).equals(id)) {
                if(!ref.equals(Integer.parseInt(prov_trans.get(i).get(1).toString()))){

                    System.out.println("transaction Id : " + prov_trans.get(i).get(0));
                    System.out.println("Price : " + prov_trans.get(i).get(2));
                    System.out.println("Info. : " + prov_trans.get(i).get(3));
                    System.out.println("Refund : " + ref.get(prov_trans.get(i).get(0)));
                    System.out.println("-----------------------------------------------------");}




            }
        }
        System.out.println("please write your transaction id ");
        x=scn.nextInt();
        if (!ref.equals(x)){
            ref.put(x,"false");

            
        }


    }
    public void list_transaction(){
        int x=5;

        if(prov_trans.size()<x){
            x= prov_trans.size();

        }
        if(prov_trans.size()>0){
            for(int i=0;i<x;i++) {
            System.out.println("transaction Id : " + prov_trans.get(i).get(0));
            System.out.println("Id User : " + prov_trans.get(i).get(1));
            System.out.println("Price : " + prov_trans.get(i).get(2));
            System.out.println("Info. : " + prov_trans.get(i).get(3));
            System.out.println("Refund : " + ref.get(prov_trans.get(i).get(0)));
            System.out.println("-----------------------------------------------------");
        }

        }



    }
    public void approveTransaction(){
        if(prov_trans.size()>0){
            for(int i : ref.keySet() ){

                if(ref.get(i)=="false"){
                    for(int z=0;z<prov_trans.size();z++){
                        if(prov_trans.get(z).get(0).equals(i)){
                            System.out.println("transaction Id : " + prov_trans.get(z).get(0));
                            System.out.println("Price : " + prov_trans.get(z).get(2));
                            System.out.println("Info. : " + prov_trans.get(z).get(3));
                            System.out.println("Refund : " + ref.get(prov_trans.get(z).get(0)));
                            System.out.println("-----------------------------------------------------");



                        }
                    }
                }
            }
            System.out.println("please write your transaction id ");
            int  x=scn.nextInt();
            if (ref.get(x)=="false"){
                ref.replace(x,"true");

            }
            for(int i=0;i<prov_trans.size();i++){
                if(prov_trans.get(i).get(0).equals(x)){
                    WalletPayment ab=new WalletPayment();
                    double temp1=Double.parseDouble(prov_trans.get(i).get(2).toString());
                    int temp2=Integer.parseInt(prov_trans.get(i).get(1).toString());
                    ab.add(temp1,temp2);
                }
            }

        }












    }




}