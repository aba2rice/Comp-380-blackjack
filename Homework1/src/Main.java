public class Main {

    /**
     * The absolute path to this project directory.
     */
    private static final String userDir = System.getProperty("user.dir");

    /**
     *
     * @param args comand line arguments
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(userDir + File.separator + "src" + File.separator +
                                          "blackjack_table_samples-fixed.csv"));
        BufferedWriter writer = new BufferedWriter(new FileWriter(userDir + File.separator +
                                                    "src" + File.separator + "output.csv"));
        String csvLine;
        while ((csvLine = reader.readLine()) != null) {
            Table table = new Table(csvLine);
            writer.write(HW1Strategy.strategy(table, csvLine) + "\n");
        }

    }
}