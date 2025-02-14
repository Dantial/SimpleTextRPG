import java.util.*;

public class CastleOfTheWarriors {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        boolean inMenu = true;

        System.out.println("\n--------------------------------");
        System.out.println("Zamek Wojowników");
        System.out.println("--------------------------------");

        System.out.println("Podaj swoje imię Przybyszu, aby rozpocząć przygodę w Zamku Wojowników: ");
        Character.name = scan.nextLine();
        System.out.println("\nWitaj " + Character.name + "!");
        System.out.println("Od dziś będziesz dumnie dzierżył status kandydata na Wojownika. Twoja podróż właśnie się rozpoczyna.\n");
        System.out.println("--------------------------------");
        System.out.println("Wybierz akcję:");
        System.out.println("--------------------------------");
        System.out.println("(1) Rozpocznij wędrówkę!");
        System.out.println("(2) Zakończ przygodę.");

        try {
            int userChoice = scan.nextInt();
            if (userChoice == 1) {
                while (inMenu) {
                    System.out.println("\n--------------------------------");
                    System.out.println("Zamek Wojowników");
                    System.out.println("--------------------------------");
                    System.out.println("Wybierz akcję:");
                    System.out.println("--------------------------------");
                    System.out.println("(1) Kontynuuj przygodę!");
                    System.out.println("(2) Informacje o postaci.");
                    System.out.println("(3) Wypij miksturę zdrowia.");
                    System.out.println("(4) Zakończ przygodę.");

                    userChoice = scan.nextInt();
                    switch (userChoice) {
                        case 1:
                            GameLogic.startJourney();
                            break;
                        case 2:
                            GameLogic.currentCharInfo();
                            break;
                        case 3:
                            GameLogic.useHealthPotion();
                            break;
                        case 4:
                            inMenu = false;
                            GameLogic.endGame();
                            break;
                        default:
                            System.out.println("Nieznana opcja. Wybierz ponownie.");
                    }
                }
            } else {
                GameLogic.endGame();
            }
        } catch (InputMismatchException e) {
            System.out.println("Wprowadzono nieprawidłową opcję. Gra zakończona.");
        }
    }
}