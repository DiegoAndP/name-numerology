import entities.Messages;
import entities.Table;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o seu nome completo: ");
        String name = sc.nextLine().toUpperCase().trim();
        sc.close();
        char[] splitLetters = name.toCharArray();
        int sumOfLetters = 0;

        for (char letter : splitLetters) {
            for (int i = 0; i < Table.LETTER_TABLE.length; i++) {
                for (int j = 0; j < 2; j++) {
                    if (Table.LETTER_TABLE[i][j] == letter) {
                        sumOfLetters += i + 1;
                    }
                }
            }
        }

        int result = sumOfNumber(sumOfLetters);

        do {
            result = sumOfNumber(result);
        } while (!Messages.MESSAGE_LIST.containsKey(result));

        System.out.println("Seu resultado é o número: " + result);
        System.out.println(Messages.MESSAGE_LIST.get(result));
    }

    static int sumOfNumber(int number) {
        int secondNumber = number / 10;
        int firstNumber = number % 10;
        return secondNumber + firstNumber;
    }
}
