import java.util.*;

class Task {
    int start;
    int end;
    Task (int start, int end) {
        this.start =start;
        this.end =end;
    }

    public String toString() {
        return "(" + Integer.toString(start) + ", " +Integer.toString(end) +")";
    }
}

public class Main {
    public static void main(String[] args) {
        List<Task> taskList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            taskList.add(new Task(sc.nextInt(), sc.nextInt()));
        }
        taskList.sort((x, y) -> (x.start - y.start));
        taskList.sort((x, y) -> (x.end - y.end));
        Task prev = taskList.get(0);
        int count = 1;
        for (int i = 1 ; i < n ; i++) {
            Task task = taskList.get(i);
            if (prev.end <= task.start) {
                prev = task;
                count++;
            }
        }
        System.out.println(count);
    }
}