public class D51Q21kadai {
    public static void main(String[] args) {
        // 2進数（0bで始まる） → 10進数の 5
        int binary = 0b0101;

        // 8進数（0で始まる） → 10進数の 17
        int octal = 021;

        // 10進数（通常の整数） → 20
        int decimal = 20;

        // 16進数（0xで始まる） → 10進数の 255
        int hex = 0xFF;

        // それぞれの値を出力（確認用）
        System.out.println("各基数の値（10進数として表示）:");
        System.out.println("2進数 0b0101 = " + binary);
        System.out.println("8進数 021 = " + octal);
        System.out.println("10進数 20 = " + decimal);
        System.out.println("16進数 0xFF = " + hex);

        // 合計を計算
        int sum = binary + octal + decimal + hex;

        // 結果を出力
        System.out.println("合計（binary + octal + decimal + hex） = " + sum);
    }
}