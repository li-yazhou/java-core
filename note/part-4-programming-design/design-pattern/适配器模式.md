# 适配器模式

适配器中的代码将接收你拥有的接口，并产生你所需要的接口。

FilterAdapter 可以将 Filter 的接口转化为 Processor 的接口。
```
class FilterAdapter implements Processor {
    private Filter filter;
    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }
}
```