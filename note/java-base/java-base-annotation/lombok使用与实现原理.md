# lombok使用与实现原理


## lombok使用
* @Setter/@Getter
* @NoArgsConstructor, @RequiredArgsConstructor and @AllArgsConstructor
* @ToString
* @EqualsAndHashCode
* @Data, 相当于 @ToString, @EqualsAndHashCode, 所有字段 @Getter, 所有非final类型字段 @Setter, 以及 @RequiredArgsConstructor。
* @Builder，需要和@AllArgsConstructor一起使用。
* @Slf4j


## lombok实现原理

自从Java 6起，javac就支持“JSR 269 Pluggable Annotation Processing API”规范，只要程序实现了该API，就能在javac运行的时候得到调用。

Lombok就是一个实现了"JSR 269 API"的程序。在使用javac的过程中，它产生作用的具体流程如下：

* javac对源代码进行分析，生成一棵抽象语法树(AST)；

* javac编译过程中调用实现了JSR 269的Lombok程序；

* 此时Lombok就对第一步骤得到的AST进行处理，找到Lombok注解所在类对应的语法树(AST)，然后修改该语法树(AST)，增加Lombok注解定义的相应树节点；

* javac使用修改后的抽象语法树(AST)生成字节码文件。


## 参考
* [1] [lombok官方文档](https://projectlombok.org/features/all)



