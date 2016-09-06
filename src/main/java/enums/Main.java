package enums;

/**
 * Created by Jeka on 06/09/2016.
 */
public class Main {
    public static void main(String[] args) {
        int dbCode = 2;
        MaritalStatus maritalStatus = MaritalStatus.findByDbCode(dbCode);
        System.out.println(maritalStatus.getHebrewDesc());
    }
}
