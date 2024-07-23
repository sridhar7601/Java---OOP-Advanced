// ModernHuman.java
public class ModernHuman implements Homosapien, Neosapiens {

    @Override
    public void lightFire() {
        System.out.println("ModernHuman lights a fire.");
    }

    @Override
    public void killAnimal() {
        System.out.println("ModernHuman kills an animal.");
    }

    public void MakeFood(){
        System.out.println("with fire and meat preparing food.");

    }
    public static void main(String[] args) {
        ModernHuman modernHuman = new ModernHuman();
        modernHuman.lightFire();
        modernHuman.killAnimal();
        modernHuman.MakeFood();
    }
}
