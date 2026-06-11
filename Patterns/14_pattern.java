class App {
    public static void main(String[] args) {
        print(5);
    }

    static public void print(int rows) {
        for (int i = 1; i <= rows; i++) {
            char k = 65;
            for (int j = 1; j <= i; j++) {
                System.out.print(k++ + " ");
            }
            System.out.println();
        }
    }
}
