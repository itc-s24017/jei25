public class D51Q6 {
    public static void main(String[] args) {
        Item[] li = {
                new Item("AA", "魚類"),
                new Item("BB", "肉類")
        };

        Item[] si = {
                new Item("A1", "さば"),
                new Item("A2", "さんま"),
                new Item("B1", "牛肉"),
                new Item("B2", "鶏肉"),
                new Item("B3", "豚肉"),
                new Item("B4", "加工肉")
        };

        ItemMaster im = new ItemMaster(li, si);

        String lcode = args[0].substring(0, 2);
        String scode = args[0].substring(2, 4);
        String details = args[0].substring(4);
        String lname = im.getItemName(im.MAJOR, lcode);
        String sname = im.getItemName(im.MINOR, scode);

        System.out.println("商品コード：" + args[0]);
        System.out.println("大分類名：" + lname);
        System.out.println("小分類名：" + sname);
        System.out.println("詳細コード：" + details);
    }
}

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

class ItemMaster {
    public final int MAJOR = 0;
    public final int MINOR = 1;

    private Item[][] items; // （３４）エ

    ItemMaster(Item[] major, Item[] minor) {
        items = new Item[2][];
        items[MAJOR] = major;
        items[MINOR] = minor;
    }

    public String getItemName(int codeLevel, String code) {
        for (int i = 0; i < items[codeLevel].length; i++) {
            if (code.equals(items[codeLevel][i].getCode())) {
                return items[codeLevel][i].getName();
            }
        }
        return "(不明)";
    }
}
