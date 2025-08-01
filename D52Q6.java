public class D52Q6 {
    public static void main(String[] args) {
        Drink[] dr = {
                new Drink("Gomacola", 150),
                new Drink("MrPepper", 130),
                new Drink("SaltWater", 320)
        };
        VendingMachine vm = new VendingMachine(dr);

        // 初期状態の表示
        System.out.println("--- 自動販売機初期状態 ---");
        vm.display();
        System.out.println("--------------------------");

        // 各コマンドの実行
        System.out.println("\n--- コマンド実行: i 100 ---");
        vm.execCom("i 100"); // 100円投入

        System.out.println("\n--- コマンド実行: p 2 ---");
        vm.execCom("p 2");   // MrPepper (130円) を購入

        System.out.println("\n--- コマンド実行: i 500 ---");
        vm.execCom("i 500"); // 500円投入

        System.out.println("\n--- コマンド実行: p 3 ---");
        vm.execCom("p 3");   // SaltWater (320円) を購入

        System.out.println("\n--- コマンド実行: c 0 ---");
        vm.execCom("c 0");   // お釣り排出 (引数の0は特に意味はないが、コマンド形式に合わせる)

        System.out.println("\n--- 処理終了 ---");
    }
}

class Drink {
    private String name;
    private int price;

    Drink(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override // toStringメソッドをオーバーライドしていることを明示
    public String toString() {
        return "[" + name + "]" + price + "円";
    }
}

class VendingMachine {
    private Drink[] drinks;
    private int[] coins = {500, 100, 50, 10}; // 降順にしておくことでお釣りの計算が楽になる
    private int cash = 0; // 投入された現金を管理する変数

    VendingMachine(Drink[] drinks) {
        this.drinks = drinks;
    }

    public void display() {
        int idx = 1;
        System.out.println("--- ドリンク一覧 ---");
        for (Drink drink : drinks) {
            System.out.println("[" + idx + "]" + drink);
            idx++;
        }
        System.out.println("現在の投入金額: " + cash + "円");
    }

    public void execCom(String command) {
        String[] s = command.split(" ");
        String cmdType = s[0]; // コマンドの種類 (i, p, c)

        switch (cmdType) {
            case "i": // お金を投入
                if (s.length < 2) {
                    System.out.println("エラー: 投入金額が指定されていません。例: i 100");
                    return;
                }
                int insertedCoin;
                try {
                    insertedCoin = Integer.parseInt(s[1]);
                } catch (NumberFormatException e) {
                    System.out.println("エラー: 無効な金額です: " + s[1]);
                    return;
                }
                if (isCoin(insertedCoin)) {
                    cash += insertedCoin;
                    System.out.println(insertedCoin + "円を投入しました。現在の投入金額: " + cash + "円");
                } else {
                    System.out.println(insertedCoin + "円は使用できません。投入可能な硬貨: 10, 50, 100, 500円");
                }
                break;

            case "p": // 商品を購入
                if (s.length < 2) {
                    System.out.println("エラー: 商品番号が指定されていません。例: p 1");
                    return;
                }
                int idx;
                try {
                    idx = Integer.parseInt(s[1]) - 1; // 1ベースの番号を0ベースに変換
                } catch (NumberFormatException e) {
                    System.out.println("エラー: 無効な商品番号です: " + s[1]);
                    return;
                }

                if (idx < 0 || idx >= drinks.length) {
                    System.out.println("エラー: 商品番号が不正です。");
                    return;
                }

                int price = drinks[idx].getPrice();
                if (cash >= price) {
                    eject(idx); // 商品を排出
                    cash -= price; // 現金から商品の値段を引く
                    System.out.println("残りの投入金額: " + cash + "円");
                } else {
                    System.out.println("お金が足りません。投入金額: " + cash + "円, 商品価格: " + price + "円");
                }
                break;

            case "c": // お釣りを排出
                payChange();
                break;

            default:
                System.out.println("不明なコマンドです: " + cmdType);
                break;
        }
    }

    // 指定された金額が有効な硬貨であるか判定
    private boolean isCoin(int c) {
        for (int coin : coins) {
            if (c == coin) {
                return true;
            }
        }
        return false;
    }

    // 商品を排出するメッセージを表示
    private void eject(int idx) {
        System.out.println(drinks[idx] + "が排出されました");
    }

    // お釣りを計算して表示し、現金をリセット
    private void payChange() {
        if (cash == 0) {
            System.out.println("お釣り なし");
            return;
        }

        StringBuilder sb = new StringBuilder("お釣り: "); // StringBuilder を使うと文字列連結が効率的
        boolean firstCoin = true; // 最初の硬貨かどうかを判定するためのフラグ

        for (int coin : coins) {
            int count = cash / coin; // その硬貨で何枚お釣りが出せるか
            if (count > 0) {
                if (!firstCoin) {
                    sb.append(", "); // 2枚目以降の硬貨の場合にカンマを追加
                }
                sb.append(coin).append("円:").append(count).append("枚");
                cash %= coin; // お釣りを出した分だけ残金を減らす
                firstCoin = false;
            }
        }
        System.out.println(sb.toString());
        cash = 0; // お釣りを出したので投入金額を0にする
    }
}