public class D51Q26kadai {
    public static void main(String[] args) {
        int number = 1;
        String result = "";

        // switch文：numberの値に応じて処理を分岐
        switch (number) {
            case 1:
                // case文：numberが1と一致した場合、このブロックが実行される
                result = "one";
                break; // break文：この行でswitch文から抜けて、他のcaseは実行されない

            case 2:
                result = "two";
                break;

            default:
                result = "other";
                // default：どのcaseにも一致しなかった場合に実行される（breakがなくても最後なので抜ける）
        }

        System.out.println(result); // 出力: "one"
    }
}
