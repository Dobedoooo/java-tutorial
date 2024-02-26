package learn.oo.exception;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class ExceptionOfJava {
    public static void main(String[] args) {
        /*
        * 异常是一种 class，因此它本身带有类型信息
        * 异常可以在任何地方抛出，但只需要在上层捕获，这样就和方法调用分离了
        *
        * 从继承关系可知， Throwable 是异常体系的根，继承自 Object。
        * Throwable 有两个体系：Error 和 Exception
        * - Error 表示严重的错误，程序对此一般无能为力，例如：
        *   - OutOfMemory：内存耗尽
        *   - NoClassDefFoundError：无法加载某个 class
        *   - StackOverflow：栈溢出
        * - Exception 是运行时的错误，它可以被捕获并处理。例如：
        *   - NumberFormatException：数值类型的格式错误
        *   - FileNotFoundException：未找到文件
        *   - SocketException：读取网络失败
        *   还有一异常是程序逻辑编写不对造成的，应该修复程序本身。例如：
        *   - NullPointerException：对某个 null 的对象调用方法或字段
        *   - IndexOutOfBoundsException：数组索引越界
        *
        * Exception 又分为两大类
        * 1. RuntimeException 以及它的子类
        * 2. 非 RuntimeException（包括 IOException、ReflectiveOperationException 等）
        *
        * Java 规定：
        * - 必须捕获的异常，包括 Exception 及其子类，但不包括 RuntimeException 及其子类，这种类型的异常称为 Checked Exception
        * - 不需要捕获的异常，包括 Error 及其子类，RuntimeException 及其子类
        * */

        /*
        * 捕获异常
        * 只要是方法声明的 Checked Exception，不在调用层捕获，也必须在更高的调用层捕获
        * 所有未捕获的异常，最终也必须在 main() 方法中捕获，不会出些漏写 try 的情况，这是由编译器保证的，main() 方法是最后捕获 Exception 的机会
        * */
        try {
            byte[] bs = toGBK("中文");
            System.out.println(Arrays.toString(bs));
        } catch (UnsupportedEncodingException e) {
            System.out.println(e);
        }

    }
    /**
     * String.getBytes(String) 的方法定义是<br>
     * public byte[] getBytes(String charsetName) throws UnsupportedEncodingException { ... }<br>
     * 在方法定义时使用 throws Xxx 表示该方法可能抛出的异常类型。调用方在调用的时候，必须强制捕获这些异常，否则编译器会报错
    * */
    static byte[] toGBK(String s) throws UnsupportedEncodingException {
//        try {
//            // 用指定编码转换 String 为 byte[]
//            return s.getBytes("GBK");
//        } catch (UnsupportedEncodingException e) {
//            // 如果系统不支持 GBK 编码，会捕获到 UnsupportedEncodingException 异常
//            System.out.println(e);
//            return s.getBytes();
//        }
        return s.getBytes("GBK");
    }
}
