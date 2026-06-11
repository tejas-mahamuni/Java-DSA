class App {
    public static void main(String[] args) {
        print(5);
    }

    static public void print(int rows) {
        for (int i = 1; i <= (rows * 2) - 1; i++) {

            int stars = i;

            if (i > rows) {
                stars = rows * 2 - i;
            }
            for (int j = 1; j <= stars; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }
}
