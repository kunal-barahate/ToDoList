import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String title;
    boolean isCompleted;

    Task(String title) {
        this.title = title;
        this.isCompleted = false;
    }

    void markCompleted() {
        isCompleted = true;
    }

    @Override
    public String toString() {
        return (isCompleted ? "[✓] " : "[ ] ") + title;
    }
}

public class ToDoListApp {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== TO-DO LIST MENU =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> completeTask();
                case 4 -> deleteTask();
                case 5 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);
    }

    private static void addTask() {
        System.out.print("Enter task title: ");
        String title = sc.nextLine();
        tasks.add(new Task(title));
        System.out.println("Task added successfully!");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available!");
            return;
        }
        System.out.println("\nYour Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private static void completeTask() {
        viewTasks();
        if (tasks.isEmpty()) return;
        System.out.print("Enter task number to mark completed: ");
        int num = sc.nextInt();
        if (num > 0 && num <= tasks.size()) {
            tasks.get(num - 1).markCompleted();
            System.out.println("Task marked as completed!");
        } else {
            System.out.println("Invalid task number!");
        }
    }

    private static void deleteTask() {
        viewTasks();
        if (tasks.isEmpty()) return;
        System.out.print("Enter task number to delete: ");
        int num = sc.nextInt();
        if (num > 0 && num <= tasks.size()) {
            tasks.remove(num - 1);
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println("Invalid task number!");
        }
    }
}
