# 优雅的遍历

编程即处理数据，存取数据是处理数据的根基。

数据一般会被存放在数组或者集合中，本文将介绍数组和集合的遍历。


使用for还是while循环，有一句大家耳熟能详的忠告，当已知循环次数则使用for循环，不知循环次数时使用while循环。
不过不能以此低估了for的威力，绝大多数时机使用for都是更佳的选择。

## 简单的while循环

### while

```
boolean bool;
while(bool) {
    // repeated code blocks;
    // change bool to false
}
```


### do..while

```
boolean bool;
do {
    // repeated code blocks;
    // change bool to false
} while (bool);
```



## 简洁优雅而无所不能的for循环

实例
```
/* 将文件内容按行缓存到List对象中，此处省略异常处理代码 */
List<String> jsonList = new ArrayList<>();
InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
for (String line; (line = reader.readLine()) != null; jsonList.add(line));
```

遍历Iterator实例
遍历Enumeration实例


## foreach（语法糖）

## iterator（讲解原理）

