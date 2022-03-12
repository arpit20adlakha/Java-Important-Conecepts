package memory_management;

public class Main {
    public static void main(String[] args) {
        CustomerRecords records = new CustomerRecords();

        records.addCustomer(new Customer("Arpit"));
        records.addCustomer(new Customer("Sham"));

        for(Customer c : records) {
            System.out.println(c);
        }

        CustomerReadOnly john = records.getCustomerByName("Arpit");
        System.out.println(john.getName());
        System.out.println(john.getName());
    }
}
