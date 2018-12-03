import java.util.Arrays;

public class SortingAlgorithm {


    public static int[] mergeSort(int[] array){
        if (array.length ==1)
            return array;



        return null;
    }
    public static void bubbleSort(int[] array){}
    public static void quickSort(int[] array){}
    public static void heapSort(int[] array){}
    public static void countingSort(int[] array){}
    public static void insertionSort(int[] array){}




    public static void main (String [] args){
        int [] intArray= {2,5,7,3,4,4,8,1,6};

        System.out.println(Arrays.toString(intArray));
        System.out.println(Arrays.toString(mergeSort(intArray)));

    }
}
