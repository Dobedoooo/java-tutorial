package learn.oo.oobasic;

public class AbstractClass {
    public static void main(String[] args) {
        /*
        * 面向抽象编程
        * 通过抽象的 Car 类去引用具体的子类实例，不必关心子类的具体类型
        * 面向抽象编程的本质就是：
        * - 上层代码之定义规范
        * - 不需要子类就可以实现业务逻辑
        * - 具体的业务逻辑由不同的子类实现，调用者并不关心
        * */
        Car t = new Truck();
        Car b = new Bus();
        t.run();
        b.run();
    }
}

abstract class Car {
    protected String brand;
    protected String model;
    protected int price;

    public abstract void run();

    public Car() {}

}

class Truck extends Car {

    @Override
    public void run() {
        System.out.println("Truck run.");
    }
}

class Bus extends Car {
    @Override
    public void run() {
        System.out.println("Bus run.");
    }
}
