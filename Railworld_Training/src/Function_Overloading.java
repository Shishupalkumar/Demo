public class Function_Overloading
{
    public  void Area(int length, int breadth){
        System.out.println("The Area is: "+length*breadth);

    }
    public void Area(int length){
        System.out.println("The Radius is :"+length*length);
    }
    public void Area(double length){
        System.out.println("The Radius"+length*length*Math.PI);
    }

}
