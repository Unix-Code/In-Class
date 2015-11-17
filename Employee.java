import java.text.DecimalFormat;
public class Employee {
    private String firstName;
    private String lastName;
    private int age;
    private String idNum;
    private double salary;
    private String title;
    private static int[] prevID = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    public Employee() {
        firstName = "";
        lastName = "";
        age = 0;
        idNum = setNewID();
        salary = 0.0;
        title = "";
    }

    public Employee(String inFirstName, String inLastName, String inIDNum, int inAge, String inTitle, double inSalary) {
        firstName = inFirstName;
        lastName = inLastName;
        age = inAge;
        idNum = inIDNum;
        salary = inSalary;
        title = inTitle;
    }
    
    private String setNewID() {
        String sID = "";
        prevID[prevID.length -1]++;
        for (int i = 0; i < prevID.length; i++) {
            if (prevID[i] > 9) {
                prevID[i] -= 10;
                prevID[i - 1]++;
            }
            else {
                continue;
            }
        }
        
        for (int i = 0; i < prevID.length; i++) {
            if (i == 2 || i == 5) {
                sID += "-";
            }
            sID += String.valueOf(prevID[i]);
        }
        return sID;
    }
    
    public String getFirst() {
        return firstName;
    }

    public String getLast() {
        return lastName;
    }

    public String getID() {
        return idNum;
    }

    public void printPersonnelReport(){
        System.out.format("Employee %s %s", firstName, lastName);
        System.out.format("\nID: %s", idNum);
        System.out.format("\nAge: %d", age);
        System.out.format("\nTitle: %s", title);
        DecimalFormat decimalFormat = new DecimalFormat("$###,##0.00");
        String sSalary = decimalFormat.format(salary);
        System.out.format("\nSalary: %s", sSalary);
        System.out.println("");
    }

    public void fire() {
        title = "terminated";
        salary = 0;
    }

    public void increaseAge() {
        age++;
    }

    public void setID(String IDset) {
        idNum = IDset;
    }

    public void giveRaise(double raise) {
        salary += raise;
    }

    public void changePosition(String titleSet, double salarySet) {
        title = titleSet;
        salary = salarySet;
    }
}
