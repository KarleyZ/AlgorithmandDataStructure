public class SelectionSort {
    /*
    * 选择排序
    * 0~n-1，选择最小的数，然后将其放到0位
    * 1~n-1，选择最小的数，然后将其放到1位
    * 2~n-1，选择最小的数，然后将其放到2位
    * */
    public static void main(String[] args) {
        int[] array = {6,7,3,6,9,2,1};
        printArray(array);
        System.out.println();
        selectSort(array);
        printArray(array);
    }
    public static void selectSort(int[] array){
        if(array == null || array.length <2){//boundary judgment
            return;
        }
        int N= array.length;
        for (int i = 0; i < N; i++) {
            int minValueIndex = i;//Save the minValue index
            for (int j = i+1; j <N ; j++) {
                minValueIndex = array[j] < array[minValueIndex] ? j : minValueIndex;
            }
            swap(array,minValueIndex,i);//swap minValue and arrary[i]
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
