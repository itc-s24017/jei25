public class D51kadai {
    public static void main(String[] args) {
        // コマンドライン引数の2番目（args[1]）をdouble型に変換
        double value = Double.parseDouble(args[1]);

        // 切り上げて表示
        System.out.println(Math.ceil(value));
    }
}
