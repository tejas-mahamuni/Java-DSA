class App {
    public static void main(String[] args) {
        print(5);
    }

    static public void print(int rows) {
        int k = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(k++ + " ");
            }
            System.out.println();
        }
    }
}
