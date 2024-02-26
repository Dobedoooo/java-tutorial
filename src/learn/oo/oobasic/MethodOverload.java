package learn.oo.oobasic;

public class MethodOverload {
    /*
        在一个类中，如果有一系列方法功能类似，只是参数有所不同，那么可以把这一组方法做成同名方法
        这种方法名相同，但各自的参数不同，称为方法重载（Overload）
     */
    public void hello() {
        System.out.println("hello world");
    }

    public void hello(String name) {
        System.out.println("hello " + name);
    }

    public void hello(String name, int age) {
        if(age > 18) {
            System.out.println("hello " + name);
        } else {
            System.out.println("hi " + name);
        }
    }

    /*
    注意：方法重载的返回值类型通常都是相同的

    方法重载的目的是：功能类似的方法使用同一名字，更容易记住，因此调用起来更简单
    例如，String 类提供了多个重载方法 indexOf()，可以查找子串
    - int indexOf(int ch)：根据字符的 Unicode 码查找；
    - int indexOf(String str)：根据字符串查找；
    - int indexOf(int ch, int fromIndex)：根据字符查找，但指定起始位置
    - int indexOf(String str, int fromIndex)：根据字符串查找，但指定起始位置
     */
    public static void main(String[] args) {
        String s = "Test string";
        int n1 = s.indexOf("t");
        int n2 = s.indexOf("st");
        int n3 = s.indexOf("st", 4);
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);

        Person ming = new Person();
        Person hong = new Person();
        ming.setName("Xiao Ming");
        hong.setName("Xiao", "Hong");
        System.out.println(ming.getName());
        System.out.println(hong.getName());

    }
    static class Person {
        private String name;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        public void setName(String firstName, String lastName) {
            this.name = firstName + " " + lastName;
        }

    }
}
