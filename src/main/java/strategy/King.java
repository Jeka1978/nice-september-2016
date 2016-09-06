package strategy;

import lombok.Setter;

/**
 * Created by Jeka on 06/09/2016.
 */
@Setter
public class King implements Character {
    private Weapon weapon = new Sword();

    @Override
    public void fight() {
        weapon.fight();
    }
}

