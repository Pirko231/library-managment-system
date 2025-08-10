
import MVC.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Program {

    public static void main(String[] args) {
        AtomicBoolean running = new AtomicBoolean(true);
        View view = new TerminalView();
        Model model = new DefaultModel(running);
        Controller controller = new Controller(view, model, running);

        if(args.length > 0) {
            controller.runChain(args);
            return;
        }

        while (controller.running()) {
            controller.update();
        }
    }
}
