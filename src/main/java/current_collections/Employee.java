package current_collections;

public class Employee {

    private int id;
    private String department;
    private boolean deleted;

    public Employee(int id, String department, boolean deleted) {
        this.id = id;
        this.department = department;
        this.deleted = deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
