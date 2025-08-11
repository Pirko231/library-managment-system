package MVC.objects;

public class Person {

    private static int allCode = 0;
    int code = 0;
    private String name;
    private String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        allCode++;
        code = allCode;
    }

    @Override
    public String toString() {
        return "{" + name + "," + surname + "}";
    }

    public String getHash() {
        return toString() + "_" + String.valueOf(code);
    }

    public void setCode(int code) {
        this.code = code;
    }
}
