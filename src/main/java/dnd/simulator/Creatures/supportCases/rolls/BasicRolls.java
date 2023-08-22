package dnd.simulator.Creatures.supportCases.rolls;

public enum BasicRolls {
    LOWEST_ROLL(8), 
    VERY_LOW_ROLL(9),
    LOW_ROLL(10),
    HIGH_ROLL(10),
    VERY_HIGH_ROLL(11),
    HIGHEEST_ROLL(11);

    private final int roll;

    BasicRolls(final int newRoll) {
        roll = newRoll;
    }

    public int getRoll() {
        return roll;
    }
}
