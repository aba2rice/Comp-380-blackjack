public class Main {

    /**
     * The absolute path to this project directory.
     */
    private static final String userDir = System.getProperty("user.dir");

    public static void main(String[] args) {
        String csvLine = ",1f0c8,,,,,,,1f0b6,1f0a2,1f0d7";
        Table table = new Table(csvLine);
        System.out.println(HW1Strategy.strategy(table, csvLine));
    }
}