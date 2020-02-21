### Tree


#### 1.树是什么？

**树是一种特殊的链表结构。**

树的结构很多，但是最常用的就是**二叉树**，n叉树也有许多应用的地方。

二叉树的基本实现：





#### 2.二叉树

二叉树：每个节点最多只有两个分叉，也就是两个字节点。

二叉树的基本实现：

```java
public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
```



**二叉树的种类：**

- 完全二叉树
- 满二叉树
- 查找二叉树
- 平衡查找二叉树



**二叉树的遍历方式：**（代码见[github](https://github.com/kobeyang1994/leetcode) package tree）

- 深度优先
  - 先序遍历
  - 中序遍历
  - 后序遍历
- 层级遍历

