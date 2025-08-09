import MVC.*;
import java.util.Scanner;

public class Program
{
    final private static Scanner scanner = new Scanner(System.in);
    //private static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args)
    {
        String filename = new String();
        if(args.length > 0 && args[0].contains(".txt"))
            filename = args[0];
        else
            filename = "books.txt";
        View view = new TerminalView();
        Model model = new DefaultModel(filename);
        Controller controller = new Controller(view, model);

        while(controller.running())
        {
            controller.update();
        }
    }
}