public class D52Q5kadai {
    public static void main(String[] args) {
        String majorsPattern = "+----------"; // 10単位の目盛りパターン
        int LIMIT = 400; // 以前と同じ上限値

        if (args.length == 0) {
            return; // 引数がない場合は終了
        }

        int max = 0;
        int[] data = new int[args.length];

        // 入力値のパースと検証、最大値の特定
        for (int i = 0; i < args.length; i++) {
            try {
                data[i] = Integer.parseInt(args[i]);
            } catch (NumberFormatException e) {
                System.err.println("エラー: 無効な数値が入力されました: " + args[i]);
                return; // 数値変換エラーの場合は終了
            }

            if (data[i] <= 0 || data[i] >= LIMIT) {
                System.err.println("エラー: 数値は1以上 " + (LIMIT - 1) + " 以下である必要があります: " + data[i]);
                return; // 範囲外の数値の場合は終了
            }

            if (max < data[i]) {
                max = data[i];
            }
        }

        // 目盛りの最大値を計算 (10単位)
        int majormax = (max - 1) / 10 + 1;

        // 目盛り行の出力
        for (int i = 0; i < majormax; i++) {
            // majorsPatternを繰り返して出力。ただし、最後の部分文字列は残りの長さ分だけ
            if (i == majormax - 1 && (max % 10 != 0)) { // 最後の目盛りで10の倍数でない場合
                System.out.print(majorsPattern.substring(0, (max % 10) + 1)); // 必要な部分だけ切り出す
            } else {
                System.out.print(majorsPattern);
            }

        }
        System.out.println(); // 目盛り行の後に改行

        // 各データの棒グラフ出力
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%4d : ", data[i]); // 数値を整形して出力
            int n = (data[i] - 1) / 10 + 1; // 10単位でアスタリスクの数を計算
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println(); // 棒グラフの後に改行
        }
    }
}