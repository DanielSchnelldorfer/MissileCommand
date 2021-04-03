package psta.opticsandsound;

/**
 * Class containing all String elements, that are used for graphical output of objects in the game.
 */
public class OpticalElements {

    /**
     * Constructor of the class.
     */
    public OpticalElements() {
    }

    /**
     * Method for showing mountains.
     *
     * @return String of mountains
     */
    public String getMountains() {
        return "       YYYY                   Y                                                                      YY            Y                                                                                          YY                   YYYY         \n" +
                "      YYYYYY                YYYY                                                                    YYYY           YY                                                                                        YYYYY                YYYYYY        \n" +
                "     YYYYYYYYYYYYYYYYYYYYYYYYYYYY                                                                 YYYYYYYYYYYYYYYYYYYY                                                                                     YYYYYYYYYYYYYYYYYYYYYYYYYYYYYY       \n" +
                "    YYYYYYYYYYYYYYYYYYYYYYYYYYYYYY                                                               YYYYYYYYYYYYYYYYYYYYYYY                                                                                 YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY      \n" +
                "  YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY                                                             YYYYYYYYYYYYYYYYYYYYYYYYY                                                                               YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY     \n" +
                " YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY                                                         YYYYYYYYYYYYYYYYYYYYYYYYYYYYY                                                                             YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY   \n" +
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY                                                    YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY                                                                         YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY \n" +
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY                                             YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY                                                                   YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY\n" +
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY\n" +
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY\n" +
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY\n" +
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY\n" +
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY\n" +
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY\n" +
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY\n" +
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY\n" +
                "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY\n";

    }

    /**
     * Method for showing a city.
     *
     * @return String of a city
     */
    public String getCity() {

        return "                           \n" +
                "     B           BB        \n" +
                "     BB         BBBB       \n" +
                "    BBBB  BBB  BBBBBBB     \n" +
                "   BBBbBBBB BBBBbbbbBBBBB  \n" +
                "   BBBbbbBBBBBbbbbbbBBBBBBB\n" +
                "  BBbbbbbbbBBbbbbbbbBBBBBBB\n" +
                "BBbbbbbLLLbbbbbbbLbbbbbBBBB\n" +
                "BbbbbLLLLLLLLLLLLLLbbbbbbbB\n";
    }

    /**
     * Method for returning an arrow.
     *
     * @return String of a arrow
     */
    public String getRedArrows() {
        return "                      \n" +
                "                      \n" +
                "       RRRRRRRR       \n" +
                "       RRRRRRRR       \n" +
                "       RRRRRRRR       \n" +
                "   RR  RRRRRRRR  RR   \n" +
                "    RRRRRRRRRRRRRR    \n" +
                "     RRRRRRRRRRRR     \n" +
                "      RRRRRRRRRR      \n" +
                "       RRRRRRRR       \n" +
                "        RRRRRR        \n" +
                "         RRRR         \n";

    }

    /**
     * Method for returning a stationed missile.
     *
     * @return String of a stationed missile
     */
    public String getMissile() {
        return
                "       BB           \n" +
                        "       BB           \n" +
                        "       BB           \n" +
                        "       BB           \n" +
                        "       BB           \n" +
                        "       BB           \n" +
                        "      BBBB          \n" +
                        "     BBBBBB         \n" +
                        "     BB  BB         \n" +
                        "     BB  BB         \n" +
                        "     B    B         \n";

    }

    /**
     * Method for returning a enemy aircraft.
     *
     * @return String of a enemy aircraft
     */
    public String getEnemyAircraft() {
        return "                      \n" +
                "                      \n" +
                "    R                 \n" +
                "    RR                \n" +
                " R  RRRR              \n" +
                " RRRRRRRRRRRRR        \n" +
                "  RRRRRRRRRRRRRRRRRR  \n" +
                " RRRRRRRRRRRRR        \n" +
                " R  RRRR               \n" +
                "    RR                \n" +
                "    R                 \n" +
                "                      \n";

    }

}
