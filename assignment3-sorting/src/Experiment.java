public class Experiment {

    private Sorter sorter;
    private Searcher searcher;

    public Experiment(){
        sorter=new Sorter();
        searcher=new Searcher();
    }

    public long MeasureSortTime(int[] arr,String type){
        int[] copy=arr.clone();

        long start=System.nanoTime();

        if(type.equals("basic")){
            sorter.BasicSort(copy);
        }else{
            sorter.AdvancedSort(copy);
        }

        long end=System.nanoTime();

        return end-start;
    }

    public long MeasureSearchTime(int[] arr,int target){
        long start=System.nanoTime();

        searcher.Search(arr,target);

        long end=System.nanoTime();

        return end-start;
    }

    public void RunAllExperiments(){
        int[] sizes={10,100,1000};

        for(int i=0;i<sizes.length;i++){
            int size=sizes[i];

            int[] arr=sorter.GenerateRandomArray(size);

            long basicTime=MeasureSortTime(arr,"basic");
            long advancedTime=MeasureSortTime(arr,"advanced");

            sorter.AdvancedSort(arr); // сортируем перед бинарным поиском

            long searchTime=MeasureSearchTime(arr,arr[size/2]);

            System.out.println("Size: "+size);
            System.out.println("Basic Sort Time: "+basicTime);
            System.out.println("Advanced Sort Time: "+advancedTime);
            System.out.println("Search Time: "+searchTime);
            System.out.println("----------------------");
        }
    }
}