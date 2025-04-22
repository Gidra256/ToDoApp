
import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String description;
    boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }
}

public class ToDoListApp {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("To-Do List App");
            System.out.println("1. Add task");
            System.out.println("2. View tasks");
            System.out.println("3. Mark task as completed");
            System.out.println("4. Delete task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    tasks.add(new Task(description));
                    System.out.println("Task added successfully!");
                    break;
                case 2:
                    System.out.println("Tasks:");
                    for (int i = 0; i < tasks.size(); i++) {
                        Task task = tasks.get(i);
                        System.out.println((i + 1) + ". " + task.description + (task.isCompleted ? " (Completed)" : ""));
                    }
                    break;
                case 3:
                    System.out.print("Enter task number to mark as completed: ");
                    int taskNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                    if (taskNumber > 0 && taskNumber <= tasks.size()) {
                        tasks.get(taskNumber - 1).isCompleted = true;
                        System.out.println("Task marked as completed!");
                    } else {
                        System.out.println("Invalid task number!");
                    }
                    break;
                case 4:
                    System.out.print("Enter task number to delete: ");
                    taskNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                    if (taskNumber > 0 && taskNumber <= tasks.size()) {
                        tasks.remove(taskNumber - 1);
                        System.out.println("Task deleted successfully!");
                    } else {
                        System.out.println("Invalid task number!");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}
