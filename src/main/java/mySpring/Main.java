package mySpring;

/**
 * Created by Jeka on 08/09/2016.
 */
public class Main {
    public static void main(String[] args) {
        IRobot iRobot = ObjectFactory.getInstance().createObject(IRobot.class);
        iRobot.cleanRoom();
        System.out.println(iRobot.getClass());
       /* SimpleService service = ObjectFactory.getInstance().createObject(SimpleService.class);
        service.a();
        service.b();
        service.c();*/
    }
}
