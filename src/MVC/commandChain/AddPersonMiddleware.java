package MVC.commandChain;

public class AddPersonMiddleware extends Middleware
{
    @Override
    public boolean check(String[] args)
    {
        return false;
    }
}