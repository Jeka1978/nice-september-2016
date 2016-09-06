package builder;

/**
 * Created by Jeka on 06/09/2016.
 */
public class Main {
    public static void main(String[] args) {
        Client client = new Client.Builder().bonus(200).debt(300).build();
        client = client.addBonus(500);
        System.out.println("client = " + client);
    }
}
