public class BinarySearch {
    /*public static void main(String[] args) {
        *//*
        * 二分查找法：在有序的数组中找某个数
        * 0 1 2 3 4 5 6 7   8
        * 1 3 5 6 8 7 9 12 23
        * *//*
        int[] array = {1,3,5,6,8,7,9,12,23};
        search(array,1);

        System.out.println("===================");

        //二分查找>= num最左边的数的位置（下标)
        int[] array2 = {1,2,2,2,4,5,6,6,6,7,8,9,11};
        System.out.println(searchLeft(array2,7));
        System.out.println("===========");
        System.out.println(searchRight(array2,2));

    }*/

    //为了不影响，这个专门测区域内最小
    public static void main(String[] args) {
        int maxLength = 10;
        int maxValue = 200;
        int testTime = 10000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr = randomArray(maxLength,maxValue);
            int ans = oneInternalMin(arr);
            if(!(check(arr,ans))){
                printArr(arr);
                System.out.println(ans);
                break;
            }
        }
        /*int[] arr = {196,28,125,42,97,164};
        int ans = oneInternalMin(arr);
        System.out.println(check(arr, ans));
        System.out.println(ans);*/
        System.out.println("测试结束");
    }

    //二分查找num
    public static Boolean search(int[] array,int Num){
        if(array == null || array.length == 0){
            return false;
        }
        int N = array.length;
        int leftIndex = 0;
        int rightIndex = N -1; //定义左右指针来记录二分查找的范围
        while(leftIndex <= rightIndex){
            int MidIndex = (leftIndex + rightIndex)/2; //计算中间的位置
            if(Num > array[MidIndex]){
                leftIndex = MidIndex + 1;
            }else if (Num < array[MidIndex]){
                rightIndex = MidIndex - 1;
            }else {
                System.out.println("找到这个数了：" +array[MidIndex]);
                return true;
            }
        }
        System.out.println("没有找到这个数");
        return false;
    }

    //有序数组查找>=num最左边的位置
    //实际这种二分将数组完全二分到结束，因为我们要找最左的数据
    public static int searchLeft(int[] array, int num){
        if(array == null || array.length == 0){
            return -1;
        }
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        int resultIndex = -1;//初始结果位置是-1
        while (leftIndex <= rightIndex){
            int midIndex = (leftIndex + rightIndex)/2;
            if(array[midIndex] >= num){
                resultIndex = midIndex;//至少找到了一个位置> = num
                rightIndex = midIndex - 1;//右边砍掉一半，继续找最左的位置
            }else {
                leftIndex = midIndex + 1;//左边砍掉
            }
        }
        return resultIndex;
    }
    //有序数组查找<= num最右边的位置
    public static int searchRight(int[] array, int num){
        if(array == null || array.length == 0){
            return -1;
        }
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        int resultIndex = -1;
        while (leftIndex <= rightIndex){
            int midIndex = (leftIndex + rightIndex) / 2;
            if(array[midIndex] <= num){
                resultIndex = midIndex;
                leftIndex = midIndex + 1;
            }else {
                rightIndex = midIndex - 1;
            }
        }
        return resultIndex;
    }

    /*
    * 局部最小值问题：无序数组，任意两个相邻的数不相等。
    * 定义局部最小概念：
    * 0位置的数<1位置的数，称为0位置局部最小
    * n-2位置的数>n-1位置上的数，称为n-1位置局部最小
    * i位置上的数比i-1和i+1位置上的数都小，称为i位置局部最小
    * 请返回其中一个局部最小位置
    * */
    public static int oneInternalMin(int[] array){
        if(array == null || array.length == 0){
            return -1;
        }
        int n = array.length;
        if(n == 1){
            return 0;
        }
        if (array[0] < array[1]){
            return 0;
        }
        if (array[n-2] > array[n-1]) {
            return n - 1;
        }
        int leftIndex = 0;
        int rightIndex = n-1;
        //二分一定是三个以及三个以上的情况
        while (leftIndex < rightIndex -1){
            int midIndex = (leftIndex + rightIndex) /2;
            if(array[midIndex] <= array[midIndex-1] && array[midIndex] <= array[midIndex + 1]){
                return midIndex;
            }else{
                //左 < 我 && 我 <右
                //左 < 我 && 我 >右
                //左 > 我 && 我 >右
                if (array[midIndex -1] < array[midIndex]) {
                    rightIndex = midIndex -1;//只要我比左大，我都可以舍弃右边去左边找
                }else {
                    leftIndex = midIndex + 1;//到这里，只能是我比右大，因此我必须舍弃左边，去右边找
                }
            }
        }
        //假设1，2,3走完上边的while之后,我就舍弃3，只看1,2。这里谁小就是结果
        return array[leftIndex] < array[rightIndex] ? leftIndex : rightIndex;//我不理解
    }

    //对数器，随机生成数组,保证相邻两个数不相同
    public static int[] randomArray(int maxLength, int maxValue){
        int len = (int)(Math.random() * maxLength);
        int[] arr = new int[len];
        if(len > 0){
            arr[0] = (int)(Math.random() * maxValue);
            for (int i = 1; i < len; i++) {
                do {
                    arr[i] = (int)(Math.random() * maxValue);
                }while (arr[i] == arr[i-1]);//相邻两个数相同就重做
            }
        }
        return arr;
    }
    //局部最小的验证方法
    public static boolean check(int[] arr, int resultIndex){
        if(arr.length == 0){
            return resultIndex == -1;
        }
        int leftIndex = resultIndex -1;
        int rightIndex = resultIndex +1;
        //如果左边的索引没越界，那么比较中间和左边那个大，如果左边越界，默认左边大
        boolean leftBigger = leftIndex >=0 ? arr[leftIndex] > arr[resultIndex] : true;
        //同上边左边的判断
        boolean rightBigger = rightIndex < arr.length ? arr[rightIndex] > arr[resultIndex] :true;
        return leftBigger && rightBigger;//同时左右都比结果大，那么结果就是正确的局部最小
    }

    //打印数组
    public static void printArr(int[] arr){
        for (int num : arr) {
            System.out.print(num + ",");
        }
        System.out.println();
    }
}
