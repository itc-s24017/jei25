public class D51Q6kadai {
    public static void main(String[] args) {
        // コマンドシナリオ配列を定義
        String[] scenario = {
                "i 100",   // 100円投入
                "i 50",    // 50円投入
                "r",       // 残高表示
                "l",       // 商品一覧表示
                "b C1",    // 商品C1購入
                "r",       // 残高表示
                "c",       // おつり返却
                "r"        // 残高表示（0になるはず）
        };

        // 自動販売機の初期化
        Drink2[] drinks = {
                new Drink2("A1", "お茶", 120),
                new Drink2("B1", "コーヒー", 150),
                new Drink2("C1", "水", 100)
        };
        VendingMachine2 vm = new VendingMachine2(drinks);

        // 各コマンドを順に実行
        for (String com : scenario) {
            vm.execCom(com);
        }
    }
}

// 商品（ドリンク）クラス
class Drink2 {
    private String code;
    private String name;
    private int price;

    public Drink2(String code, String name, int price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public int getPrice() { return price; }
}

// 自動販売機クラス
class VendingMachine2 {
    private Drink2[] drinks;
    private int balance = 0;

    public VendingMachine2(Drink2[] drinks) {
        this.drinks = drinks;
    }

    public void execCom(String com) {
        String[] parts = com.split(" ");
        switch (parts[0]) {
            case "i": // お金投入
                int amount = Integer.parseInt(parts[1]);
                balance += amount;
                System.out.println(amount + "円投入されました。");
                break;
            case "r": // 残高表示
                System.out.println("残高：" + balance + "円");
                break;
            case "l": // 商品一覧表示
                System.out.println("商品一覧：");
                for (Drink2 d : drinks) {
                    System.out.println(d.getCode() + ": " + d.getName() + " (" + d.getPrice() + "円)");
                }
                break;
            case "b": // 商品購入
                String code = parts[1];
                Drink2 selected = null;
                for (Drink2 d : drinks) {
                    if (d.getCode().equals(code)) {
                        selected = d;
                        break;
                    }
                }
                if (selected == null) {
                    System.out.println("該当する商品がありません。");
                } else if (balance < selected.getPrice()) {
                    System.out.println("残高不足です。");
                } else {
                    balance -= selected.getPrice();
                    System.out.println(selected.getName() + " を購入しました。");
                }
                break;
            case "c": // おつり返却
                System.out.println("おつり " + balance + "円 を返却します。");
                balance = 0;
                break;
            default:
                System.out.println("不明なコマンド：" + com);
        }
    }
}
