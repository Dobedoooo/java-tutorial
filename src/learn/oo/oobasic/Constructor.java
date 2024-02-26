package learn.oo.oobasic;

public class Constructor {
    public static void main(String[] args) {
        Person ming = new Person("ming", 12);
        System.out.println(ming.getName());
        System.out.println(ming.getAge().toString());
        System.out.println(ming.hashCode());
    }


}
class Person {
    /*
        private 修饰的字段子类访问不到
        protected 关键字可以将字段和方法的访问权限控制在继承树内部
     */
    // private String name;
    protected String name;
    // private Integer age;
    protected int age;
    public static int number;
    private static int count = 0;
    /*
    * 静态方法
    * 只能访问静态字段
    * */
    public static int getCount() {
        return count;
    }

    /*
        1. 构造方法的名称就是类名
        2. 构造方法的参数没有限制，在方法内部，也可以编写任意语句
        3. 和普通方法相比，构造方法没有返回值（也没有 void）
        4. 调用构造方法，必须使用 new 操作符
        一旦定义了构造方法，编译器就不再自动创建默认构造方法
    */
    public Person() { count += 1; }
    public Person(String name) {
        this(name, 18);
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        count += 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void run() {
        System.out.println("Person.run");
    }

    /*
    * 覆写 Object 类的方法
    * 1. toString() 显示更有意义的字符串
    * 2. equals() 比较是否相等
    * 3. hashCode()
    * */
    @Override
    public String toString() {
        return "Person:name=" + name;
    }
    @Override
    public boolean equals(Object o) {
        if(o instanceof Person) {
            Person p = (Person) o;
            // name 字段相同时，返回 true
            return this.name.equals(p.name);
        }
        return false;
    }
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

}
