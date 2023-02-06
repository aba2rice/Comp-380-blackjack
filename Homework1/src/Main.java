public class Main {

    /**
     * The absolute path to this homework's folder of csv files.
     */
    private static final String csvFileDir = System.getProperty("user.dir") + File.separator +
                                             "CSV files" + File.separator +
                                             "Homework2";

    /**
     *
     * @param args comand line arguments
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(csvFileDir + File.separator + "table-samples-70000.csv"));
        BufferedWriter writer = new BufferedWriter(new FileWriter(csvFileDir + File.separator + "HW2output.csv"));
        String csvLine;
        String ignoredComment;
        while ((csvLine = reader.readLine()) != null) {
            Table table = new Table(csvLine);
            writer.write(HW2Strategy.strategy(table, csvLine) + "\n");
            ignoredComment = reader.readLine();
        }

        reader.close();
        writer.close();
    }
}