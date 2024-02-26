package learn.oo.oobasic;

/*
    Java 只允许单继承
    子类和父类的关系是 is，has（组合）关系不能继承
    问题：向上转型、向下转型的作用
 */
public class Extents {
    public static void main(String[] args) {
        Student student = new Student("小明", 20, 99);
        Person person = new Student();  // 向上转型
        Person p = student;             // 向上转型
        Object object = p;              // 向上转型，所有类都是 Object 类的子类，Object 类没有父类
        Object o = student;             // 向上转型

        /*
            向下转型
         */
        Person person1 = new Person("小明", 12);
        Student student1 = (Student)person;    // 向下转型
        // Student student2 = (Student)person1;   // 抛出 ClassCastException 异常
        // 为了避免向下转型出错，Java 提供了 instanceOf 操作符
        System.out.println(person1 instanceof Person);
        System.out.println(person1 instanceof Student);
        System.out.println(student instanceof Person);
        System.out.println(student instanceof Student);

        Student student2 = null;
        System.out.println(student2 instanceof Person); // 如果一个引用变量为 null，那么对任何 instanceOf 的判断都为 false

        // 通过 instanceOf 判断是否可以向下转型
        if(person instanceof Student) {
            Student s = (Student) person;
        }

        Student ps = new PrimaryStudent("小军", 10, 100, 5);
        System.out.println(ps.getScore());
    }
}

class Student extends Person {
    // 子类自动获得了父类的所有字段，不要定义与父类重名的字段
    // protected String name;
    // protected int age;
    protected int score;

    // 任何 class 的构造方法，第一行语句必须是调用父类的构造方法
    // 如果没有明确地调用父类的构造方法，编译器会自动帮我们加一句 super();
    public Student(String name, int age, int score) {
        super(name, age);
        this.score = score;
    }
    public Student() {
        super();
    }

    public void setScore(int score) {
        this.score = score;
    }
    public int getScore() { return score; }

    /*
        Override 与 Overload 不同的是，如果方法签名（方法名+参数）不同，就是 Overload，Overload 是一个新方法
        如果方法签名相同，并且返回值也相同，就是 Override(重写、覆写)
        @Overload 不是必需的，加上 @Override 可以让编译器帮助检查是否进行了正确的覆写：希望进行覆写，但是不小心写错了方法签名，编译器会报错
    */
    @Override
    public void run() {
        System.out.println("Student.run");
    }

    //
}

class PrimaryStudent extends Student {
    protected int grade;

    public PrimaryStudent(String name, int age, int score, int grade) {
        super(name, age, score);
        this.grade = grade;
    }
}
