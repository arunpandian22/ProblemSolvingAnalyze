package javaProblemAnalyze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Contigously_Increasing_Numbers {
    public static void main(String args[]) {
            System.out.println(Arrays.toString(solve(0,300)));
    }
    public static int[] solve(int start, int end) {
        ArrayList<Integer> a=new ArrayList<>();
        for(int i=1;i<=9;i++){
            int digit=i;
            int next=i+1;

            while(next<=10 && digit<start){
                digit=digit*10+next;
                next++;
            }

            while(next<=10 && digit<=end){
                a.add(digit);
                digit=digit*10+next;
                next++;
            }

        }
        Collections.sort(a);
        int arr[]=new int[a.size()];
        for(int j=0;j<a.size();j++){
            arr[j]=a.get(j);
        }
        return arr;
    }
}
