package strategy;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by Jeka on 06/09/2016.
 */
public class WeaponFactory {
    private static WeaponFactory ourInstance = new WeaponFactory();

    public static WeaponFactory getInstance() {
        return ourInstance;
    }

    private Reflections reflections = new Reflections();
    private List<Class<? extends Weapon>> weaponClasses = new ArrayList<>();

    private WeaponFactory() {
        Set<Class<? extends Weapon>> classes = reflections.getSubTypesOf(Weapon.class);
        for (Class<? extends Weapon> aClass : classes) {
            if (!Modifier.isAbstract(aClass.getModifiers())) {
                weaponClasses.add(aClass);
            }
        }
    }

    @SneakyThrows
    public Weapon getWeapon(){
        Random random = new Random();
        Class<? extends Weapon> weaponClass = weaponClasses.get(random.nextInt(weaponClasses.size()));
        return weaponClass.newInstance();
    }








}
