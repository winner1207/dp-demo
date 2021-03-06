## 题目描述
给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。

#### 示例：

#### 输入：
<pre>
matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
</pre>

#### 输出：
<pre>
15
</pre>

#### 解释：
> 边长为 1 的正方形有 10 个。  
> 边长为 2 的正方形有 4 个。  
> 边长为 3 的正方形有 1 个。  
> 正方形的总数 = 10 + 4 + 1 = 15.


#### 思路：
首先，暴力解就是以矩阵每一个点为起点，依次判断边长为1，2，3，...，min(矩阵长, 矩阵宽)的区域是否是正方形，显然复杂度是过不了。

很容易知道，上述过程在判断较大区域是否为正方形的时候，并没有用到前面计算的结果，每一次判断都从头开始。这也是复杂度过高的原因。

那么怎么利用之前判断过的结果呢？举个例子，比如我要判断以(2, 3)为右下角边长为3的正方形区域（红色边框区域）是否是全为1：

* 先判断(i, j)位置是否为1，如果否，则显然不满足；如果是，进行下一步判断
* 判断分别以(i - 1, j), (i - 1, j - 1), (i, j - 1)为右下角的区域是否能构成边长为2的正方形，如果能，那就满足条件。


![](http://qnfile.echatsoft.com/6ef1b6c1-2893-43b3-9b61-948ea2d1ba8f)

基于上述，我们可以看出思路大致跟最大正方形那题差不多，设dp[i][j][k]表示以(i, j)为右下角，边长为k的正方形区域是否全为1，那么易得出如下状态转移方程：

<pre>
dp[i][j][k] = (matrix[i][j] == 1 && dp[i - 1][j][k - 1] && dp[i][j - 1][k - 1] && dp[i - 1][j - 1] [k - 1]);
</pre>