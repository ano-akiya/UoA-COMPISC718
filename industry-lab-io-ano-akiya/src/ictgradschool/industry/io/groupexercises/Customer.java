package ictgradschool.industry.io.groupexercises;

public class Customer {

    private String name;
    private int age;
    private String address;
    private boolean isSubscribed;

    public Customer() {
    }

    public Customer(String name, int age, String address, boolean isSubscribed) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.isSubscribed = isSubscribed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isSubscribed() {
        return isSubscribed;
    }

    public void setSubscribed(boolean subscribed) {
        isSubscribed = subscribed;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", isSubscribed=" + isSubscribed +
                '}';
    }
}
