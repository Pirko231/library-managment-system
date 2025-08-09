package MVC;

import java.util.Optional;
import java.util.Scanner;

public class TerminalView implements View {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void draw() {

    }

    @Override
    public Optional<String[]> getCommand() {

        if (scanner.hasNextLine()) {
            // odczytanie lini
            String data = new String(scanner.nextLine());
            // liczenie spacji by okreslic rozmiar tablicy
            if (data.isEmpty()) {
                return Optional.empty();
            }
            int size = 1;
            for (int i = 0; i < data.length(); i++) {
                if (data.charAt(i) == ' ') {
                    size++;
                }
            }
            // wpisywanie danych do tablicy
            String[] args = new String[size];
            if (size == 1) {
                args[0] = data;
                return Optional.of(args);
            }
            data += " ";
            for (int i = 0; i < size; i++) {
                args[i] = data.substring(0, data.indexOf(' '));
                data = data.replace(args[0] + " ", "");
            }

            return Optional.of(args);
        }

        return Optional.empty();
    }
}
