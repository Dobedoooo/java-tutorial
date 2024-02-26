package learn.oo.javacore;

public class Enum {

    public static void main(String[] args) {

        /*
        *
        * */
        int day = 1;
        if(day == Weekday.SAT || day == Weekday.SUN) {
            // TODO: work at home
        }
        /*
        *
        * */
        String color = "r";
        if(Color.RED.equals(color)) {
            // TODO
        }

        /*
        * 枚举是引用类型，但枚举类型的比较不用 equals()
        * 因为 enum 类型的每个常量在 JVM 中只有一个唯一实例，所以可以用 == 比较
        *
        * enum 定义的枚举类就是 class，有以下特点
        * - 定义的 enum 类型总是继承自 java.lang.Enum，且无法继承
        * - 只能定义出 enum 的实例，而无法通过 new 操作符创建 enum 的实例
        * - 定义的每个实例都是引用类型的唯一实例
        * - 可以将 enum 类型用于 switch 语句
        * */
        NewWeekday newDay = NewWeekday.FRI;
        if(newDay == NewWeekday.SAT || newDay == NewWeekday.SUN) {
            System.out.println("Work at home!");
        } else {
            System.out.println("Work at office!");
        }

        /*
        * enum 实例的方法
        * - name() 返回常量名
        * - ordinal() 返回定义常量的顺序
        * */
        String str = NewWeekday.FRI.name();         // "FRI"
        int ord = NewWeekday.FRI.ordinal();         // 5
        int dayVal = NewWeekday.FRI.dayValue;       // 5
        String chinese = NewWeekday.FRI.toString(); // "星期五"

        /*
        * 枚举类可以用在 switch 语句中，因为枚举类型天生具有类型信息和有限个枚举常量，所以比 int String 类型更适合用在 switch 中
        * */
        NewWeekday day1 = NewWeekday.FRI;
        switch (day1) {
            case SUN:
                System.out.println("Today is " + day1.name() + ". Work at home.");
            case MON:
            case TUE:
            case WED:
            case THU:
            case FRI:
                System.out.println("Today is " + day1.name() + ". Work at office.");
            case SAT:
            default:
                throw new RuntimeException("cannot process" + day1.name());
        }
    }
}

/**
 * 为了让编译器能自动检查某个值在枚举的集合内，并且不同用途的枚举需要不同的类型来标记，不能混用，我们可以用 enum 来定义枚举
 * */
enum NewWeekday {
    SUN(0, "星期日"),
    MON(1, "星期一"),
    TUE(2, "星期二"),
    WED(3, "星期三"),
    THU(4, "星期四"),
    FRI(5, "星期五"),
    SAT(6, "星期六");

    public final int dayValue;  // 方便枚举类型和 int 转换，枚举类的字段也可以是非 final 类型，但不建议这样做
    public final String chinese;

    // 构造方法要声明为 private
    private NewWeekday(int dayValue, String chinese) {
        this.dayValue = dayValue;
        this.chinese = chinese;
    }

    @Override
    public String toString() {
        // 输出 NewWeekday.FRI 为 FRI -> 输出 NewWeekday.FRI 为 星期五
        return chinese;
    }
}

class Weekday {
    /*
     * java 中通过 final 定义常量
     * */
    public static final int SUN = 0;
    public static final int MON = 1;
    public static final int TUE = 2;
    public static final int WED = 3;
    public static final int THU = 4;
    public static final int FRI = 5;
    public static final int SAT = 6;
}

class Color {
    public static final String RED = "r";
    public static final String GREEN = "g";
    public static final String BLUE = "b";
}