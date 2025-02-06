// There is a task management system that allows users to manage their tasks, each associated with a priority. The system should efficiently handle adding, modifying, executing, and removing tasks.

// Implement the TaskManager class:

//     TaskManager(vector<vector<int>>& tasks) initializes the task manager with a list of user-task-priority triples. Each element in the input list is of the form [userId, taskId, priority], which adds a task to the specified user with the given priority.

//     void add(int userId, int taskId, int priority) adds a task with the specified taskId and priority to the user with userId. It is guaranteed that taskId does not exist in the system.

//     void edit(int taskId, int newPriority) updates the priority of the existing taskId to newPriority. It is guaranteed that taskId exists in the system.

//     void rmv(int taskId) removes the task identified by taskId from the system. It is guaranteed that taskId exists in the system.

//     int execTop() executes the task with the highest priority across all users. If there are multiple tasks with the same highest priority, execute the one with the highest taskId. After executing, the taskId is removed from the system. Return the userId associated with the executed task. If no tasks are available, return -1.

// Note that a user may be assigned multiple tasks.

import java.util.*;
class Feb6_2025 {

    private TreeSet<int[]> tasks;
    private Map<Integer, int[]> taskMap;

    public Feb6_2025(List<List<Integer>> tasks) {
        this.tasks = new TreeSet<>((a,b) -> b[2] == a[2] ? b[1] - a[1] : b[2] - a[2]);
        this.taskMap = new HashMap<>();
        for(List<Integer> task: tasks) {
            int[] t = new int[]{task.get(0), task.get(1), task.get(2)};
            this.tasks.add(t);
            this.taskMap.put(task.get(1), t);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        int[] task = new int[]{userId, taskId, priority};
        this.tasks.add(task);
        this.taskMap.put(taskId, task);
    }
    
    public void edit(int taskId, int newPriority) {
        int[] task = taskMap.get(taskId);
        tasks.remove(task);
        taskMap.remove(taskId);
        int[] newTask = new int[]{task[0], task[1], newPriority};
        tasks.add(newTask);
        taskMap.put(taskId, newTask);
    }
    
    public void rmv(int taskId) {
        this.tasks.remove(this.taskMap.get(taskId));
        this.taskMap.remove(taskId);
    }
    
    public int execTop() {
        if(this.tasks.isEmpty()) return -1;
        int[] task = this.tasks.pollFirst();
        this.taskMap.remove(task[1]);
        return task[0];
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