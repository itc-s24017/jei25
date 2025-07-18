// メインクラス
public class D52Ensyu {
    public static void main(String[] args) {
        Animal tama = new Cat();   // Catのインスタンス
        Animal ao = new Horse();   // Horseのインスタンス
        Animal a = new Animal(); //

        tama.bark();  // にゃーん
        ao.bark();    // ひひーん
        a.bark(); // なにか動物の鳴き声
    }
}

// 親クラス
class Animal {
    public void bark() {
        System.out.println("なにか動物の鳴き声");
    }
}

// Catクラス
class Cat extends Animal {
    public void bark() {
        System.out.println("にゃーん");
    }
}

// Horseクラス
class Horse extends Animal {
    public void bark() {
        System.out.println("ひひーん");
    }
}
