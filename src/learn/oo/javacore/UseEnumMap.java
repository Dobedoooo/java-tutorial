package learn.oo.javacore;

public class UseEnumMap {
    public static void main(String[] args) {
        /*
        * 如果作为 key 的对象是 enum 类型，可以使用 java 集合库提供的一种 EnumMap
        * 他在内部以一个非常紧凑的数组存储 key，并且根据 enum 类型的 key 直接定位到内部数组的索引，并不需要计算 hashcode()
        * 不但效率高，而且没有额外的空间浪费
        * */

    }
}
