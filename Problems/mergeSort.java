package Practice;
import java.util.*;
public class mergeSort{
    public static void main(String args[]){
        // Scanner sc=new Scanner(System.in);
        // int n=sc.nextInt();
        // int arr[]=new int[n];
        int arr[]={4,3,5,10,9,2,8,12,11,20,14,27,23,25};
        System.out.println("Before: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("After: " + Arrays.toString(arr));
    }
    public static void sort(int arr[]){
        int len=arr.length;
        System.out.println(Arrays.toString(arr));
        if(len<2){
            return;
        }
        int midIndex=len/2;
        int leftArr[]=new int[midIndex];
        int rightArr[]=new int[len-midIndex];

        for(int i=0;i<midIndex;i++){
            leftArr[i]=arr[i];
        }
        for(int i=midIndex;i<len;i++){
            rightArr[i-midIndex]=arr[i];
        }
        sort(leftArr);
        sort(rightArr);
        merge(arr,leftArr,rightArr);
    }
    public static void merge(int arr[],int leftArr[],int rightArr[]){
        int lSize=leftArr.length;
        int rSize=rightArr.length;
        int i=0,j=0,k=0;
        while(i<lSize && j<rSize){
            if(leftArr[i]<=rightArr[j]){
                arr[k]=leftArr[i];
                i++;
            }
            else{
                arr[k]=rightArr[j];
                j++;
            }
            k++;
        }
        while(i<lSize){
            arr[k]=leftArr[i];
            i++;
            k++;
        }
        while(j<rSize){
            arr[k]=rightArr[j];
            j++;
            k++;
        }
        System.out.println("merged: "+ Arrays.toString(arr));
        
    }
}