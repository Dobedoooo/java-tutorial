package learn.oo.oobasic;

import java.util.*;

public class Interface {
    public static void main(String[] args) {
        Language c = new Chinese();
        System.out.println(c.getName());
        c.intro();

        // 在使用的时候，实例化的对象永远只能是某个具体的子类，但总是通过接口去引用他，因为接口比抽象类更抽象
        List list = new ArrayList();
        Collection coll = list;
        Iterable it = coll;

        Income[] incomes = new Income[] {
                new SalaryIncome(6000),
                new Royalties(2000),
        };
        System.out.println(totalTax(incomes));
    }

    interface Income {
        double getTax();
    }

    public static double totalTax(Income... incomes) {
        double total = 0;
        for(Income income: incomes) {
            total += income.getTax();
        }
        return total;
    }

    static class SalaryIncome implements Income {
        protected double income;

        public SalaryIncome(double income) {
            this.income = income;
        }

        @Override
        public double getTax() {
            if(income < 5000) {
                return 0;
            } else {
                return (income - 5000) * 0.2;
            }
        }
    }

    static class Royalties implements Income {
        protected double income;

        public Royalties(double income) {
            this.income = income;
        }

        @Override
        public double getTax() {
            return income * 0.2;
        }
    }
}

interface Culture {
    /*
    * 实现类可以不必覆写 default 方法
    * default 方法的目的是：当我们需要给接口新增一个方法时，会涉及到修改全部子类。
    * 如果新增的时 default 方法，那么子类就不必全部修改，只需要在需要覆写的地方去覆写新增方法。
    * default 方法和抽象类的普通方法有所不同，因为 interface 没有字段，default 方法无法访问字段，而抽象类的普通方法可以访问实例字段
    *
    */

    default void intro() {
        System.out.println("我是一种文化");
    };
}
/*
* 接口的方法有抽象方法和 default 方法
* */
interface Language extends Culture{
    String name = "a";
    // 加不加 public abstract 都一样
    void say();
    String getName();
}


// 一个类只能继承一个类，但可以实现多个 interface
class Chinese implements Language {
    protected final String name = "中文";
    @Override
    public void say() {
        System.out.println("说" + name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void intro() {
        System.out.println("中文是一种文化");
    }

}