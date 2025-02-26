public class BubbleSort {
    /*
    * 冒泡排序
    * 54321
    * 0和1比较，大的放后边
    * 1和2比较，大的放后边
    * 。。。
    * n-2和n-1比较，大的放后边
    * 下次是
    * 0和1~n-3和n-2
    * 这样一趟，能确定最大的值，我们需要进行n-1次
    * */
    public static void main(String[] args) {
        int[] array = {6,7,9,4,3,7,5,1,0,2};
        printArray(array);
        System.out.println();
        bubbleSort(array);
        printArray(array);
    }

    public static void bubbleSort(int[] array){
        if(array == null || array.length <2){
            return;
        }
        int N = array.length;
        for (int i = 0; i < N; i++) {//一共需要确定n-1个数的位置，一次确定一个最大值
            for (int j = 0; j < N-i-1; j++) {//每次确定的位置都是n-1,n-2,n-3,...N-i-1
                if (array[j] > array[j+1]){
                    swap(array,j,j+1);
                }
            }
        }
    }
    public static void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
