public class Pet {
    String name, sound;
    
    public Pet() {
        name = "Doggie";
        sound = "woof woof";
    }
    
    public Pet(String name, String sound) {
        this.name = name;
        this.sound = sound;
    }
    
    public String sound() {
        return sound;
    }
}