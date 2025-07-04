public class D51Q26kadai {
    public static void main(String[] args) {
        int number = 1;

        // switch文を使用して値に応じた処理を行う
        switch (number) {
            case 1: // case文：numberが1のときにこのブロックが実行される
                System.out.println("one");
                break; // break文：ここでswitch文の処理を終了。次のcaseへは進まない
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
            default: // default文：どのcaseにも一致しない場合に実行される
                System.out.println("not one, two, or three");
        }
    }
}
