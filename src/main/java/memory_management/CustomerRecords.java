package memory_management;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CustomerRecords implements Iterable<Customer> {
    private Map<String, Customer> records;

    public CustomerRecords() {
        this.records = new HashMap<String, Customer>();
    }

    public void addCustomer(Customer customer) {
        this.records.put(customer.getName(), customer);
//        new HashSet<>().add(5).stream().maptoInt(i -> i).toArray();
    }

    public CustomerReadOnly getCustomerByName(String name) {
        return this.records.get(name);
    }
    public Map<String, Customer> getCustomerRecords() {
        return new HashMap<String, Customer>(this.records);
    }
    @Override
    public Iterator<Customer> iterator() {
        return this.records.values().iterator();
    }


}
