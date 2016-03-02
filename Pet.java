public class Pet {
    protected String name;

    public Pet() {
       name = "default pet";
    }
    
    public String getName() {
        return name;
    }
    
    public String makeSound() {
        return "default pet sound";
    }
}
