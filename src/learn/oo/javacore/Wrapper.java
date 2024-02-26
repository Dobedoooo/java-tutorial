package learn.oo.javacore;

public class Wrapper {
    public static void main(String[] args) {
        /*
        * java 数据类型分两种：基本类型，引用类型
        * 基本类型：byte(1字节) short(2字节) int(4字节) long(8字节) float(4字节) double(8字节) boolean(4字节) char(2字节)
        * 引用类型：所有类和接口
        *
        * 引用类型可以赋值为 null，但基本类型不能赋值为 null
        * */

        /*
        * int 包装类 Integer
        * int Integer 相互转换
        * */
        Integer n = null;
        Integer n2 = new Integer(20);
        int n3 = n2.intValue();

        /*
        * 各基本类型对应的包装类
        * byte          java.lang.Byte
        * short         java.lang.Short
        * int           java.lang.Integer
        * long          java.lang.Long
        * float         java.lang.Float
        * double        java.lang.Double
        * boolean       java.lang.Boolean
        * char          java.lang.Character
        * */
        Integer n4 = new Integer(99);       // 不推荐通过 new 创建 Integer 实例
        Integer n5 = Integer.valueOf(99);       // 通过静态方法 valueOf(int) 创建 Integer 实例
        Integer n6 = Integer.valueOf("100");    // 通过静态方法 valueOf(String) 创建 Integer 实例
        System.out.println(n6.intValue());

        /*
        * Auto Boxing 自动装箱
        * Auto Unboxing 自动拆箱
        * 会影响性能
        * */
        Integer n7 = 100;   // Auto Boxing
        int n8 = n7;        // Auto Unboxing
        Integer n9 = null;
        // int n10 = n9;       // 报错 NullPointerException

        /*
        * 所有包装类都是不变类
        * 对包装类实例进行比较时，要使用 equals() 而不是 ==
        * */
        Integer inte = 1;
        System.out.println(inte.intValue());
        inte = 2;
        System.out.println(inte.intValue());

        /*
        * 我们把能创建新对象的静态方法称为静态工厂方法。Integer.valueOf() 就是静态工厂方法，它尽可能地返回缓存地实例以节省内存
        * */

        /*
        * 进制转换
        * */
        System.out.println(Integer.parseInt("100", 16));    // 256
        /*
        * 把整数格式转换为指定进制地字符串
        * */
        System.out.println(Integer.toString(100));                // 100
        System.out.println(Integer.toString(100, 36));      // 2s 36进制
        System.out.println(Integer.toHexString(100));             // 64 16进制
        System.out.println(Integer.toOctalString(100));           // 144 8进制
        System.out.println(Integer.toBinaryString(100));          // 1100100 2进制

        /*
         * 包装类型还定义了一些有用的静态变量
         */
        // boolean 只有两个值 true 和 false，其包装类型只需要引用 Boolean 提供地静态字段
        Boolean b1 = Boolean.TRUE;      // true
        Boolean b2 = Boolean.FALSE;     // false
        // int 可表示地最大/最小值
        int max = Integer.MAX_VALUE;    // 2147483647
        int min = Integer.MIN_VALUE;    // -2147483648
        // long 类型占用的 bit 和字节数
        int sizeOfLong = Long.SIZE;     // 64
        int byteOfLong = Long.BYTES;    // 8
        // 所有的整数和浮点数的包装类型都继承自 Number，因此可以非常方便地通过包装类型获取各种基本类型
        Number num = Integer.valueOf("100");    // 向上转型为 Number
        // 获取 byte short int long float double
        byte b = num.byteValue();
        short s = num.shortValue();
        int i = num.intValue();
        long l = num.longValue();
        float f = num.floatValue();
        double d = num.doubleValue();
        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);

        /*
        * 处理无符号整型
        * java 中并没有无符号整型 unsigned 基本数据类型。byte short int long 都是带符号整型，最高位是符号位
        * 而 C 语言则提供了 CPU 支持的全部数据类型，包括无符号整型
        * 无符号整型和有符号整型转换在 java 中就需要借助包装类型的静态方法完成
        * 例如 byte -128 ~ +127，如果将 byte 看作无符号整型，范围就是 0 ~ 255
        * */
        int x = -1;
        byte y = 127;
        System.out.println(Integer.toUnsignedLong(x));
        // System.out.println(Byte.toUnsignedLong(x));

    }

}
