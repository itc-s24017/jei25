public class D51Q6 {
    public static void main(String[] args) {
        // 大分類アイテム（コードと名前）
        Item[] li = {
                new Item("AA", "魚類"),
                new Item("BB", "肉類")
        };

        // 小分類アイテム（コードと名前）
        Item[] si = {
                new Item("A1", "さば"),
                new Item("A2", "さんま"),
                new Item("B1", "牛肉"),
                new Item("B2", "鶏肉"),
                new Item("B3", "豚肉"),
                new Item("B4", "加工肉") // ← ★ 実行例に必要な小分類を追加！
        };

        ItemMaster im = new ItemMaster(li, si);

        // 商品コードを分割
        String lcode = args[0].substring(0, 2);  // 大分類コード
        String scode = args[0].substring(2, 4);  // 小分類コード
        String details = args[0].substring(4);   // 詳細コード（（３３）イ）

        // 名前を取得
        String lname = im.getItemName(im.MAJOR, lcode); // （大分類コード→名前）
        String sname = im.getItemName(im.MINOR, scode); // （小分類コード→名前）

        // 出力
        System.out.println("商品コード：" + args[0]);
        System.out.println("大分類名：" + lname);
        System.out.println("小分類名：" + sname);
        System.out.println("詳細コード：" + details);
    }
}

// 単一の項目（コード＋名前）を表すクラス
class Item {
    private String code;
    private String name;

    Item(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
}

// 商品マスタークラス（分類コードと名称の対応管理）
class ItemMaster {
    public final int MAJOR = 0;
    public final int MINOR = 1;

    private Item[][] items; // （３４）エ

    ItemMaster(Item[] major, Item[] minor) {
        items = new Item[2][]; // 2分類（大・小）分の配列確保
        items[MAJOR] = major;
        items[MINOR] = minor;
    }

    public String getItemName(int codeLevel, String code) {
        for (int i = 0; i < items[codeLevel].length; i++) { // （３５）エ
            if (code.equals(items[codeLevel][i].getCode())) { // （３６）ウ
                return items[codeLevel][i].getName();
            }
        }
        return "(不明)"; // （３７）ウ
    }
}
