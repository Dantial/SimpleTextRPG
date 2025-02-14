class Monster {
    private String name;
    private int health;
    private int damage;
    private int experienceReward;

    public Monster(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.experienceReward = health / 2;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public int getExperienceReward() {
        return experienceReward;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }
}