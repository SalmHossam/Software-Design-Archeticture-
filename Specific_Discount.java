public class Specific_Discount extends Discount {

    public void set_Service(String s){
        if (s.toLowerCase().contains("internet")){
            registerService(new Internet_service());
        }
        else if (s.toLowerCase().contains("mobile")) {
            registerService(new Mobile_recharge());
        }
        else if (s.toLowerCase().contains("donation")) {
            registerService(new Donations());
        }
        else if (s.toLowerCase().contains("landline")) {
            registerService(new Landline());
        }
    }

    @Override
    public void setDiscount(double amount) {

        if (services.size() > 0)
            services.get(0).applyDiscount(amount);
    }

    @Override
    public void applyDiscount(double amount) {

    }

    @Override
    public double getDiscount() {
        return 0;
    }
}
