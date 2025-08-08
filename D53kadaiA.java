public class D53kadaiA {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 0; i < args.length; i++) {
            try {
                int num = Integer.parseInt(args[i]);
                sum += num;
            } catch (NumberFormatException e) {
                System.out.println(args[i]);
                return;
            }
        }

        System.out.println(sum);
    }
}
