package dnd.simulator.creatures.supportCases.rolls;

public enum GoodRolls {
    LOWEST_ROLL(8), 
    VERY_LOW_ROLL(9),
    LOW_ROLL(10),
    HIGH_ROLL(11),
    VERY_HIGH_ROLL(12),
    HIGHEEST_ROLL(13);

    private final int roll;

    GoodRolls(final int newRoll) {
        roll = newRoll;
    }

    public int getRoll() {
        return roll;
    }
}
