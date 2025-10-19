import java.util.Scanner;

public class taskManager {
    static String[] tasks = new String[10];
    static boolean[] done = new boolean[10];
    static int  taskCount = 0;

    public static void taskList () {
        if (taskCount == 0 ) {
            System.out.println("No task found yet .");
            return;
        }

        System.out.println("\n ===Tasks Lists ===");

        for (int i = 0; i < taskCount ; i++ ) {
            String status = done[i] ? "It's done" : "its not done";
            System.out.println((i + 1) +". " + "Task : "+ tasks[i]+ ", Status : " + status);
        }
    }


    public static void addTask (String task) {
        if (taskCount < tasks.length) {
            tasks[taskCount] = task;
            done [taskCount] = false;
            taskCount++;
            System.out.println("Task Seccussflly added !!" ) ;
        } else {
            System.out.println("Tasks hasnt added , sorry .");
        }
    }


    public static void markDone (int index) {
        if (index >= 0 && index < taskCount){
            done[index] = true;
            System.out.println("Task Seccussflly marked done !!" ) ;
        }else  {
            System.out.println("Tasks hasnt marked , sorry .");
        }
    }

    public static  void removeTask (int index) {
        if (index >= 0 && index < taskCount){
            for (int i =index ; i< taskCount -1 ; i++ ) {
                tasks[i] = tasks[i+1];
                done [i] = done[i+1];

            }
            taskCount--;
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
                    taskList();
                    break;
                case 3 :
                    taskList();
                    System.out.println("select the index you want to remove : " ) ;
                    int removeIndex = scanner.nextInt() -1 ;
                    scanner.nextLine();
                    removeTask(removeIndex);
                    break;
                case 4:
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
