package strategy;

import java.util.Random;

/**
 * Created by Jeka on 06/09/2016.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        King king = new King();
        Knight knight = new Knight();
        Random random =  new Random();
        WeaponFactory weaponFactory = WeaponFactory.getInstance();
        while (true) {

            System.out.print(" king is fighting: ");
            king.fight();
            Thread.sleep(1000);
            System.out.print(" knight is fighting: ");
            knight.fight();
            if (random.nextInt(10) > 3) {
                king.setWeapon(weaponFactory.getWeapon());
            }
            if (random.nextInt(10) > 7) {
                knight.setWeapon(weaponFactory.getWeapon());
            }
        }
    }
}
