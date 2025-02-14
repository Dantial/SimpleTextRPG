import java.util.Random;
import java.util.Scanner;

class GameLogic {

    static Scanner scan = new Scanner(System.in);
    static Random random = new Random();
    static String[] locations = {"Mroczna Puszcza", "Zaginione Ruiny", "Głębia Smoczej Doliny"};
    static int currentLocationIndex = 0;

    public static void startJourney() {
        String location = locations[random.nextInt(locations.length)];
        System.out.println("\n--------------------------------");
        System.out.println(location);
        System.out.println("--------------------------------");
        System.out.println("Rozpoczynasz swoją podróż przez mroczne ziemie...");


        fightEnemy();
    }


    public static void fightEnemy() {
        Monster[] monsters = {
                new Monster("Ork", 40, 10),
                new Monster("Smok", 100, 25),
                new Monster("Goblin", 30, 5),
                new Monster("Elf Cienia", 50, 15),
                new Monster("Skrzat Złośliwy", 20, 8),
                new Monster("Dziki Wilk", 35, 12),
                new Monster("Rycerz Ciemnej Strony Mocy", 80, 20)
        };

        Monster enemy = monsters[random.nextInt(monsters.length)];
        System.out.println("Napotkałeś " + enemy.getName() + " z " + enemy.getHealth() + " HP!\n");

        while (enemy.getHealth() > 0 && Character.health > 0) {
            System.out.println("Twoje HP: " + Character.health);
            System.out.println(enemy.getName() + " HP: " + enemy.getHealth());
            System.out.println("\n(1) Atakuj");
            System.out.println("(2) Uciekaj");
            int action = scan.nextInt();

            if (action == 1) {
                int damageDealt = random.nextInt(15) + 5;
                int damageTaken = enemy.getDamage();

                enemy.takeDamage(damageDealt);
                Character.health -= damageTaken;

                System.out.println("\nZadałeś " + damageDealt + " obrażeń.");
                System.out.println("Przeciwnik zadał Ci " + damageTaken + " obrażeń.\n");

                if (Character.health <= 0) {
                    System.out.println("Zostałeś pokonany przez " + enemy.getName() + ". Gra kończy się...");
                    System.exit(0);
                } else if (enemy.getHealth() <= 0) {
                    int expFromFight = enemy.getExperienceReward();
                    int goldFromFight = random.nextInt(15) + 10;
                    Character.experience += expFromFight;
                    Character.gold += expFromFight;
                    System.out.println("Pokonałeś " + enemy.getName() + "! \nZdobywasz:\n" +
                            "XP: " + expFromFight + "\nGold: " + goldFromFight);
                    levelUp();
                }
            } else if (action == 2) {
                System.out.println("Uciekasz przed " + enemy.getName() + "...");
                break;
            } else {
                System.out.println("Nieznana opcja.");
            }
        }
    }

    public static void levelUp() {
        if (Character.experience >= 50 && Character.level == 1) {
            Character.level++;
            System.out.println("Gratulacje! Awansowałeś na poziom " + Character.level + "!\n");
        } else if (Character.experience >= 100 && Character.level == 2) {
            Character.level++;
            System.out.println("Gratulacje! Awansowałeś na poziom " + Character.level + "!\n");
        } else if (Character.experience >= 200 && Character.level == 3) {
            Character.level++;
            System.out.println("Gratulacje! Awansowałeś na poziom " + Character.level + "!\n");
        } else if (Character.experience >= 350 && Character.level == 4) {
            Character.level++;
            System.out.println("Gratulacje! Awansowałeś na poziom " + Character.level + "!\n");
        }

        if (Character.level == 5) {
            System.out.println("Osiągnąłeś 5. poziom, awansowałeś na Wojownika! Gratulacje, wygrałeś grę!");
            System.exit(0);
        }
    }


    public static void useHealthPotion() {
        if (Character.healthPotions > 0) {
            Character.health = Math.min(Character.health + 30, Character.maxHealth);
            Character.healthPotions--;
            System.out.println("Wypiłeś miksturę zdrowia. Twoje aktualne HP: " + Character.health);
        } else {
            if (Character.gold >= 10) {
                System.out.println("Nie masz więcej mikstur zdrowia! Kupujesz nową za 10 złota.");
                Character.gold -= 10;
                Character.healthPotions++;
                useHealthPotion();
            } else {
                System.out.println("Nie masz więcej mikstur ani wystarczająco dużo złota, aby je kupić!");
            }
        }
    }

    public static void currentCharInfo() {
        clearConsole();
        System.out.println("--------------------------------");
        System.out.println("INFORMACJE O POSTACI");
        System.out.println("--------------------------------");
        System.out.println(Character.name + "\t \tHP: " + Character.health + "/" + Character.maxHealth);
        System.out.println("Poziom: " + Character.level);
        System.out.println("XP: " + Character.experience + "\tZłoto: " + Character.gold);
        System.out.println("Mikstury zdrowia: " + Character.healthPotions + "\n");
    }

    public static void endGame() {
        System.out.println("Dziękujemy za grę, " + Character.name + "!" + " Do zobaczenia następnym razem.");
        System.exit(0);
    }

    public static void clearConsole() {
        for (int i = 0; i < 100; i++)
            System.out.println();
    }
}