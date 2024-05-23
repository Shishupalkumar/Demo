package Inheritance.Multiple;

public class Bird implements Swim, Fly{
    public void swim()
    {
        System.out.println("Bird is swimming");
    }

    public void fly()
    {
        System.out.println("Bird is flying");
    }
}
