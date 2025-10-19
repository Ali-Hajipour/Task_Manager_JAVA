import java.util.Scanner;
import java.util.ArrayList;


public class taskManager {

    static ArrayList<String> tasks = new ArrayList<>();
    static ArrayList<Boolean> done = new ArrayList<>();

    static int  taskCount = 0;



    public static void listTasks () {
        for (int i = 0 ; i < tasks.size() ; i++ ) {
            System.out.println(i + ": " + tasks.get(i) + " | Done = " + done.get(i));

        }
    }



    public static void addTask(String task) {
        tasks.add(task);
        done.add(false);
    }


    public static void markDone (int index) {
        if (index >= 0 && index < taskCount){
            done.set(index, true);
            System.out.println("Task Seccussflly marked done !!" ) ;
        }else  {
            System.out.println("Tasks hasnt marked , sorry .");
        }
    }

    public static  void removeTask (int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            done.remove(index);
            System.out.println("Task Seccussflly removed !!" ) ;
        }else   {
            System.out.println("you have entered wrong index , sorry");
        }
    }


    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(("""
               === CLI Task Manager ===
               1. Add Task
               2. List Tasks
               3. Remove Task
               4. Mark task done
               5. Exit
               Choose one of the options :
               """
                    ));

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter your new task : ");
                    String task = scanner.nextLine();
                    addTask(task);
                    break;

                case 2:
                    listTasks();
                    break;
                case 3 :
                    listTasks();
                    System.out.println("select the index you want to remove : " ) ;
                    int removeIndex = scanner.nextInt() -1 ;
                    scanner.nextLine();
                    removeTask(removeIndex);
                    break;
                case 4:
                   listTasks();
                    System.out.println("select the index you want to mark : " ) ;

                    int doneIndex = scanner.nextInt() -1 ;
                    markDone(doneIndex);
                    break;
                    case 5 :
                        System.exit(0);
                default:
                    System.out.println("[!] Invalid choice. Try again.");
            }
        }
    }
}
