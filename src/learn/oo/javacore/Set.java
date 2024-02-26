package learn.oo.javacore;

import java.util.ArrayList;
import java.util.List;

public class Set {
    public static void main(String[] args) {
        /*
        * 如果一个 java 对象可以在内部持有若干其他 java 对象，并对外提供访问接口，我们把这种 java 对象称作集合
        * java 数组可以看作是一种集合
        * */
        String[] ss = new String[10];
        ss[0] = "hello";
        String first = ss[0];
        // System.out.println(Arrays.toString(ss));
        /*
        * 数组有如下限制
        * - 初始化后大小不可变
        * - 只能按索引顺序存取
        *
        * java 标准库自带的 java.util 包提供了集合类：Collection，它是除 Map 外所有其他集合类的根接口
        * java.util 包主要提供了一下三种类型的集合
        * - List：一种有序列表的集合
        * - Set：一种保证没有重复元素的集合
        * - Map：一种通过键值查找的映射表集合
        *
        * java 的集合设计有两个特点
        * - 实现了接口和实现类分离，例如有序表的接口是 List，具体的实现类有 ArrayList LinkedList
        * - 支持泛型，可以限制在一个集合中只能放入同一种数据类型的元素
        * */
        List<String> list = new ArrayList<>();
        /*
        * java 访问集合总是通过统一的方式--迭代器（Iterator）来实现，它最明显的好处在于无需知道集合内部元素是按什么方式存储的
        * */
        /*
        * 尽量不要使用遗留接口和类 HashTable Vector Stack
        * */
    }
}
