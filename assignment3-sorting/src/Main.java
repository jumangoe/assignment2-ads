import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scanner=new Scanner(System.in);

        Sorter sorter=new Sorter();
        Searcher searcher=new Searcher();
        Experiment experiment=new Experiment();

        System.out.println("Enter array size:");
        int size=scanner.nextInt();

        int[] arr=sorter.GenerateRandomArray(size);

        System.out.println("Original array:");
        sorter.PrintArray(arr);

        sorter.BasicSort(arr);
        System.out.println("After Basic Sort:");
        sorter.PrintArray(arr);

        System.out.println("Enter number to search:");
        int target=scanner.nextInt();

        int index=searcher.Search(arr,target);

        if(index!=-1){
            System.out.println("Found at index: "+index);
        }else{
            System.out.println("Not found");
        }

        System.out.println("\nRunning experiments...");
        experiment.RunAllExperiments();
    }
}