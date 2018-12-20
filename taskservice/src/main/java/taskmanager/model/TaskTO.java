package taskmanager.model;

public class TaskTO {

    private String taskName;

    private Long adminUserId;

    public TaskTO(){

    }

    public TaskTO(String taskName , Long adminUserId) {
        this.taskName = taskName;
        this.adminUserId = adminUserId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Long getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(Long adminUserId) {
        this.adminUserId = adminUserId;
    }
}
