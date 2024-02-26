package learn.oo.javacore;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UseList {
    /**
     * <table>
     *     <tr>
     *         <th></th><th>ArrayList</th><th>LinkedList</th>
     *     </tr>
     *     <tr>
     *         <td>获取指定元素</td><td>速度很快</td><td>需要从头开始查找元素</td>
     *     </tr>
     *     <tr>
     *         <td>追加元素</td><td>速度很快</td><td>速度很快</td>
     *     </tr>
     *     <tr>
     *         <td>在指定位置添加/删除</td>
     *         <td>需要移动元素</td>
     *         <td>不需要移动元素</td>
     *     </tr>
     *     <tr>
     *         <td>内存占用</td>
     *         <td>少</td>
     *         <td>较大</td>
     *     </tr>
     * </table>
     * <br>
     * 通常情况下使用 ArrayList
     * */
    void commet() {}
    public static void main(String[] args) {
        /*
        * 即将溢出时，ArrayList 会先创建一个更大的数组，然后把旧数组的所有元素复制到新数组，紧接着用新数组替代旧数组
        *
        * List<E> 几个主要的接口方法
        * - boolean add(E e)            在末尾添加一个元素
        * - boolean add(int index, E e) 在指定索引添加一个元素
        * - E remove(int index)         删除指定索引的元素
        * - boolean remove(Object o)    删除某个元素
        * - E get(int index)            获取指定索引的元素
        * - int size()                  获取链表大小
        * */
        /*
        * List 的特点
        * - List 接口允许添加重复元素，即 List 内部的元素可以重复
        * - List 允许添加 null
        * */
        List<String> list = new ArrayList<>();
        list.add("apple");  // size == 1
        list.add("pear");  // size == 2
        list.add("apple");  // 允许重复添加元素，size == 3
        System.out.println(list.size());
        list.add(null);
        System.out.println(list.get(3));

        /*
        * 创建 List
        * Java9：除了使用 ArrayList 和 LinkedList，我们还可以通过 List 接口提供的 of() 方法
        *        根据给定元素快速创建 List，但该方法不接受 null，会抛出 NullPointerException 异常
        * */
        // List<Integer> list1 = List.of(1, 2, 4);
        List<Integer> list4 = new ArrayList() {
            {
                add(1);
                add(2);
            }
        };
        /*
        * 遍历 List
        * - for 循环：不推荐，原因如下
        *   1. 代码复杂
        *   2. get(int) 方法只有 ArrayList 的实现是高效的，换成 LinkedList 后，索引越大，访问速度越慢
        * - Iterator：始终坚持使用迭代器 Iterator 来访问 List
        *   Iterator 本身也是一个对象，由 List 实例调用 iterator() 方法时创建
        *   Iterator 对象知道如何遍历一个 List，并且不同的 List 类型，返回的 Iterator 对象也是不同的，但总是具有最高的访问效率
        *   3. 增强 for 循环（for each 循环）
        *   只要实现了 Iterator 接口的集合类，都可以直接使用 for-each 循环来遍历。编译器会把 for-each 循环编程 Iterator 的调用
        * */
        // 1.
        System.out.println("traverse by for:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        // 2.
        System.out.println("traverse by Iterator:");
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }
        // 3.
        System.out.println("traverse by for-each:");
        for (String s: list) {
            System.out.println(s);
        }

        /*
        * List 和 Array 的转换
        * 1. 调用 toArray() 方法直接返回一个 Object[] 数组
        *    会丢失类型信息，应用较少
        * 2. 给 toArray(T[]) 传入一个类型相同的 Array，List 内部自动把元素复制到传入的 Array 中
        *    该方法泛型参数 <T> 并不是 List 接口定义的泛型参数 <E>，所以可以传入其他类型的数组（类型要匹配），例如 Number
        *    如果传入的数组不够大，List 内部会创建一个新的刚好大的数组，填充后返回；如果传入的数组大小比 List 元素还要多，则填充完毕后其余填充 null
        * 3. 通过 List 接口定义的 T[] toArray(IntFunction<T[]> generator)
        * */
        // 1.
        System.out.println("--- toArray() ---");
        Object[] arr = list.toArray();
        System.out.println(Arrays.toString(arr));
        // 2.
        System.out.println("--- toArray(T[]) ---");
        List<Integer> list1 = Stream.of(1, 2, 3).collect(Collectors.toList());  // 流，初始化 List
        Integer[] arr2 = list1.toArray(new Integer[list1.size()]);
        System.out.println(Arrays.toString(arr2));
        // 传入其他类型的数组
        Number[] nums = list1.toArray(new Number[list1.size()]);
        System.out.println(Arrays.toString(nums));
        // 3.
        System.out.println("--- T[] toArray(IntFunction<T[]> generator) ---");
        Integer[] arr3 = Stream.of(1, 2, 3, 4).toArray(Integer[]::new);
        System.out.println(Arrays.toString(arr3));

        /*
        * Array 变为 List，返回一个只读的 List，不能修改
        * - JDK 11 之前 Arrays.asList(T...)
        * - JDK 11 之后 List.of(T...)
        * */
        System.out.println("--- Arrays.asList(T...) ---");
        List<Integer> list2 = Arrays.asList(arr3);
        // list2.add(6);   // UnsupportedOperationException
        for (Integer i: list2) { System.out.println(i); }

        /*
        * 练习：给定一组整数，10，11，12，……，20，但其中缺失一个数字，试找出缺失的数字
        * */
        System.out.println("--- Practice ---");
        final int start = 10;
        final int end = 20;
        List<Integer> list3 = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list3.add(i);
        }
        Collections.shuffle(list3); // 洗牌算法shuffle可以随机交换List中的元素位置
        int removed = list3.remove( (int) (Math.random() * list3.size()));
        int found = findMissingNumber(start, end, list3);
        System.out.println(list3.toString());
        System.out.println("missing number: " + found);
        System.out.println(removed == found ? "测试成功" : "测试失败");

    }

    static int findMissingNumber(int start, int end, List<Integer> list) {
        int missing = 0;
        for (int i = start; i <= end; i++) {
            if(!list.contains(i)) missing = i;
        }
        return missing;
    }
}
