package learn.oo.oobasic;

public class Polymorphic {

    public static double totalTax(Income... incomes) {
        double total = 0;
        for(Income income: incomes) {
            total += income.getTax();
        }
        return total;
    }

    public static void main(String[] args) {
        Person p = new Person();
        Person s = new Student();
        p.run();    // Person.run
        s.run();    // Student.run
        /*
            Java的实例方法调用是基于运行时的实际类型的动态调用，而非变量声明类型
            这个重要特性在面向对象编程中称为 多态 Polymorphic
            多态：多态是指，针对某个类型的方法调用，其真正执行的方法取决于运行时期实际类型的方法
         */

        Income[] incomes = new Income[] {
                new Income(3000),
                new SalaryIncome(6000),
                new StateCouncilSpecialAllowance(15000),
                new Royalties(2000)
        };
        System.out.println(totalTax(incomes));
    }
}

/**
 *
 */
class Income {
    // 用 final 修饰字段，在构造方法中赋值，赋值后不能被修改
    // 用 final 修饰的类不能被继承
    // 用 final 修饰的方法不能被覆写
    protected final double income;
    public Income(double income) {
        this.income = income;
    }
    public double getTax() {
        return income * 0.1;
    }
}
/**
 * 工资收入
 */
class SalaryIncome extends Income {
    public SalaryIncome(double income) {
        super(income);
    }
    @Override
    public double getTax() {
        if(income < 5000) {
            return 0;
        }
        return (income - 5000) * 0.2;
    }
}
/**
 * 国务院特殊津贴
 */
class StateCouncilSpecialAllowance extends Income {
    public StateCouncilSpecialAllowance(double income) {
        super(income);
    }
    @Override
    public double getTax() {
        return 0;
    }
}
/**
 * 稿费收入
 */
class Royalties extends Income {
    public Royalties(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        return income * 0.2;
    }
}
