enum Connection {OFFLINE, ONLINE}

class D48Q22 {
    public static void main(String[] args) {
        Connection s = Connection.OFFLINE;
        if (s == Connection.OFFLINE){
            s = Connection.ONLINE;
        }
        System.out.println(s);
    }
}