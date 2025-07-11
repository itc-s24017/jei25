public class D51Ensyu {
    public static void main(String[] args) {
        D51Student student = new D51Student(args[0], args[1]);

        System.out.println("学生番号: " + student.getStudentID());
        System.out.println("氏名: " + student.getName());
    }
}

class D51Student {
    private String studentID;
    private String name;

    public D51Student(String studentID, String name){ //コンストラクタ
        this.studentID = studentID;
        this.name = name;
    }

    //ゲッターメソッド
    public String getStudentID(){ return studentID; }
    public String getName(){ return name; }
}