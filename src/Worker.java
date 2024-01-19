// Isha Gupta
public class Worker extends Person{
    String company;

    public Worker(String firstName, String lastName, String phoneNumber, String company){
        super(firstName, lastName, phoneNumber);
        this.company = company;
    }

    public String getCompany() {
        return company;
    }


    @Override
    public String toString() {
        return super.toString() + " Company: " + company;
    }
}
