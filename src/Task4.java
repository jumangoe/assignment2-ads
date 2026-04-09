import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Task4 {

    static void AddBill(Queue<String> billQueue, Scanner input) {
        System.out.print("Enter bill name: ");
        String bill=input.nextLine();

        billQueue.add(bill);
        System.out.println("Added: "+bill);
    }

    static void ProcessBill(Queue<String> billQueue) {
        if(billQueue.isEmpty()) {
            System.out.println("No bills to process");
            return;
        }

        String bill=billQueue.poll();
        System.out.println("Processing: "+bill);
    }

    static void ShowQueue(Queue<String> billQueue) {
        if(billQueue.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("Remaining bills:");
        for(String bill:billQueue) {
            System.out.println(bill);
        }
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        Queue<String> billQueue=new LinkedList<String>();

        while(true) {
            System.out.println("\n1. Add bill");
            System.out.println("2. Process next bill");
            System.out.println("3. Display queue");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice=input.nextInt();
            input.nextLine();

            if(choice==1) {
                AddBill(billQueue, input);
            }
            else if(choice==2) {
                ProcessBill(billQueue);
            }
            else if(choice==3) {
                ShowQueue(billQueue);
            }
            else if(choice==4) {
                System.out.println("Program finished");
                break;
            }
            else {
                System.out.println("Invalid option");
            }
        }

        input.close();
    }
}