public class D53Q25kadai {
    public static void main(String[] args) {
        String s1 = "ABC";
        String s2 = "ABC";
        boolean b1 = s1 == s2;         // 参照が同じ → true
        boolean b2 = s1.equals(s2);    // 内容が同じ → true
        System.out.println(b1 + " " + b2);
    }
}
