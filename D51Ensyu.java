public class D51Ensyu {
    public static void main(String[] args) {
        D51Student student = new D51Student(args[0], args[1]);

        System.out.println("学生番号: " + student.getStudentID());
        System.out.println("名前: " + student.getName());
    }
}

class D51Student {
    private String studentID;
    private String name;

    public D51Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }
}
