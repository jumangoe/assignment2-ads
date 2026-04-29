import java.util.Random;

public class Sorter {

    public void BasicSort(int[] arr){
        // Insertion Sort
        for(int i=1;i<arr.length;i++){
            int key=arr[i];
            int j=i-1;

            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=key;
        }
    }

    public void AdvancedSort(int[] arr){
        // Merge Sort
        MergeSort(arr,0,arr.length-1);
    }

    private void MergeSort(int[] arr,int left,int right){
        if(left<right){
            int mid=(left+right)/2;

            MergeSort(arr,left,mid);
            MergeSort(arr,mid+1,right);

            Merge(arr,left,mid,right);
        }
    }

    private void Merge(int[] arr,int left,int mid,int right){
        int n1=mid-left+1;
        int n2=right-mid;

        int[] leftArr=new int[n1];
        int[] rightArr=new int[n2];

        for(int i=0;i<n1;i++){
            leftArr[i]=arr[left+i];
        }
        for(int j=0;j<n2;j++){
            rightArr[j]=arr[mid+1+j];
        }

        int i=0,j=0,k=left;

        while(i<n1 && j<n2){
            if(leftArr[i]<=rightArr[j]){
                arr[k]=leftArr[i];
                i++;
            }else{
                arr[k]=rightArr[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            arr[k]=leftArr[i];
            i++;
            k++;
        }

        while(j<n2){
            arr[k]=rightArr[j];
            j++;
            k++;
        }
    }

    public void PrintArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public int[] GenerateRandomArray(int size){
        Random random=new Random();
        int[] arr=new int[size];

        for(int i=0;i<size;i++){
            arr[i]=random.nextInt(1000);
        }

        return arr;
    }
}