package learn.oo.oobasic;

public class Scope {
    /*
    * 看一个类先看 public 方法
    * */
    /*
    * final 修饰符不是访问权限
    * 作用在类上可以阻止继承
    * 作用在方法上可以防止被子类覆写
    * 作用在变量上可以防止被重新赋值
    * 作用在局部变量可以防止被重新赋值
    *
    * 一个 java 文件可以有多个类，但只能有一个和文件名相同的 public 类
    * */

    public void say(final String word) {
        // word += 1; 报错
        System.out.println(word);
    }
}
