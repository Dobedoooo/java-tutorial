package learn.oo.exception;

import java.io.IOException;

public class CatchException {
    public static void main(String[] args) {
        /*
         * 在 java 中，凡是可能抛出异常的语句，都可以用 try...catch 捕获。把可能发生异常的的语句放在 try{...} 中
         * 然后使用 catch 捕获对应的 Exception 及其子类
         */

        /*
         * 多 catch 语句
         * 可以使用多个 catch 语句，每个 catch 分别捕获对应的 Exception 及其子类。JVM 在捕获到异常后，会从上到下匹配 catch 语句，
         * 匹配到某个 catch 语句后，执行 catch 代码块，然后不再继续匹配。
         * 即：多个 catch 语句只有一个能被执行
         *
            try {
                process1();
                process2();
                process3();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (NumberFormatException numberFormatException) {
                numberFormatException.printStackTrace();
            }
        */

        /*
         * 所以存在多个 catch 的时候，catch 的顺序非常重要：子类必须写在前面，否则永远捕获不到
         */

        /*
         * finally 语句
         * 1. finally 语句可写可不写
         * 2. finally 总是最后执行
         */
        try {

        } catch (Exception e) {

        } finally {
            System.out.println("done.");
        }
    }
    /*
     * 某些情况下，可以没有 catch，只使用 try...finally 结构
     * 因为方法声明了可能抛出的异常，所以可不写 catch
     */
    void process() throws Exception {
        try {
            //
        } finally {
            System.out.println("finally");
        }
    }

    /**
     * 捕获多种异常
     * 如果某些异常处理逻辑相同，但是异常本身不存在继承关系，那么就得编写多条 <code>catch</code> 语句
     */
    void process1() {
        try {
            //
        // } catch (IOException ioException) {
            System.out.println("Bad Input.");
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Bad Input.");
        } catch (Exception e) {
            System.out.println("Unknown error");
        } finally {
            System.out.println("finally");
        }
        /*
         * 因为处理 IOException 和 NumberFormatException 的代码是相同的，所以可以把他们用 | 合并到一起
         */
        try {
            //
        // } catch (IOException | NumberFormatException e) {
            System.out.println("Bad Input.");
        } catch (Exception e) {
            System.out.println("Unknown error");
        } finally {
            System.out.println("finally");
        }
    }
}
