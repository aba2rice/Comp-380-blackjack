public class Main {

    /**
     * The absolute path to this project's src directory.
     */
    private static final String srcDir = System.getProperty("user.dir") + File.separator + "src";

    /**
     *
     * @param args comand line arguments
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(srcDir + File.separator + "blackjack_table_samples-fixed.csv"));
        BufferedWriter writer = new BufferedWriter(new FileWriter(srcDir + File.separator + "output.csv"));
        String csvLine;
        while ((csvLine = reader.readLine()) != null) {
            Table table = new Table(csvLine);
            writer.write(HW1Strategy.strategy(table, csvLine) + "\n");
        }

        reader.close();
        writer.close();
    }
}