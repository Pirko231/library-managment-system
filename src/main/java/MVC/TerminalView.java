package MVC;

import java.util.Optional;
import java.util.Scanner;

public class TerminalView implements View {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public Optional<String[]> getCommand() {

        if (scanner.hasNextLine()) {
            // odczytanie lini
            String data = new String(scanner.nextLine());
            // liczenie spacji by okreslic rozmiar tablicy
            if (data.isEmpty()) {
                return Optional.empty();
            }
            return Optional.of(data.split(" "));
        }

        return Optional.empty();
    }

    @Override
    public void update(Model model) {
        
    }
}
