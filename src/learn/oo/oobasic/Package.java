package learn.oo.oobasic;

import learn.test.Arrays;

public class Package {
    /*
    * 包机制解决的是类名冲突
    * 注意：包没有父子关系。 java.util 和 java.util.zip 是不同的包
    * import * 的时候，导入的 class 不包括子包的 class
    * 在代码中，当编译器遇到一个 class 名称时：
    * - 如果是完整类名（learn.dobedoo.oobasic.Package），就根据完整类名查找这个 class
    * - 如果是简单类名
    *   1. 查找当前 package
    *   2. 查找 import 的包
    *   3. 查找 java.lang
    * Java 默认导入 java.lang.*
    *
    * 如果有两个 class 名称相同，只能 import 一个，另一个必须写完整类名
    * */
    Arrays arrays = new Arrays();
    java.util.Arrays a = null;

    /*
     * 包作用域
     * 只能在包内访问
     */
    static String testPackageScope = "testPackageScope";
}
