public class InsertionSort {
    /*
    *
    * 插入排序
    * 0位置上有序
    * 0~1位置上有序
    * 0~2位置上有序
    * 。。。
    * 0~n-1位置上有序
    * */
    public static void main(String[] args) {
        int[] array = {6,7,9,4,3,7,5,1,0,2};
        printArray(array);
        System.out.println();
        insertSort(array);
        printArray(array);
        System.out.println("++++++++++++++++++++");
        insertSort2(array);
        printArray(array);
    }
    public static void insertSort(int[] array){
        if (array==null || array.length<2){
            return;
        }
        int N= array.length;
        for (int i = 1; i < N; i++) {
            int j= i;
            while (j>0){
                if(array[j] < array[j-1]){
                    swap(array,j,j-1);
                    j--;
                }else{
                    break;
                }
            }
        }
    }

    //优化后的插入排序
    public static void insertSort2(int[] array){
        if(array == null ||array.length<2){
            return;
        }
        int N = array.length;
        for (int end = 1; end < N; end++) {
            for (int pre = end -1; pre >=0&&array[pre]>array[pre+1] ; pre--) {
                swap(array,pre,pre+1);
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
