package learn.oo.javacore;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import learn.oo.javacore.JavaBean.*;

/**
 * 为保证 List.contains() 和 List.indexOf() 方法的正常返回，重写 equals() 方法
 * */
public class Equals {
    public static void main(String[] args) {
        List<String> list = Stream.of("A", "B", "C").collect(Collectors.toList());
        System.out.println(list.contains(new String("A"))); // true
        System.out.println(list.indexOf(new String("C")));  // 2
        /*
        * List 内部是通过 equals() 方法判断两个元素是否相等
        * 要正确使用 List 的 contains() indexOf() 这些方法，放入的实例必须正确覆写 equals() 方法
        * 之所以能正常放入 String Integer 这些对象，是因为 java 标准库定义的这些类已经正确实现了 equals() 方法
        * */
        List<Person> personList = new ArrayList() {{
            add(new Person(null, 22));
            add(new Person("xiao gang", 22));
        }};
        System.out.println(personList.contains(new Person(null, 22)));   // 正确覆写 equals 方法

        /*
        * equals() 方法的正确编写方法
        * 1. 先确定实例“相等”的逻辑，即哪些字段相等，就认为实例相等
        * 2. 用 instanceOf 判断传入的待比较的 Object 是不是当前类型，如果是，继续比较，不是则返回 false
        * 3. 对引用类型用 Objects.equals() 比较，对基本类型直接用 == 比较
        * */
        System.out.println(personList.indexOf(new Person(null, 22)));
    }
}
