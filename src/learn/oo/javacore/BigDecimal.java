package learn.oo.javacore;

import java.math.RoundingMode;

public class BigDecimal {
    public static void main(String[] args) {
        /*
        * 和 BigInteger 类似，BigDecimal 可以表示一个任意大小且精度完全准确的浮点数
        * */
        java.math.BigDecimal bd = new java.math.BigDecimal("123.4567");
        System.out.println(bd.multiply(bd));    // 15241.55677489
        // 用 scale() 表示小数位数
        java.math.BigDecimal bd1 = new java.math.BigDecimal("123.45");
        java.math.BigDecimal bd2 = new java.math.BigDecimal("123.4500");
        java.math.BigDecimal bd3 = new java.math.BigDecimal("1234500");
        System.out.println(bd1.scale());    // 2
        System.out.println(bd2.scale());    // 4
        System.out.println(bd3.scale());    // 0
        /*
        * 通过 BigDecimal 的 stripTrailingZeros() 方法，可以将一个 BigDecimal 格式化为一个相等的
        * 但末尾去掉了 0 的 BigDecimal
        * */
        java.math.BigDecimal bd4 = bd2.stripTrailingZeros();
        System.out.println(bd4.scale());    // 2
        /*
        * 如果一个 BigDecimal 的 scale() 返回负数，例如 -2，表示这个数是整数，并且末尾有 2 个 0
        * */
        java.math.BigDecimal bd5 = bd3.stripTrailingZeros();
        System.out.println(bd5.scale());    // -2

        /*
        * 可以对一个 BigDecimal 设置它的 scale，如果精度比原始值低，那么按照指定的方法进行四舍五入或者直接截断
        * */
        java.math.BigDecimal bd6 = new java.math.BigDecimal("123.456789");
        java.math.BigDecimal bd7 = bd6.setScale(4, RoundingMode.HALF_UP); // 四舍五入 123.4568
        java.math.BigDecimal bd8 = bd6.setScale(4, RoundingMode.DOWN); // 四舍五入 123.4567

        /*
        * 对 BigDecimal 做加减乘除时，精度不会丢失，但是做除法时，存在无法除尽的情况，这时就必须指定精度以及如何进行截断
        * */
        java.math.BigDecimal bd9 = new java.math.BigDecimal("123.456");
        java.math.BigDecimal bd10 = new java.math.BigDecimal("23.456789");
        java.math.BigDecimal bd11 = bd9.divide(bd10, 10, RoundingMode.HALF_UP); // 保留 10 位小数并四舍五入
        // java.math.BigDecimal bd12 = bd9.divide(bd10); // 报错 ArithmeticException 因为除不尽
        /*
        * 还可以对 BigDecimal 做除法同时求余数
        * 可以通过余数是否为 0 判断能否整除
        * */
        java.math.BigDecimal bd13 = new java.math.BigDecimal("12.345");
        java.math.BigDecimal bd14 = new java.math.BigDecimal("0.12");
        java.math.BigDecimal[] dr = bd13.divideAndRemainder(bd14);
        System.out.println(dr[0]);  // 102
        System.out.println(dr[1]);  // 0.105

        /*
        * 比较 BigDecimal
        * 必须使用 compareTo() 来比较，返回负数、正数和零，分别表示小于、大于和等于
        * */
        System.out.println(bd1.equals(bd2));                        // false 因为 scale 不同
        System.out.println(bd1.equals(bd2.stripTrailingZeros()));   // true
        System.out.println(bd1.compareTo(bd2));                     // true

        /*
        * BigDecimal 继承自Number，实际上是通过一个 BigInteger 和一个 int scale 来表示的
        * */
    }
}
