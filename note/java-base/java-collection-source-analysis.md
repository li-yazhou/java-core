# Java 集合源码分析


# 【Java集合】Java8 HashMap工作原理与实现
## 概述
首先，抛出几个问题：
>1. 什么时候会使用HashMap？它有什么特点？
><br>
>2. 你知道HashMap的工作原理吗？
><br>
>3. 你知道get和put的原理吗？equals()和hashCode()的都有什么作用？
><br>
>4. 你知道hash的实现吗？为什么要这样实现？
><br>
>5. 如果HashMap的大小超过了负载因子(load factor)定义的容量，怎么办？

## 初识HashMap
>可以认为是HashMap是存放键值对的集合。
>HashMap与Hashtable的区别，[参考另一篇博客](http://blog.csdn.net/liyazhou0215/article/details/75909735)


----------


## put方法添加元素的过程

1. 对 key 的 hashCode() 做 hash 计算，然后在计算 index，index 是长度为M数组的索引；<br/>
<br/>
2. 如果没有碰撞，把该对象直接放到bucket（数组）中；<br/>
<br/>
3. 如果碰撞，则存放到以下标index的元素作为开头的链表中；<br/>
<br/>
4. 如果碰撞导致链表过长（大于等于TREEIFY_THRESHOLD），就把同一个hash值的元素所组成的链表转换成**红黑树（属于 Java8 优化的部分）**<br/>
<br/>
5. 如果结点已经存在，则替换掉old value（保证key的唯一性）<br/>
<br/>
6. 如果bucket的使用率超过负载因子（load factor），就要resize 加倍容量bucket/table（数组+链表）的大小。由于计算index跟容量有关，所以需要rehash所有元素，并把它们存放到这个新的bucket中。因此，HashMap不能确保元素的次序始终不变（it does not guarantee that the order will remain constant over time）。 
<br/>
<br/>

**put源码如下**

```java
public V put(K key, V value) {
    // 对key的hashCode()做hash
    return putVal(hash(key), key, value, false, true);
}

final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
               boolean evict) {
    Node<K,V>[] tab; Node<K,V> p; int n, i;
    // tab为空，也即是table中还没有元素，则创建一个默认长度为16的table数组
    if ((tab = table) == null || (n = tab.length) == 0)
        n = (tab = resize()).length;
    // 计算index，如果该索引处为null，也即没有hash碰撞时，直接把元素存储起来即可
    // 计算索引的方法 i = (n - 1) & hash，它跟table数组的长度是紧密相关的，
    // 所以当table的长度发生变化时，需要重新计算所有元素的索引 
    if ((p = tab[i = (n - 1) & hash]) == null)
        tab[i] = newNode(hash, key, value, null);
    else {  // 如果该索引（下标）处不为空，也即是存在元素，则分以下若干种情况处理
        Node<K,V> e; K k;
        // 情况一：如果两者的hash值相等，且它们的键相等时，更新该元素
        // 键相等判断，首先判断hashCode（或者hash值），hashCode相等且它们的key的值也相等，则更新该元素
        if (p.hash == hash &&
            ((k = p.key) == key || (key != null && key.equals(k))))
            e = p;
        // 情况二：hashCode不相等或者hashCode相等但是key值（也即equals）不相等时，需要插入该元素
        // 情况二：1，如果该链为树，则将该元素插入到红黑树中
        else if (p instanceof TreeNode)
            e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
        // 情况二：2，如果该链为链表，则将该元素插入到链表中
        else {
            for (int binCount = 0; ; ++binCount) {
                if ((e = p.next) == null) {
                    p.next = newNode(hash, key, value, null);
                    if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                        treeifyBin(tab, hash);
                    break;
                }
                if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                    break;
                p = e;
            }
        }
        // 写入......
        if (e != null) { // existing mapping for key
            V oldValue = e.value;
            if (!onlyIfAbsent || oldValue == null)
                e.value = value;
            afterNodeAccess(e);
            return oldValue;
        }
    }
    ++modCount;
    // 超过load factor*current capacity，resize，
    // 也即是table数组的使用率超过装载因子，需要扩大一倍table的容量
    if (++size > threshold)
        resize();
    afterNodeInsertion(evict);
    return null;
}
```

## get方法获取value的过程
1. 和put方法一样，首先计算index，如果bucket为null，则返回null
<br>
2. 如果bucket中只有一个元素，则直接命中，取出value即可
<br>
3. 如果碰撞，则通过key.equals(k)查找对应的entry（Node）
    如果是链表，则遍历链表，通过key.equals(k)判断是否命中，时间复杂度是 O(n)
    如果是红黑树，则查找的时间复杂度是 O(lgn)
<br>

**get方法源码如下**

```
   final Node<K,V> getNode(int hash, Object key) {
       Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
       if ((tab = table) != null && (n = tab.length) > 0 &&
           (first = tab[(n - 1) & hash]) != null) {  // 如果第一个元素为null，则返回null
        // table中的某一bucket中存在跟当前key相等的结点
        // 如果在bucket的第一个元素命中，则直接返回第一个元素
           if (first.hash == hash && // always check first node
               ((k = first.key) == key || (key != null && key.equals(k))))
               return first;
           // 如果跟bucket中的第一个元素不相等，则跟后面的元素对比
           if ((e = first.next) != null) {
            // 如果解决碰撞（冲突）的方式的红黑树，则在红黑树中查找
               if (first instanceof TreeNode)
                   return ((TreeNode<K,V>)first).getTreeNode(hash, key);
               do {  // 如果解决碰撞的方式是链表，则在链表中线性遍历查找
                   if (e.hash == hash &&
                       ((k = e.key) == key || (key != null && key.equals(k))))
                       return e;
               } while ((e = e.next) != null);
           }
       }
       return null;
   }
```

## hash函数（散列函数）的实现
key的hashCode()和table数组的长度作为计算hash值的参数。
计算过程是，
1. 将hashCode的前16位和后16为做异或运算（两个数字做异或运算，有一个1则结果为1）

计算索引是在计算hash值的基础上，将上面结果跟数组长度-1做按位与运算（按位与运算，有两个1则结果为1），这样结果一定位于[0, length)之间。


**hash函数源码如下：**
```
static final int hash(Object key) {
    int h;
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
}

```

代码注释给出第一步的解释如下：
Computes key.hashCode() and spreads (XORs) higher bits of hash to lower.  Because the table uses power-of-two masking, sets of hashes that vary only in bits above the current mask will always collide. (Among known examples are sets of Float keys holding consecutive whole numbers in small tables.)  So we apply a transform that spreads the impact of higher bits downward. There is a **tradeoff between speed, utility, and quality of bit-spreading**. Because many common sets of hashes are already reasonably distributed (so don't benefit from spreading), and because we **use trees to handle large sets of collisions in bins**, we **just XOR some shifted bits in the cheapest possible way to reduce systematic lossage**, as well as to incorporate impact of the highest bits that would otherwise never be used in index calculations because of table bounds.

在设计hash函数时，因为table的长度n为2的幂，所以是hashCode的前16位和后16位按位与运算，而不是整数除留余数法（%n）。**这种做法将在resize函数中发挥着极为重要的作用。**

在Java 8 之前的实现中，使用链表解决冲突的，在产生碰撞的情况下，进行get操作的时间复杂度是O(1)+O(n)。因此，当碰撞较严重，也就是n较大时将严重地影响查找速度。

Java 8 改进了这一点，当链表长度超过 TREEIFY_THRESHOLD时，将链表中的元素构建为一棵红黑树，这样时间复杂度降低为 O(1)+O(logn)。

## RESIZE 的实现

进行put操作后，如果发现table数组的利用率超过了装载因子（Load Factor），就会将table的容量扩充为原来的2倍，之后重新计算各个元素的index，并将它们插入到新的table中。

resize函数上的注释为：
nitializes or doubles table size. If null, allocates in accord with initial capacity target held in field threshold. Otherwise, because we are using power-of-two expansion, the elements from each bin must ** either stay at same index, or move with a power of two offset ** in the new table.

也即是，当table容量扩展为原来的2倍后，元素的index要么跟原来一样，要么在原位置的基础上移动2次幂的位置。

怎么理解呢？
例如table容量从16扩展为32时，各个元素key 的hash值（hashCode的前16位和后16位按位与操作的结果）的每一位数字要么是0要么是1，它们是不变的。
而 index = hash*（n-1），n加倍了，相当于n-1的最高位与hash值中对应位置上的数字按位与得到一个结果 x，将这个x与没扩容前的index求和就得到了该元素在新table中的index。

**注：n-1 = power(2, m) - 1，把它转换成二进制，32位的二进制中各个低位都为1，各个高位都为0。**

这个计算index的设计十分巧妙， 既省去了重新计算hash值，而且同时，由于新增的1 bit是0还是1可以认为是随机的，因此resize的过程，均匀地把之前冲突的结点分散到新的bucket了。

**resize的源码如下：**

```
final Node<K,V>[] resize() {
    Node<K,V>[] oldTab = table;
    int oldCap = (oldTab == null) ? 0 : oldTab.length;
    int oldThr = threshold;
    int newCap, newThr = 0;
    if (oldCap > 0) {
        // 超过table的最大容量就不再扩充，就只好随你碰撞去吧
        if (oldCap >= MAXIMUM_CAPACITY) {
            threshold = Integer.MAX_VALUE;
            return oldTab;
        }
        // 没超过最大值，就扩充为原来的2倍
        else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                 oldCap >= DEFAULT_INITIAL_CAPACITY)
            newThr = oldThr << 1; // double threshold
    }
    else if (oldThr > 0) // initial capacity was placed in threshold
        newCap = oldThr;
    else {               // zero initial threshold signifies using defaults
        newCap = DEFAULT_INITIAL_CAPACITY;
        newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
    }
    // 计算新的resize上限
    if (newThr == 0) {
        float ft = (float)newCap * loadFactor;
        newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                  (int)ft : Integer.MAX_VALUE);
    }
    threshold = newThr;
    @SuppressWarnings({"rawtypes","unchecked"})
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
    table = newTab;
    if (oldTab != null) {
        // 把每个bucket都移动到新的buckets中
        for (int j = 0; j < oldCap; ++j) {
            Node<K,V> e;
            if ((e = oldTab[j]) != null) {
                oldTab[j] = null;
                if (e.next == null)
                    newTab[e.hash & (newCap - 1)] = e;
                else if (e instanceof TreeNode)
                    ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                else { // preserve order
                    Node<K,V> loHead = null, loTail = null;
                    Node<K,V> hiHead = null, hiTail = null;
                    Node<K,V> next;
                    do {
                        next = e.next;
                        // 原索引
                        if ((e.hash & oldCap) == 0) {
                            if (loTail == null)
                                loHead = e;
                            else
                                loTail.next = e;
                            loTail = e;
                        }
                        // 原索引+oldCap
                        else {
                            if (hiTail == null)
                                hiHead = e;
                            else
                                hiTail.next = e;
                            hiTail = e;
                        }
                    } while ((e = next) != null);
                    // 原索引放到bucket里
                    if (loTail != null) {
                        loTail.next = null;
                        newTab[j] = loHead;
                    }
                    // 原索引+oldCap放到bucket里
                    if (hiTail != null) {
                        hiTail.next = null;
                        newTab[j + oldCap] = hiHead;
                    }
                }
            }
        }
    }
    return newTab;
}
```

## 总结
我们现在可以回答开始的几个问题，以加深对HashMap的理解。

1. 什么时候会使用HashMap？它有什么特点？
> 是基于Map接口的实现，HashMap存储Map.Entry(hash, key, value, next)对象。
>特点一， 存储键值对时，它可以接受null的键和值（由于Map中的键是唯一的，所以最多只有一个键为 null 的键值对）；
>特点二，它是非同步的。

2. 你知道HashMap的工作原理吗？
HashMap最为重要的两个操作是 put（插入或更新对象） 和 get（根据键获取对象）。
>put，存储或者更新对象时，将K/V传递给put方法，put会先调用hash函数计算key的hash值，然后结合table容量计算index，然后将该键值对插入或者更新；
>如果产生碰撞，当碰撞元素个数小于TREEIFY_THRESHOLD阈值时，将元素放置在链表末尾，也就是使用链表解决碰撞问题；当碰撞元素个数大于等于TREEIFY_THRESHOLD阈值时，将链表中的元素创建一棵红黑树；
>如果HashMap的table使用率超过装载因子（load factor），它将调用resize函数，将table的容量增大一倍（扩展为原来的2倍），然后，根据原来table中每个元素的hash值（不需要重复计算，Entry包含这个属性，hash, key, value, next）和table的新容量n-1 重新计算它们在新table中的位置。
>
> get，获取对象时，将K传递给get方法，get会调用hashCode方法，然后通过hash散列函数计算出hash值，结合table容量n-1计算出index，进一步调用equals方法确定键值对。

3. 你知道put和get的原理吗，hashCode()和equals()都有什么作用吗？
>在put或get操作时，通过key的hashCode进行计算hash值（hashCode的高16位和低16位进行按位异或操作的结果），然后根据HashMap的容量n计算index（index=（n-1）&hash）。
>如果产生碰撞，则使用key.equals()方法去链表或者平衡树中查找对应的键值对。
>
>讨论一下键值对是否能够成功插入到HashMap中：
>(1) 如果hashCode是唯一的，则一定可以插入（不考虑极端情况，比如内存不足等因素）；
>(2) 如果hashCode值在HashMap中出现过，且它们两者调用equals返回true，则更新键值对；
>(3)如果hashCode值在HashMap中出现过，且它们两者调用equals返回false，则产生碰撞，将该键值对插入到链表或者平衡树中；
>（hashCode是定位的，存储位置；equals是定性的，比较两者是否相等）
>
>建议：
>重写hashCode和equals两个方法结果的一致性。
>当元素插入到HashMap之后，不要修改影响hashCode结果的成员变量，否则，不能保证key的唯一性。
>最好使用不可变对象作为key。

4. 你知道hash的实现吗？为什么要这样实现？
>在Java8的实现中，是通过将hashCode结果的高16位和低16位按位异或计算出来的，(h = key.hashCode()) ^ (h >>> 16)。
>主要是从速度、功效、质量考虑的，这么做可以在table的n较小的时候，也能保证高低位都参与到hash的计算中，同时不会有太大的开销。
>而且，这个计算是一次性的，当resize时，也不需要重新计算hash值。

5. 如果HashMap的大小超过了装载因子（load factor）定义的容量，怎么办？
> 如果table容量的使用率等于大于装载因子（默认是0.75）时，则会调用resize方法产生一个原来大小两倍的table，并且重新计算每个元素的index（不必重新计算hash方法，因为根据定义每次计算的结构都是一样的，不过得把这个值保存起来，Entry(hash, key, value, next)）
> 注：各种集合的默认参数
> HashMap，默认容量是16，装载因子是 0.75
> ArrayList，默认长度是 10


## 补充
HashMap中的各个常量

```
 /**
  * The default initial capacity - MUST be a power of two.
  */
 static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

 /**
  * The maximum capacity, used if a higher value is implicitly specified
  * by either of the constructors with arguments.
  * MUST be a power of two <= 1<<30.
  */
 static final int MAXIMUM_CAPACITY = 1 << 30;

 /**
  * The load factor used when none specified in constructor.
  */
 static final float DEFAULT_LOAD_FACTOR = 0.75f;

 /**
  * The bin count threshold for using a tree rather than list for a
  * bin.  Bins are converted to trees when adding an element to a
  * bin with at least this many nodes. The value must be greater
  * than 2 and should be at least 8 to mesh with assumptions in
  * tree removal about conversion back to plain bins upon
  * shrinkage.
  */
 static final int TREEIFY_THRESHOLD = 8;

 /**
  * The bin count threshold for untreeifying a (split) bin during a
  * resize operation. Should be less than TREEIFY_THRESHOLD, and at
  * most 6 to mesh with shrinkage detection under removal.
  */
 static final int UNTREEIFY_THRESHOLD = 6;

 /**
  * The smallest table capacity for which bins may be treeified.
  * (Otherwise the table is resized if too many nodes in a bin.)
  * Should be at least 4 * TREEIFY_THRESHOLD to avoid conflicts
  * between resizing and treeification thresholds.
  */
 static final int MIN_TREEIFY_CAPACITY = 64;

```
装载因子 load factor，默认是0.75，它的含义是Entry的数量占table容量的比例，而不是被占用的bucket占table容量的比例。

在此，特别感谢姜逸坤大神，本博客的结构以及大部分内容均参考其相关的资料，再次表示感谢。
**参考资料：**
姜逸坤 - [Java-HashMap工作原理及实现](http://yikun.github.io/2015/04/01/Java-HashMap%E5%B7%A5%E4%BD%9C%E5%8E%9F%E7%90%86%E5%8F%8A%E5%AE%9E%E7%8E%B0/)

