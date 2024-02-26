package learn.test;

public class Test {
    // 测试包作用域
    public static void main(String[] args) {
        // 测试包作用域
        // System.out.println(Package.testPackageScope); 报错
        System.out.println(testToUnsignedLong());
    }

    /**
     * int -1 -> unsigned long
     */
    public static long testToUnsignedLong() {
        long res = 0;
        for (int i = 0; i < 32; i++) {
            res += (long) Math.pow(2, i);
        }
        return res;
    }
}
