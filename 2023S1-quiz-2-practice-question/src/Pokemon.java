public abstract class Pokemon {
    protected String name;
    protected int level;
    protected int lifePoint;
    protected IType type;

    public Pokemon(String name, int level) {
        this.name = name;
        this.level = level;
        this.lifePoint = 10;
    }

    public abstract void attack(Pokemon other);

    public abstract void levelUp();

    public void loseLifePoints(int points) {
        lifePoint -= points;
        // Pokemon starts from the beginning if it loses more than what it has
        if (lifePoint <= 0) {
            level = 1;
            lifePoint = 10;
        }
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public IType getType() {
        return type;
    }
}