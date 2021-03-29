package studentskills.mytree;

import java.util.Set;

/**
 *Sets data for printing nodes
 */
public class StudentSkills {
    private int bNumber;
    private Set<String> skills;

    public int getbNumber() {
        return bNumber;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    public void setbNumber(int bNumber) {
        this.bNumber = bNumber;
    }

    @Override
    public String toString() {
        return "StudentSkills{" +
                "bNumber=" + bNumber +
                ", skills=" + skills +
                '}';
    }
}
