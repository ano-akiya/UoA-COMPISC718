public class Psyduck extends Pokemon implements INoise{

    public Psyduck(String name, int level)
    {
        super(name,level);
        this.type = new WaterType();
    }

    public String makeNoise()
    {
        return "Psy~~~duck";
    }

    public void levelUp()
    {
        if (lifePoint >= 10 * level)
        {
            level++;
            System.out.println("Psyduck levelled up!");
        } else {
            System.out.println("Not enough experience for Psyduck!");
        }
    }

    public void attack(Pokemon other)
    {
        other.loseLifePoints(20 * level);
        lifePoint += 1;
        levelUp();
    }

}
