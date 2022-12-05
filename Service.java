public interface Service {
    public void applyDiscount(double amount);
    public default void createNewProvider(){}
    public default void selectService(int id){}
    public double getDiscount();
}
