import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class RepeatedCharacter {


    public int solution(int[] A) {
        // write your code in Java SE 8
//        int num = Arrays.asList(A).stream().distinct().collect(Collectors.toList()).size();
//
//        Arrays.asList(A).stream().distinct().forEach(i -> System.out.println(i));

        Arrays.stream(A).distinct().count();

        return (int)Arrays.stream(A).distinct().count();
    }


    public String findRepeatedCharacter(String word){

        String[] charArray = word.split("");

        List<String> charArrayList = new LinkedList<String>(Arrays.asList(charArray));

        int num = Arrays.asList(charArray).stream().distinct().collect(Collectors.toList()).size();

        String charTemp;
        for(int i= 0; i< charArrayList.size(); i++){
            charTemp = charArrayList.get(i);
            charArrayList.remove(i);
            if (charArrayList.contains(charTemp)){
                return(charTemp);
            }
        }
        return ("-1");
    }


    public static void main (String args []){

        RepeatedCharacter repeatedCharacter = new RepeatedCharacter();
//        System.out.println(repeatedCharacter.findRepeatedCharacter("hello"));
//        System.out.println(repeatedCharacter.findRepeatedCharacter("fg"));
//        System.out.println(repeatedCharacter.findRepeatedCharacter("geeksforgeeks"));

        System.out.println(repeatedCharacter.solution(new int[] {2, 1, 1, 2, 3, 1}));

    }
}
