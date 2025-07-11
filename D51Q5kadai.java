public class D51Q5kadai {
    public static void main(String[] args) {
        double usage = Double.parseDouble(args[0]);

        int baseFee = 780; // 680 + 100

        double cost = 0.0;

        if (usage <= 20.0) {
            cost = usage * 24;
        } else if (usage <= 50.0) {
            cost = (20 * 24) + (usage - 20) * 26;
        } else {
            cost = (20 * 24) + (30 * 26) + (usage - 50) * 28;
        }

        int total = (int)(baseFee + cost);

        System.out.println("今月のガス代金は" + total + "円");
    }
}
