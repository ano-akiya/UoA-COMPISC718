import java.lang.annotation.Inherited;

public class Squirtle extends Pokemon implements INoise {
    public Squirtle(String name, int level)
    {
        super(name, level);
        this.type = new WaterType();
    }

    public String makeNoise()
    {
        return "Squirtle squirt";
    }

    public void levelUp()
    {
        if (lifePoint >= 6 * level)
        {
            level = level + 1;
            System.out.println("Squirtle levelled up!");
        }
        else
        {
            System.out.println("Not enough experience for Squirtle!");
        }
    }

    public void attack(Pokemon other)
    {
        other.loseLifePoints(2 * level);
        lifePoint += 2;
        levelUp();
    }
}
