package learn.oo.oobasic;

public class Static {

    public static void main(String[] args) {
        /*
        * 静态字段并不属于实例
        * */
        Person ming = new Person("xiao ming", 18);
        Person hong = new Person("xiao hong", 18);
        ming.number = 88;   // 将自动转换为 Person.number
        System.out.println(hong.number);
        hong.number = 99;
        System.out.println(ming.number);

        System.out.println(Person.getCount());

        /*
        * 静态方法常用于工具类
        * */
        System.out.println(Math.max(1, 2));

        // 测试包作用域
        System.out.println(Package.testPackageScope);
    }
}

/*
* 接口的静态字段
* interface 是一个纯抽象类，不能定义实例字段。但 interface 是可以有静态字段的，并且静态字段必须为 fianl 类型
* */
interface CPU {
    // public static final String fullName = "Central Process Unit";
    // 加不加修饰符都一样
    String fullName = "Central Process Unit";
}
