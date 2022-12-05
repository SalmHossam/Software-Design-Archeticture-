import java.util.Vector;

public abstract class Discount implements Service {
    Vector<Service> services = new Vector <Service>();
    public void registerService(Service service) {
        services.add(service);
    }
    public abstract void setDiscount(double amount);
}
