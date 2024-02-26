package learn.oo.javacore;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UseMap {
    public static void main(String[] args) {
        /*
        * 通过一个键去查询对应的值，使用 List 效率低
        * Map 这种键值映射表的数据结构，作用就是能高效通过 key 快速查找 value
        * */
        Student student = new Student("xiao ming", 99);
        Map<String, Student> map = new HashMap<>();
        map.put("xiao ming", student);
        Student target = map.get("xiao ming");
        System.out.println(target  == student);     // true, 返回同一个实例
        System.out.println(target.score);           // 99
        Student another = map.get("Bob");           // 通过另一个 key 查找
        System.out.println(another);                // 未找到返回 null

        /*
        * 如果想查询某个 key 是否存在，调用 boolean contains(K key) 方法
        * */
        System.out.println(map.containsKey("xiao ming"));

        /*
        * 对同一个 key 调用两次 put() 方法，会替换掉旧值并返回
        * value 可以重复
        * */
        Map<String, Integer> map1 = new HashMap<>();
        Object put1 = map1.put("apple", 1); // 返回null
        System.out.println(put1);       // null

        Object put2 = map1.put("apple", 2); // 用 2 替换 1 并返回1
        System.out.println(put2);       // 1

        /*
        * 遍历 Map
        * 1. 遍历 key：使用 for each 循环遍历 Map 实例的 keySet() 方法返回的 Set 集合
        * 2。 同时遍历 key-value
        * */
        map1.put("pear", 49);
        map1.put("banana", 23);

        // 1. 遍历 key
        System.out.println("--- traverse key ---");
        for(String s: map1.keySet()) {
            System.out.println(s);
        }
        // 2. 遍历 key-value，不保证顺序
        System.out.println("--- traverse key-value ---");
        for(Map.Entry<String, Integer> entry: map1.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        /*
        * 练习：编写一个根据 name 查找 score 的程序，并利用 Map 充当缓存，以提高查找效率
        * */
        List<Student> list = new ArrayList() {{
           add(new Student("xiao ming", 88));
           add(new Student("Bob", 78));
           add(new Student("Alice", 85));
           add(new Student("xiao lan", 78));
        }};
        Students holder = new Students(list);
        System.out.println(holder.getScore("Bob") == 78 ? "测试成功!" : "测试失败!");
        System.out.println(holder.getScore("Alice") == 85 ? "测试成功!" : "测试失败!");
        System.out.println(holder.getScore("Tom") == -1 ? "测试成功!" : "测试失败!");
    }
}

class Students {
    List<Student> students;
    Map<String, Integer> cache;

    public Students(List<Student> list) {
        students = list;
        cache = new HashMap<>();
    }

    int getScore(String name) {
        // 先在 Map 中查找
        Integer score = cache.get(name);
        if(score == null) {
            score = findInList(name);
        }
        return score == null ? -1 : score.intValue();
    }

    Integer findInList(String name) {
        for(Student student: students) {
            if(student.getName().equals(name)) {
                return student.getScore();
            }
        }
        return null;
    }
}
