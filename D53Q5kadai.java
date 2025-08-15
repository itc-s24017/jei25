public class D53Q5kadai {
    private static int[] taxes = {8, 10};
    private static int FOODS = 0;
    private static int OTHER = 1;

    public static void main(String[] args) {
        int dataSize = Integer.parseInt(args[0]);
        String[] names = new String[dataSize];
        int[] prices = new int[dataSize];
        int[] nums = new int[dataSize];
        char[] types = new char[dataSize];

        int argsIdx = 1;
        for (int i = 0; i < dataSize; i++) {
            names[i] = args[argsIdx++];
            prices[i] = Integer.parseInt(args[argsIdx++]);
            types[i] = args[argsIdx++].charAt(0);
        }

        int zeinukiTotal = 0;
        int zeikomiTotal = 0;

        System.out.println("商品名\t税抜\t税込\tタイプ");
        for (int i = 0; i < dataSize; i++) {
            int zeinuki = prices[i] * nums[i];
            int taxType = types[i] == 'f' ? FOODS : OTHER;
            int zeikomi = zeinuki * (100 + taxes[taxType]) / 100;

            zeinukiTotal += zeinuki;
            zeikomiTotal += zeikomi;

            System.out.printf("%-8s\t%4d円\t%4d円\t%s%n", names[i], zeinuki, zeikomi, viewType(types[i]));
        }

        System.out.printf("合計\t\t%4d円\t%4d円%n", zeinukiTotal, zeikomiTotal);
    }

    private static String viewType(char c) {
        return c == 'f' ? "食品等" : "その他";
    }
}