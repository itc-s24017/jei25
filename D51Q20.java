public class D51Q20 {
    public static void main(String[] args) {
        boolean flg = true;
        int n = 6;
        char c = (flg = n > 8) ? 'Y' : 'N';
        System.out.println(c);
    }
}
