import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Sorting {

    private int[] swap(int[] A, int first, int second){

        return A;
    }


    private static int[] sort(int[] A)
    {
        int temp,i;

        for (i =0; i < A.length-1; i++){
            for(int j = 0 ; j < A.length-1-i;j++ ) {
                if (A[j] > A[j + 1]) {
                    temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }

        return A;

    }



    public static void main (String args[]){
        Integer[] A ={2, 3, 5, 6, 1};

        System.out.println(Arrays.toString(A));
        //System.out.println(Arrays.toString(sort(A)));


        Ints.asList().stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()).toString();


    }
}
