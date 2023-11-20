package dnd.simulator.dto;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FeatDto {
    public String featName;
    
    public String type;

    public FeatPrerequisiteDto prerequesites;

    public String benefit;

    public String normal;

    public String special;

    public int maxCount;

    public ArrayList<String> bonusFor;
}
