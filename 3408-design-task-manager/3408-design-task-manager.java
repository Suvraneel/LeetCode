public class Task {
    int userId;
    int taskId;
    int priority;

    public Task(int userId, int taskId, int priority) {
        this.userId = userId;
        this.taskId = taskId;
        this.priority = priority;
    }

}

class TaskManager {
    HashMap<Integer, Task> taskMap;
    TreeSet<Task> taskList;

    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        taskList = new TreeSet<>(
                (a, b) -> a.priority == b.priority ? b.taskId - a.taskId : b.priority - a.priority);

        for (List<Integer> t : tasks) {
            Task newTask = new Task(t.get(0), t.get(1), t.get(2));
            taskList.add(newTask);
            taskMap.put(t.get(1), newTask);
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task newTask = new Task(userId, taskId, priority);
        taskList.add(newTask);
        taskMap.put(taskId, newTask);
    }

    public void edit(int taskId, int newPriority) {
        Task oldTask = taskMap.get(taskId);
        taskList.remove(oldTask);
        oldTask.priority = newPriority;
        taskList.add(oldTask);
        taskMap.put(taskId, oldTask);
    }

    public void rmv(int taskId) {
        Task oldTask = taskMap.get(taskId);
        taskList.remove(oldTask);
        taskMap.remove(taskId);
    }

    public int execTop() {
        if (taskList.isEmpty())
            return -1;
        Task topTask = taskList.first();
        taskList.remove(topTask);
        taskMap.remove(topTask.taskId);
        return topTask.userId;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */