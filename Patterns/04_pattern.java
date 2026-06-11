class App {
    public static void main(String[] args) {
        print(5);
    }

    static public void print(int m) {
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
