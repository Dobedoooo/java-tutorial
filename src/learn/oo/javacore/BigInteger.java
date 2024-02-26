package learn.oo.javacore;

public class BigInteger {

    public static void main(String[] args) {
        java.math.BigInteger b = java.math.BigInteger.valueOf(999999L).pow(99);
        float f = b.floatValue();
        System.out.println(f);  // Infinity
    }
}
