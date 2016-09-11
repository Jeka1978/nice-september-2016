package mySpring;

/**
 * Created by Jeka on 08/09/2016.
 */
public class IRobot {
    @InjectByType
    private Speaker speaker;
    @InjectByType
    private Cleaner cleaner;

    public void cleanRoom(){
        speaker.speak("I started");
        cleaner.clean();
        speaker.speak("I finished");
    }
}
