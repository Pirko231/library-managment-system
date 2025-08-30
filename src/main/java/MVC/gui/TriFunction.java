package MVC.gui;

@FunctionalInterface
public interface TriFunction<T1,T2,T3,R> {
    public R apply(T1 arg1,T2 arg2 ,T3 arg3);
}
