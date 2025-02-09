import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class Main {
    public static void main(String[] args) {
        TodoList todoList = new TodoList();

        while (true) {
            System.out.println("Введите текст: ");
            String text = new Scanner(System.in).nextLine();
            todoList.text(text);
        }
    }
}
