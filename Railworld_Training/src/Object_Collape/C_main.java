package Object_Collape;

import Interface.Car_Function;

import java.util.Scanner;

public class C_main {
    public static void main(String[] args) {
        Cars c =new Cars();
        c.setName("Nexon");
        c.setModel("ys");
        c.setBrand("Maruti");
        System.out.println(c.getName()+" "+c.getModel()+" "+c.getBrand()+" ");
        System.out.println(c.toString());

        Scanner sc=new Scanner(System.in);

        Cars c1=new Cars(sc.nextLine(), sc.nextLine(),sc.nextLine());
        System.out.println(c1.toString());

       // Car_Function carFunction=(Double distance , double fuel_consumed)
//            @Override
//            public void Milage(double distance, double fuel_consumed) {
//
//            }
        }

    }
//}
