import org.junit.runner.JUnitCore;
public class Main {
    public static void main(String[] args) {
        JUnitCore.runClasses(PruebasJUnit.class);
        new GUI();
    }
}
