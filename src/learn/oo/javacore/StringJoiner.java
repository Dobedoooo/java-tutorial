package learn.oo.javacore;

public class StringJoiner {
    public static void main(String[] args) {
        /*
        * 用分隔符拼接数组的需求很常见，java 标准库提供了一个 StringJoiner 来干这个事
        *
        * */
        String[] names = {"a", "b", "c"};
        java.util.StringJoiner sj = new java.util.StringJoiner(", ", "Hello ", "!");
        for(String name: names) {
            sj.add(name);
        }
        System.out.println(sj.toString());

        /*
        * String 还提供了一个静态方法 join()，这个方法在内部使用了 StringJoiner 来拼接字符串，在不需要指定 prefix suffix 的时候更方便
        * */
        String str = String.join(", ", names);
        System.out.println(str);

        // 用 StringJoiner 构造 SQL 语句
        String[] fields = { "name", "position", "salary" };
        String table = "employee";
        String select = buildSelectSql(table, fields);
        System.out.println(select);
        System.out.println("SELECT name, position, salary FROM employee".equals(select) ? "测试成功" : "测试失败");
    }

    static String buildSelectSql(String table, String[] fields) {
        String sql = "";
        java.util.StringJoiner sj = new java.util.StringJoiner(", ", "SELECT ", " FROM " + table);
        for(String field: fields) {
            sj.add(field);
        }
        return sj.toString();
    }
}
