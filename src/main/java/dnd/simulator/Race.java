package dnd.simulator;

import java.util.List;

public class Race {
    public String name;
    public String type;
    public String subtype;
    public List<AttributeModifier> modifiers;
    public List<String> racialFeats;
    public List<String> racialSpellLikes;
    public List<String> racialExtraordinnary;
    public List<String> racialSuperNatural;
    public DamageResistance damageResistance;
    public SpellResistance spellResistance;
    public FastHealing fastHealing;
    public Regeneration regeneration;
}
