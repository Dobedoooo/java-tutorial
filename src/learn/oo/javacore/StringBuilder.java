package learn.oo.javacore;

public class StringBuilder {
    public static void main(String[] args) {

        /*
        * java 编译器对 String 做了特殊处理，可以用 + 拼接字符串
        * 拼接时，会创建新的字符串对象，然后扔掉旧的字符串。这样一来，绝大部分字符串都是临时对象，不但浪费内存，还会影响 GC 效率
        * 为了能高效拼接字符串，java 标准库提供了 StringBuilder，他是一个可变对象，可以预分配缓存区
        * 往 StringBuilder 中新增字符时，不会创建临时对象
        *
        * 对于普通的字符串 + 操作，并不需要将其改写为 StringBuilder，因为 java 编译器在编译时就自动把多个连续的 + 操作编码为 StringConcatFactory 的操作
        * 在运行期间，StringConcatFactory 会自动把字符串连接操作优化为数组复制或者 StringBuiler 操作
        *
        * StringBuffer 是 StringBuilder 的线程安全版本，通过同步来保证多个线程操作 StringBuffer 也是安全的，但同步会带来执行速度的下降
        * */

        /*
        * 问题：超出预分配容量会发生什么
        * 答案：扩容
        * */
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("0123456789123456");
        System.out.println(sb.capacity());  // 16
        sb.append("7");
        System.out.println(sb.capacity());  // 34

        // 用 StringBuilder 构造 SQL 语句
        String[] fields = { "name", "position", "salary" };
        String table = "employee";
        String insert = buildInsertSql(table, fields);
        System.out.println(insert);
        String s = "INSERT INTO employee (name, position, salary) VALUES (?, ?, ?)";
        System.out.println(s.equals(insert) ? "测试成功" : "测试失败");
    }

    public static String buildInsertSql(String table, String[] fields) {
        java.lang.StringBuilder str = new java.lang.StringBuilder(100);
        str.append("INSERT INTO ")
                .append(table)
                .append(" (");
        for(int i = 0; i < fields.length; i++) {
            str.append(fields[i]);
            if(i != fields.length - 1) {
                str.append(", ");
            }
        }
        str.append(") VALUES (?, ?, ?)");
        return str.toString();
    }
}
