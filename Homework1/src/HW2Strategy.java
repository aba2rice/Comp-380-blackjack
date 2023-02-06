/**
 * COMP 380 - HOMEWORK 2 (Wiki Strategy)
 *
 * AUTHORS - Jerome Cerio, Alex Hochstein, Andrew Adams, Sam Yu
 */

/**
 * Class to implement the simplified Wiki Blackjack strategy of Homework 2.
 */
import java.util.List;
import java.util.Map;

public class HW2Strategy {
    private static final Map<Card.Rank, Map<Card.Rank, String>> pairMap = makePairMap();
    private static final Map<Card.Rank, Map<Integer, String>> softMap = makeSoftMap();
    private static final Map<Card.Rank, Map<Integer, String>> hardMap = makeHardMap();

    /**
     * Prepends the decision (HIT or STAY) to the beginning of the
     * line of csv.
     *
     * @param table the table of all hands
     * @param csvLine the line of csv
     * @return the line of csv with the decision inserted in front
     */
    public static String strategy(Table table, String csvLine) {
        Card dealerCard = table.getDealerCard();
        String decision;

        if(hand.isPair()) {     //if hand is pair use pair sheet
            decision = pairMap.get(dealerCard.getRank()).get(
                    table.getPlayer1Hand().getCards().get(0).getRank());
        } else if(hand.isSoft()) {      //if hand is soft (contains ace) use soft sheet
            decision = softMap.get(dealerCard.getRank()).get(table.getPlayer1Hand().getSoft());
        } else {        //otherwise use hard sheet
            decision = hardMap.get(dealerCard.getRank()).get(table.getPlayer1Hand().getHard());
        }

        // Testing for alternate outputs dependent on hand size
        if (result.contains("/")) {
            String option1 = result.subString(0, result.indexOf('/'));
            String option2 = result.subString(result.indexOf('/') + 1);
            decision = (table.getPlayer1Hand().handSize() == 2) ? option1 : option2;
        }

        return decision;
    }

    /**
     * This method parses the CSV file of the PAIR TABLE of the wiki strategy to create
     * a mapping that will give the correct decision for the given dealer and player hands.
     *
     * @return a nested mapping of card ranks to strings that represents the PAIR TABLE
     *         of the wiki strategy.
     */
    public static Map<Card.Rank, Map<Card.Rank, String>> makePairMap() {
        List<String> lines = new ArrayList<>;

        BufferedReader reader = new BufferedReader(new FileReader(srcDir + File.separator + "Wiki Strategy (Simplified) - pairs.csv"));
        String csvLine;
        while ((csvLine = reader.readLine()) != null) {
            lines.append(csvLine);
        }

        List<String> keys = new ArrayList(lines.get(0).split(","));
        keys.remove(0);
        lines.remove(0);

        Map<Card.Rank, Map<Card.Rank, String>> ext_map = new HashMap<>();

        for(line : lines){
            Map<Card.Rank, String> internal_map = new HashMap<>();
            values = line.split(",");
            Card.Rank first_val = Card.cardMap().get(Card.Rank.class, values.get(0).split("+")[0]);
            values.remove(0);
            for(int i = 0; i < keys.length(); i++){
                internal_map.put(Enum.valueOf(Card.Rank.class, keys.get(i)), values.get(i));
            }
            ext_map.put(first_val, internal_map);
        }


        return ext_map;
    }

    /**
     * This method parses the CSV file of the SOFT TABLE of the wiki strategy to create
     * a mapping that will give the correct decision for the given dealer and player hands.
     *
     * @return a nested mapping that represents the SOFT TABLE of the wiki strategy.
     *         NOTE: the type of the inner keys of the map (representing the player hand) is INTEGER
     *         rather than type Card.Rank.
     */
    public static Map<Card.Rank, Map<Integer, String>> makeSoftMap() {
        List<String> lines = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(srcDir + File.separator + "Wiki Strategy (Simplified) - soft.csv"));
        String csvLine;
        while ((csvLine = reader.readLine()) != null) {
            lines.append(csvLine);
        }

        List<String> keys = new ArrayList(lines.get(0).split(","));
        keys.remove(0);
        lines.remove(0);

        Map<Card.Rank, Map<Card.Rank, String>> ext_map = new HashMap<>();

        for(line : lines){
            Map<Card.Rank, String> internal_map = new HashMap<>();
            values = line.split(",");
            Card.Rank first_val = Card.cardMap().get(Card.Rank.class, Integer.valueOf(values.get(0).substring(2)));
            values.remove(0);
            for(int i = 0; i < keys.length(); i++){
                internal_map.put(Enum.valueOf(Card.Rank.class, keys.get(i)), values.get(i));
            }
            ext_map.put(first_val, internal_map);
        }

        return ext_map;

    }

    /**
     * This method parses the CSV file of the HARD TABLE of the wiki strategy to create
     * a mapping that will give the correct decision for the given dealer and player hands.
     *
     * @return a nested mapping that represents the HARD TABLE of the wiki strategy.
     *         NOTE: the type of the inner keys of the map (representing the player hand) is INTEGER
     *         rather than type Card.Rank.
     */
    public static Map<Card.Rank, Map<Integer, String>> makeHardMap() {
        List<String> lines = new ArrayList<>;

        BufferedReader reader = new BufferedReader(new FileReader(srcDir + File.separator + "Wiki Strategy (Simplified) - hard.csv"));
        String csvLine;
        while ((csvLine = reader.readLine()) != null) {
            lines.append(csvLine);
        }
        List<String> keys = new ArrayList(lines.get(0).split(","));
        keys.remove(0);
        lines.remove(0);

        Map<Card.Rank, Map<Card.Rank, String>> ext_map = new HashMap<>();



    }

}
