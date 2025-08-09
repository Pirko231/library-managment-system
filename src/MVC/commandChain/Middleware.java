package MVC.commandChain;

public abstract class Middleware
{
    private Middleware next;

    public static Middleware link(Middleware first, Middleware... chain)
    {
        Middleware head = first;
        for (Middleware nextInChain: chain)
        {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public abstract boolean check(String[] args);

    protected boolean checkNext(String[] args)
    {
        if (next == null)
        {
            return true;
        }
        return next.check(args);
    }
}