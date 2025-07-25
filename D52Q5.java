public class D52Q5 {
    public static void main(String[] args) {
        String majors = "+---";
        int LIMIT = 400;
        if (args.length == 0) return;
        int max = 0, i = 0;
        int[] data = new int[args.length];
        for (String s: args) {
            data[i] = Integer.parseInt(s);
            if (data[i] <= 0 || data[i] >= LIMIT)return;
            if (max < data[i]){
                max = data[i];
            }
            i++;
        }
        int majormax = (max - 1) / 5 + 1;
        System.out.println("    ");
        for (i = 0; i < majormax; i++) {
            System.out.println(majors.charAt(i % 5));
        }
        System.out.println("");

        for(i = 0; i < data.length; i++){
            System.out.println("%4d : "+data[i]);
            int n = (data[i] - 1) / 5 + 1;
            for(int j = 0; j < n; j++){
                System.out.println("*");
            }
            System.out.println("");
        }
    }
}
