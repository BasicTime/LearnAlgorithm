## 第零章序
一切都是技术问题，和智商没关系，写不出来是缺乏练习。  
知道思路，多练习，总结代码块习惯
## 一些技巧
> 
>//1
mid = (L+R)/2 => mid = L+((R-L)>>1);//计算中数  
//2
swap(int [] arr,int idx1,int idx2){  
    arr[idx1] = arr[idx1]^arr[idx2];  
    arr[idx2] = arr[idx1]^arr[idx2];  
    arr[idx1] = arr[idx1]^arr[idx2];  
}



## 第一章节
时间复杂度为一个算法中，最差常数操作数的指标。  
额外空间复杂度，有限几个变量O(1),辅助数组空间O(n)
### 1.一个N长度有序数组a，一个M无序数组b，打印出b中不在a中的数？

>1）双重遍历  
O(M\*N)  
2）在a中通过二分查找b中的每个数  
O(M\*logN)  
3）先排序b，在通过外排比较的方式比较有序数据a和有序数据b'的数  
O(M\*logM)+O(M+N)  
tips：  
比较2）和3）时间复杂度问题，  
如果a很短，b很长，2）更优  
如果a很长，b很短，3）更优  

###2.冒泡排序  
> 每次比较前一个数和当前数，如果前一个数更大就交换，其他情况就往下走。  
说明：每次遍历都只排序好一个最大的数到当前循环体的末尾
如：  
第一次循环，0到length-1把最大值交换到length-1位置  
第二次循环，0到length-2把最大值交换到length-2位置  
第三次循环，0到length-3把最大值交换到length-3位置  
...  

### 3.选择排序
> 每次循环找出一个最小的数，做多做一次交换  
> 第一次循环，由0到length-1 找到最小值，记录下标，交换到0位置  
> 第二次循环，由1到length-1 找到最小值，记录下标，交换到1位置上  
> 第三次循环，由2到length-1 找到最小值，记录下标，交换到2位置上  
> ...  

### 4.插入排序
> 每次循环比较当前值和之前的数据列表中的值（下标由最大向前递减），
>如果当前值比较小，集合中的数就与后一个数交换

排序情况和数据状况有关时，按照最差的估计  
`最好情况`
有序的时候O(n)  
`最差情况`
逆序的时候O(n<sup>2</sup>)  
`平均情况`

### 4.小结
外层循环界定内层循环边界

### 5.递归的行为和递归的时间复杂度
进栈和出栈的过程  
递归都可以用非递归的方式修改，就是自己做进栈和出栈的过程  
递归行为的复杂度  
`估计递归时间复杂度的通式` 
T(N) = aT(n/b)+O(n<sup>d</sup>)  
n 样本量  
n/b 子过程的样本量  
a 多少个子过程  
O(n<sup>d</sup>)除去调用子过程外的时间复杂度  
当 b=2,a=2,d=0 => 2T(n/2)+O(1) 满足这个公式的直接按照通式计算时间复杂度   
T(N) = a*T(N/b) + O(N<sup>d</sup>)  
1) log(b,a) > d ->时间复杂度O(N<sup>log(b,a)</sup>)  
当a=b=2,d=0时，递归时间复杂度O(N)
2) log(b,a) = d ->时间复杂度O(N<sup>d</sup>*log(2,N))  
当a=b=2,d=1时，递归时间复杂度O(Nlog2<sup>N</sup>)
3) log(b,a) < d ->时间复杂度O(N<sup>d</sup>)  
当a=b=2,d=2时候,递归时间复杂度为O(N<sup>2</sup>)
### 6.用递归的方式查找数据组中最大值
> 递归使用分治思想

### 7.归并排序
时间复杂度O(N*logN),额外空间复杂度O(N)
1. 通过分治思想，把样本才分有2，进行左右一共2次的拆分进行排序
2. 把左右两个有序数组merge到一个help数组
3. 再help数组交换到原数组  

通过master公式计算分治思想的算法复杂度  
a=b=2,T(n) = 2(n/2)+O(n<sup>1</sup>)=> a=b=2 > d=1 => 时间复杂度为O(n*log2<sup>n</sup>)  
空间复杂度，使用了help[n]数组与样本量一样所以为O(N)

### 8.小结
在使用递归传递参数时，需要区分传递的是下标或是长度（比如，传递长度就是arr.length，传递下标就是arr.length-1），
需要作区分，所以统一在传递的时候都传入下标以作区分。  
归并排序每次merge的时候，都是左右两个区间比较，所以只要merge后，下次比较就是和另外的区间比较，所以快  
利用有序数据来加速merge    

### 9.小和问题
> 在一个数组中，每一个数左边比当前数晓得数累加起来，叫做这个数组的小和。求一个数组的小和。
>例子：  
>[1,3,4,2,5]  
>1左边比1小的数，没有；  
>3左边比3小的数，1  
>4左边比4小的数，1，3  
>2左边比2小的数，1  
>5左边比5小的数，1，3，4，2  
>所以小和为1+1+3+1+1+3+4+2=16

说明
> 通过归并排序的方式，每次merge的时候，都压榨左边比右边小的数*(R-idxr+1)的小和然后累加

### 10.逆序对问题
> 一个数组中，左边的数如果比右边的数大，则这两个数构成一个逆序对，请打印所有逆序对。

## 第二章

### 11.给定一个数组arr，和一个数num，请把小于等于num的数放在num的左边，大于num的数放右边
> 要求额外空间复杂度O(1),时间复杂度O(n)

`partition`

1 划定一个区域叫做小于等于num的区域，区域的区间就是x~L，初始化时x=-1

>  * 当x=-1时，表示-1到0的区间内的数小于等于num，没有
>  * 当x=0时，表示0到0区间的数小于等于num，有一个下标为0
>  * ...
>  * 当x=5时候，表示0到5区间的数小于num，有6个
>  * x始终保持在小于等于num区间的有边界下标上

2 始终cur往移动，当arr[cur]<=num时，swap(arr,++boundary,cur++)  


### 12.荷兰国旗
给定一个长度为n的数组arr，和一个数num，请把小于num的数放左边，等于num的数放中间，大于num的数放右边
> 额外空间复杂度O(1),时间复杂度O(n)
> 定义boundaryL=-1，boundaryR=arr.length  
>当arr[cur]<num时，swap(arr,++boundaryL,cur++)  
>当arr[cur]>num时，swap(arr,--boundaryR,cur)cur交换了一个没有比较的数到当前位置，所以需要再次比较，cur不用移动  
>当arr[cur]==num时，cur++
### 小结
1. L和R以及mid始终表示为左右边界下标，一般不会用这些变量直接做加减操作，如果要让当前下标移动，
需要定义一个比如i,j,idxL,idxR,cur,less,more,boundaryL,boundaryR等可以移动的下标变量  
2. 算法根样本状况有关的话，绕开样本状况处理技巧，1用`随机`，2用`hash算法`

### 13.随机快排的细节和复杂度分析
利用荷兰国旗问题来改进快速排序  
时间复杂度O(N\*logN),额外空间复杂度O(logN)  
分治思想，分左中右，三个区域，每个小于给定num的数放在左边，等于数值放在中间，大于的放在右边  
经典快排时间复杂度跟数据状况有关（左右区间数据都是同样多的时候状况最好，一个区间没有数据，
另一个区间数据是全数据，这个情况最差），利用随机数来打破数据状况起到加速的作用  
概率事件，需要用长期期望得到时间复杂度，数学证明结果O(N\*logN)  
最常使用的排序，随机快排，同样是O(N\*logN)的算法，但是由于常数操作很少，与mergeSort相比，需要
使用help数据操作  
记录每次的断点（左右区间区分的下标），整个数组最好情况需要通过O(logN)个断点来记录(每次打在中间位置)，
最坏情况O(N)(每次打在最边上位置)  

### 14.递归改非递归  

### 15.堆排序
完全二叉树，完全按照由上到下，由左到右的顺序  
满二叉树：叶节点是满的，所有父节点都有两个叶节点  
堆：可以由数组来构造，arr数组，cur下标，当前节点，cur的左孩子下标是cur\*2+1，右边孩子下标是cur\*2+2
cur下标节点的父节点是(cur-1)/2  
堆：大根堆（在完全二叉树中，任何一棵子树的最大值，都是他的头节点）、小根堆（在完全二叉树中，
任何一棵子树的最小值，都是他的头节点）  
#### 数组转换为大根堆，数组建立大根堆
外层循环遍历每个节点，内层方法用坐标变换的方式查找头节点和叶子节点，并对数值作比较  
头结点：head = (cur-1)/2  
时间复杂度：log1+log2+log3+...+log(n-1) = O(n)  
heapInsert()  
#### 大根堆数据发生变化，通过heapIfy变换为大根堆
heapIfy()  
heapSize 整个需要交换范围内的数组长度  
heapIfy 比较的时候，需要先比较left 和 right 的大小得出largest，再largest和cur比较  

### 小结
* 树结构中变换只利用cur，当前坐标做上下头结点坐标和叶节点坐标计算会很方便，如果还引入head、tail、next等坐标
会很麻烦
* 树结构操作，利用left 可以 计算出right => right = left + 1
* 优先级队列是堆结构
* 堆结构能搞定所有贪心结构   
* 堆排序就是利用堆结构做的排序算法  
### 流中获取中位数
> 中位数（Median）又称中值，统计学中的专有名词，是按顺序排列的一组数据中居于中间位置的数

利用原始做法，数组每次获得流中一个数，就得把当前容器（数组）排序（O(n\*logN)）后才能得到中位数  
利用堆的做法，建立一个大根堆，建立一个小根堆，~~每次数据进入前先进入大根堆~~当进入数据小于大根堆
的对顶就放到大根堆里面，大于大根堆的对顶就放到小跟堆里面去，每次放完数据（不管是放到大根堆还是小跟堆）
后然后判断大根堆和小跟堆的长度（heapSize），大根堆和小根堆的数据（heapSize）始终保持在N/2个数据
（|heapSize1-heapSize2|=2就要调整）。  

>* 如果大根堆的heapSize过长，就把堆顶交换到最后一个数据，然后最后一个数据放到小跟堆的最后一个数，并且把大根堆
的heapSize-1，大根堆处理一个HeapIfy，小跟堆HeapSize+1，并且处理一个HeapInsert
>* 同理小跟堆的heapSize过长，就把堆顶交换到最后一个数据，然后最后一个数据放到大根堆的最后一个数据，并且小跟堆
的HeapSize-1，小跟堆处理个一个HeapIny，大根堆HeapSize+1，并处理一个HeapInsert

## 第三章

### 排序问题的稳定性
> 排序完成后保证原始的数据相对顺序不变，比如2，3，1，3，2，5，1排序后1，1，2，2，3，3，5
>中的第一个1和第二个1的相对顺序是保持和原来一直的，同理第一个2，和第二个2相对顺序不变

#### 稳定性排序的意义
业务上需要，如一个对象中多个维度排序时候，如果具有稳定性排序的话，后一次排序的时候，会保留上次排序的顺序。
* 冒泡排序可以具有稳定性的实现，每次比较的时候相等就不交换O(n<sup>2</sup>)
* 插入排序可以具有稳定性实现，每次往前比较并插入的时候，如果相等就不再交换O(n<sup>2</sup>)
* 选择排序，每次选择一个最小的数跟第一个没有排序的数据比较并交换，不能稳定性实现O(n<sup>2</sup>)
* 归并排序能做到稳定，merge过程中，左边和右边相等时，先拷贝左边的到help数组中，再拷贝右边的到help数组中O(n\*logN>)
* 快速排序无法做到稳定性排序，partition的时候，小于一个数值放左边大于一个数值放右边等于一个数值放中间，在这个过程中
不能做到稳定 
* 堆排序无法做到稳定性，在heapInsert时，如arr[]=4,4,4,5 在进行heapInsert的时候5和第二个4交换，此时
第二个4和第三个4就发生了位置改变O(n\*logN)

### 工程中的综合排序，需要结合代码核对一下
1. 如果数组中是基础类型(排除bool类型的7中基础类型)，使用的是快速排序算法，自定义类型class，系统会用归并排序处理。
2. 如果数组的元素很少，系统会直接选择插入排序 ，插入排序是O(n<sup>2</sup>)但是常数项很低，而且，基数很小，N<sup>2</sup>
的时间复杂度劣势表现不出来
3. 综合排序中如果是基础类型就使用快排，是因为基础类型并不需要关心排序稳定性问题，自定义class用归并排序也是因为稳定性问题才使用

### 补充问题
归并排序可以做到额外空间复杂度为O(1),归并排序，内部缓存法  
快速排序，可以做到稳定排序，“01 stable sort”  
整数数组，奇数放左边偶数放右边，奇数保证原来的顺序，偶数保证原来的顺序，额外空间复杂度O(1),时间复杂度O(N),
也是“01 stable sort”。

### 比较器
1. 系统自带的比较器`java.util.Comparator`
2. 利用java.util.PriorityQueue优先队列堆结构排序
3. 利用treeSet树结构排序

### 英语
> 一月:January、二月:February、三月:March、四月:April、五月:May、六月:June、七月:July、
>八月:August、九月:September、十月:October、十一月:November、十二月:December。


### 桶排序、计数排序、基数排序
> * 非基于比较的排序，跟数据状况有很大关系，实际中并不常用
> * 时间复杂度O(N),额外空间复杂度O(N)
> * 具有稳定性的排序

基于非比较方式的排序，如：有一个数组arr[N],数据里面包含0~60的数值，对这个数组进行排序：  
1. 先定义一个tmp[61]的数组，数组主要用来装`数频（0-60范围内每个数字出现的次数）`
2. 遍历arr数组，当出现某个数字为x时，把tmp数组中对应下标的数值+1
3. 遍历完成后，遍历tmp数组进行重构arr数组

桶：一个数据状况出现的词频，一个桶具体实现可以是一个数组中的某个位置，也可以是一个双向链表，可以是一个队列，也可以是一个堆
把一个值放到对应的桶里面，然后把值从低位置的桶到高位置的桶依次倒出来  
`桶排序`是一个具体的概念，里面包含`计数排序`实现,`基数排序`实现

基数排序，+-20亿内数据基于基数排序，的准备十个桶，按照个位十位百位等位置的数据排序

#### 16.给定一个数组arr.length = N，求如果排序后，相邻两个数的最大差值，要求时间复杂度O(N),且要求不能用非基于比较的排序
> 鸽笼法则
> 设计空桶是为了否定，最大差值不来至一个桶内部
1. 数组长度为N，设计N+1个桶
2. 遍历一遍arr，最小值放到0号桶里面最大值放到N号桶里面，然后平均分配每个数放到自己对应的桶里面
3. 放置每个数字的时候，只记录对应桶里面最大值和最小值，以及boolean只true/false,是否为空
4. 遍历每个非空桶，全局变量记录后一个桶最小值比前一个桶最大值的最大差值，答案就来之其中

### 小结
* 每次遍历可以通过外部变量保存，遍历到当前的最大值，最小值，lastMaxValue，lastMinValue
* 找桶计算下标变换公式,int bucket = (arr[cur] - arrMin) * arr.length / (arrMax - arrMin)

### 用数组结构实现大小固定的队列和栈
#### 栈
> 栈：一种特殊的线性表，其实只允许在固定的一端进行插入或删除操作。
>进行数据插入和删除的一端称为栈顶，另一端称为栈底。不含任何元素的栈称为空栈，
>栈又称为 后进先出的线性表。  
>特性栈：后进先出（LIFO）特殊线性表  
 栈功能：将数据从一种序列改变为另一种序列  
>基本操作：push() pop() peek() empty()

#### 队列
> 队列是一种特殊的线性表，特殊之处在于它只允许在表的前端（front）进行删除操作，
>而在表的后端（rear）进行插入操作，和栈一样，队列是一种操作受限制的线性表。
>进行插入操作的端称为队尾，进行删除操作的端称为队头。  
>特性：先进先出(FIFO)  
>顺序队列中的溢出现象：  
> 1. "下溢"现象：当队列为空时，做出队运算产生的溢出现象。“下溢”是正常现象，常用作程序控制转移的条件。  
> 2. "真上溢"现象：当队列满时，做进栈运算产生空间溢出的现象。“真上溢”是一种出错状态，应设法避免。  
> 3. "假上溢"现象：由于入队和出队操作中，头尾指针只增加不减小，致使被删元素的空间永远无法重新利用。
 当队列中实际的元素个数远远小于向量空间的规模时，也可能由于尾指针已超越向量空间的上界而不能做入队操作。
 该现象称为"假上溢"现象。

  
