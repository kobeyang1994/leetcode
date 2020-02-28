### 数组

**数组的解题思路：**

- n指针（一般都是收尾指针）
- 逆向思维 （从后向前遍历）
- 借助hashtable,stack,queue等
- 数组的交换记录被覆盖的元素防止元素丢失。

注意事项：

数组的长度，索引之间的关系。

**数组是什么？**

数组是一个线性表，存储相同数据结构的连续的内存空间。

**数组的优劣**

- 优势
  - 随机访问时间复杂度为常数级别。
    - 
  - 支持cpu缓存，访问速度更加快速。（因为内存空间是连续的所以知道收地址的内存地址，cpu缓存就可以预读整个数组的所有数据。）
    - 一维数组的内存计算公式：a[i]address = base_address + （i-1）*data_type_size
    - 二维数组的内存计算公式： address = base_address + ( i * n + j) * type_size
- 劣势
  - 删除慢
    - 删除一个数据需要进行数据搬移，是非常耗时的
    - 优化
      - 对删除的数据进行标记，不删除，当数组的存储空间不足的时候，在进行一次整体的删除操作，减少了搬移的次数（垃圾回收机制的标记清楚算法）
  - 插入慢
    - 插入数据的时候，数据搬移
    - 优化
      - 针对有序数组没发优化
      - 无序数组
        - 插入的新数据都插入末尾
        - 跟要插入的数据进行交换。 
  - 大小有限，警惕**数组索引越界（java.lang.ArrayIndexOutOfBoundsException）**
- 容器与数组的对比
  - 优势
    - 容器最大的优势就是**1将数组的操作细节封装了起来。2.支持动态扩容。**
  - 劣势
    - 容器不能存储基本数据类型
    - 数组效率高（知道数据大小的情况下）（底层开发数组的效率更高）
    - 多维情况下，数组更加直观

数组

| -题目名称-                                                   |
| ------------------------------------------------------------ |
| [Move Zero](https://leetcode-cn.com/problems/move-zeroes/)   |
| [climbing-stairs](https://leetcode.com/problems/climbing-stairs/) |
| [3sum](https://leetcode-cn.com/problems/3sum/ ](https://leetcode-cn.com/problems/3sum/)) |
| [container-with-most-water](https://leetcode-cn.com/problems/container-with-most-water/) |
| [two-sum]( https://leetcode-cn.com/problems/two-sum/](https://leetcode-cn.com/problems/two-sum/)) |
| [数组去重复](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/) |
| [rotate-array](https://leetcode-cn.com/problems/rotate-array/) |
| [merge-sorted-array](https://leetcode-cn.com/problems/merge-sorted-array/) |
| [plus-one](https://leetcode-cn.com/problems/plus-one/)       |

