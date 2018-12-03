import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int [] A){
        mergeSort(A, new int[A.length], 0, A.length -1);

    }

    public static void mergeSort(int []  A, int [] temp, int start, int end){
        int leftStart=start;
        int rightEnd=end;
        if (leftStart >= rightEnd) {
            return;
        }

        int midpoint =  (leftStart + rightEnd)/2;

        //mergeSort left
        mergeSort(A,temp ,leftStart, midpoint);

        //mergeSort right
        mergeSort(A,temp,midpoint+1,rightEnd);

        mergeHalves(A,temp,leftStart,rightEnd);


    }

    public static void mergeHalves(int[] A, int[] temp, int leftStart, int rightEnd){
        int leftEnd = (leftStart+rightEnd)/2;
        int rightStart = leftEnd +1;

        int leftPointer=leftStart;
        int rightPointer=rightStart;
        int index=leftStart;

        while((leftPointer <=leftEnd)&&(rightPointer <=rightEnd)){

            if(A[leftPointer] < A[rightPointer] ){
                temp[index]=A[leftPointer];
                leftPointer ++;
            }
            else{
                temp[index]=A[rightPointer];
                rightPointer++;
            }
            index++;
            //System.out.println(Arrays.toString(temp));
        }

        System.arraycopy(A,leftPointer,temp,leftEnd,leftEnd - leftPointer +1);
        System.arraycopy(A,rightPointer,temp,rightEnd,rightEnd - rightPointer +1);
        System.arraycopy(temp, leftStart, A,leftStart,rightEnd-leftStart +1);

        //System.out.println(Arrays.toString(A));
    }

    public static void main (String [] args){
        int [] intArray= {2,5,7,3,4,4,8,1,6};
        System.out.println(Arrays.toString(intArray));
        mergeSort(intArray);
    }


}
