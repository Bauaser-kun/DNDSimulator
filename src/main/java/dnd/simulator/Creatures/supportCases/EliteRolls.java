package dnd.simulator.Creatures.supportCases;

public enum EliteRolls {
    LOWEST_ROLL(8), 
    VERY_LOW_ROLL(10),
    LOW_ROLL(12),
    HIGH_ROLL(13),
    VERY_HIGH_ROLL(14),
    HIGHEEST_ROLL(15);

    private final int roll;

    EliteRolls(final int newRoll) {
        roll = newRoll;
    }

    public int getRoll() {
        return roll;
    }
}
