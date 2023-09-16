package data;

public class Request {
    private int id_student;
    private float scholarship;
    private float f_scholarship;
    private String status;
    public Request()
    {

    }
    public Request(int id_student,  String status) {
        this.id_student = id_student;
        this.scholarship = scholarship;
        this.f_scholarship = f_scholarship;
        this.status = status;
    }

    public Request(int id_student, float scholarship, float f_scholarship, String status) {
        this.id_student = id_student;
        this.scholarship = scholarship;
        this.f_scholarship = f_scholarship;
        this.status = status;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public float getScholarship() {
        return scholarship;
    }

    public void setScholarship(float scholarship) {
        this.scholarship = scholarship;
    }

    public float getF_scholarship() {
        return f_scholarship;
    }

    public void setF_scholarship(float f_scholarship) {
        this.f_scholarship = f_scholarship;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
