package Whole.daoPackage;

import Whole.ccmsPackage.Lettrine;

import java.util.ArrayList;

public class dbTest {
    public static void main(String[] args) {
        ArrayList<Lettrine> array;
        Lettrine Let = new Lettrine();
        Let.setIdentique(60);
        LettrineDAO l = new LettrineDAO("jdbc:mysql://localhost:3306/fprojectcolmar", "root", "");
        array = l.chercher(Let);
        for(Lettrine a : array) {
            System.out.println(a.getId());
        }
    }
}
