import java.util.HashMap;

public class WalletPayment implements Payment{
    private static   HashMap<Integer, Double> wallet= new HashMap<Integer, Double>();



    public  void add_WalletPayment(int id) {
        wallet.put(id,0.0);

    }

    public WalletPayment() {
    }

    public void pay(double a, int id)
    {
        if(wallet.get(id)>=a)
        {
            double ab=wallet.get(id)-a;
            wallet.replace(id,ab);
            System.out.println("thanks for paied "+a+"$ by wallet");

        }
        else
        {
            System.out.println("sorry, your wallet money not enough  ");
        }
    }
    public void add(double a,int id){
        System.out.println(" thank you for add "+a+"$  to wallet");
        a=wallet.get(id)+a;
        wallet.replace(id,a);

    }
}
