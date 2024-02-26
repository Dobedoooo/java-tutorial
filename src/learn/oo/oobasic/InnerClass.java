package learn.oo.oobasic;

import java.util.HashMap;

public class InnerClass {


    public static void main(String[] args) {
        // Inner 实例不能单独存在必须依附于一个 Outer 的实例
        Outer outer = new Outer("Nested");
        Outer.Inner inner = outer.new Inner();
        inner.hello();
        /*
        * 这是因为 Inner Class 除了有一个 this 指向自己，还隐含的持有一个 Outer Class 实例，可以用 Outer.this 访问这个实例。
        * 所以，实例化一个 Inner Class 不能脱离 Outer 实例
        * */

        outer.asyncHello();

        /*
        * 除接口外，匿名类也完全可以继承自普通类
        * map1 是一个普通的 HashMap 实例
        * map2 是一个继承自 HashMap 的匿名类实例
        * map3 是一个继承自 HashMap 的匿名类实例，并且添加了 static 代码块来初始化数据
        * */
        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap() {};  // 匿名类，编译为 InnerClass$1.class
        HashMap<String, String> map3 = new HashMap() {    // 匿名类，编译为 InnerClass$2.class
            {
                put("A", "1");
                put("B", "2");
            }
        };
        System.out.println(map3.get("A"));

        // 静态内部类
        Outer.NestedInner nestedInner = new Outer.NestedInner();
        nestedInner.hello();

        /*
        * Java 内部类可分为
        * 1. 内部类 Inner Class
        * 2. 匿名类 Anonymous Class
        * 3. 静态内部类 Static Nested Class
        * */
    }

}

class Outer {
    private String name;
    private static String NAME = "OUTER";

    Outer(String name) {
        this.name = name;
    }

    /*
    * 在方法内部实例化了一个 Runnable。Runnable 本身是接口，不能实例化，所以这里实际上是定义了一个实现了 Runnable 接口的匿名类，
    * 并通过 new 实例化该匿名类，然后转型为 Runnable
    * */
    void asyncHello() {
        Runnable r = new Runnable() {
            // 该匿名类被编译为 Outer$1.class
            @Override
            public void run() {
                System.out.println("Hello, " + Outer.this.name);
            }
        };
        new Thread(r).start();
    }

    class Inner {
        /*
        * Inner Class 和普通 Class 相比，除了能引用 Outer 实例外，还能访问 Outer 的 private 字段
        * 内部类被编译为 Outer$Inner.class
        * */
        void hello() {
            System.out.println("hello!" + Outer.this.name);
        }
    }

    /*
    * 静态内部类
    * 不在依附于 Outer 实例，是一个完全独立的类，无法引用 Outer.this，但可以访问 Outer 的 private 静态字段和方法。
    * */
    static class NestedInner {
        void hello() {
            System.out.println("Hello, " + Outer.NAME);
        }
    }
}
