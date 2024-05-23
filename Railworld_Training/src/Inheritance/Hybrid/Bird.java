package Inheritance.Hybrid;

 class Bird extends Animal implements Swim , Fly {
    public void swim() {
        System.out.println("Bird is swimming");
    }

    public void fly() {
        System.out.println("Bird is flying");
    }

     @Override
     public void Fly() {

     }

     @Override
     public void Swim() {

     }
 }
