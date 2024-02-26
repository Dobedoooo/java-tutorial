package learn.oo.javacore;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.Object;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class JavaBean {
    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
        for(PropertyDescriptor propertyDescriptor: beanInfo.getPropertyDescriptors()) {
            System.out.println(propertyDescriptor.getName());
            System.out.println(" " + propertyDescriptor.getReadMethod());
            System.out.println(" " + propertyDescriptor.getWriteMethod());
        }
    }
}

class Student extends Person {
    protected Integer score;
    public Student() {}
    public Student(String name, int score) {
        super(name, 18);
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}

class Person {
    protected String name;
    protected Integer age;

    public Person() {}

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "{name: " + name + ", age: " + age + "}";
    }

    /*
    * 重写 equals
    * */
    // 1. 这种写法 this.name 为 null 时会抛出异常(NullPointerException)
//    @Override
//    public boolean equals(Object o) {
//        if(o instanceof Person) {
//            Person person = (Person) o;
//            System.out.println(this.name);
//            return this.name.equals(person.name) && this.age.equals(person.age);
//        }
//        return false;
//    }
    /*
     * 2. 如果 Person 类有多个引用类型字段，这种写法过于复杂
     *    要简化引用类型的比较，使用 Objects.equals() 方法
     */
//    @Override
//    public boolean equals(Object obj) {
//        if(obj instanceof Person) {
//            Person person = (Person) obj;
//            boolean nameEqual = false;
//            if(name == null && person.name == null) {
//                nameEqual = true;
//            }
//            if(name != null) {
//                nameEqual = name.equals(person.name);
//            }
//            return nameEqual && age.equals(person.age);
//        }
//        return false;
//    }
    // 3.
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Person) {
            Person person = (Person) obj;
            return Objects.equals(name, person.name) && Objects.equals(age, person.age);
        }
        return false;
    }

}
