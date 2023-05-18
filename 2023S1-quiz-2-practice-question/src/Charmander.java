public class Charmander extends Pokemon implements INoise{

    public Charmander(String name, int level)
    {
        super(name, level);
        this.type = new FireType();
    }

    public String makeNoise()
    {
        return "Charmander Char";
    }

    public void levelUp()
    {
        System.out.println("Charmander never levels up :(");
    }

    public void attack(Pokemon other)
    {
        other.loseLifePoints(100 * level);
        lifePoint += 5;
        levelUp();
    }

}
