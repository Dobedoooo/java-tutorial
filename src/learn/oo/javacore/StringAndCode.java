package learn.oo.javacore;

import java.util.Arrays;

public class StringAndCode {

    public static void main(String[] args) {
        /*
        * String 本身也是一个 class，但 java 编译器对 String 有特殊处理
        * 即可以直接用 "..." 来表示一个字符串
        * */
        String s1 = "...";
        /*
        * 实际上字符串在 String 内部是通过一个 char[] 数组表示的
        * */
        String s2 = new String(new char[] {'h', 'e', 'l', 'l', 'o', '!'});

        /*
        * java 字符串的的一个重要特点就是字符串不可变。这种不可变性是通过内部的 private final char[] 字段
        * 以及没有任何修改 char[] 的方法实现的
        * */
        String string = "Hello";
        System.out.println(string);
        string = string.toUpperCase();
        System.out.println(string);

        String str1 = "hello";
        String str2 = "hello";
        // java 编译器在编译期，会自动把所有相同的字符串当作一个对象放入常量池，自然 str1 和 str2 的引用就是相同的
        System.out.println(str1 == str2);       // true
        System.out.println(str1.equals(str2));  // true

        String str3 = "hello";
        String str4 = "HELLO".toLowerCase();
        System.out.println(str3 == str4);       // false
        System.out.println(str3.equals(str4));  // true

        int[] scores = new int[] {88, 91, 23, 23};
        Score score = new Score(scores);
        score.printScores();
        scores[0] = 0;
        score.printScores();

    }
}

class Score {
    private int[] scores;

    public Score(int[] scores) {
        this.scores = scores.clone();
    }

    public void printScores() {
        System.out.println(Arrays.toString(scores));
    }
}
