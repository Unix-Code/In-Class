public class Customer {
    private String first;
    private String last;
    private int age;

    public Customer() {
        first = "Bob";
        last = "Georgeson";
        age = 90;
    }

    public Customer(String newfirst, String newlast, int newage) {
        first = newfirst;
        last = newlast;
        age = newage;
    }

    public String getName() {
        return first +" "+ last;
    }

    public int getAge() {
        return age;
    }

    public void changeFirst(String newFirst) {
        first = newFirst;
    }

    public void printCustomer() {
        System.out.println("This customer's name is " + first + " " + last + " and is " + age + " years old.");
    }
}