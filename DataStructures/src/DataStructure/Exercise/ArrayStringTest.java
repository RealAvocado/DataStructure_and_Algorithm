package DataStructure.Exercise;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayStringTest {

    public static ArrayList<String> makeCanon(ArrayList<String> arrayList){

        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).equals("Well hello there!") && i == size-1){
                arrayList.add("");
                arrayList.set(i+1,"General Kenobi!");
                size++;
            }
            if (arrayList.get(i).equals("Well hello there!") && i < size-1 && !arrayList.get(i+1).equals("General Kenobi!")){
                arrayList.add(i+1,"General Kenobi!");
                size++;
            }
            if (arrayList.get(i).equals("General Kenobi!") && i == 0){
                arrayList.add(i,"Well hello there!");
                size++;
                i++;
            }
            if (arrayList.get(i).equals("General Kenobi!") && i > 0 && !arrayList.get(i-1).equals("Well hello there!")){
                arrayList.add(i,"Well hello there!");
                size++;
                i++;
            }
        }
        return arrayList;
    }


    public static void main(String[] args) {
        String hello = "Well hello there!";
        String kenobi = "General Kenobi!";
        ArrayList<String> input = new ArrayList<>(Arrays.asList(kenobi,"well",kenobi,"hi",hello));
        System.out.println(makeCanon(input));


//        int num = 5;
//        for (int i = 0; i < num; i++) {
//            if (i==2){
//                num++;
//            }
//            System.out.println(i);
//        }
    }
}
