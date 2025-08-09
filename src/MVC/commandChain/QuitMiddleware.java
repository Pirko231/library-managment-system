package MVC.commandChain;

import java.util.concurrent.atomic.AtomicBoolean;

public class QuitMiddleware extends Middleware {

    private AtomicBoolean running;

    public QuitMiddleware(AtomicBoolean running) {
        this.running = running;
    }

    @Override
    public boolean check(String[] args) {
        if (args.length > 0 && args[0].equals("q") || args[0].equals("quit")) {
            running.set(false);
            return true;
        }

        return checkNext(args);
    }
}
