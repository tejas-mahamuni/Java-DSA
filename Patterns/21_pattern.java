class App {
    public static void main(String[] args) {
        print(4);
    }

    static public void print(int rows) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if (i == 0 || j == 0 || i == rows - 1 || j == rows - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
