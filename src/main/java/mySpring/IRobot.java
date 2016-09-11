package mySpring;

import lombok.Setter;

import javax.annotation.PostConstruct;

/**
 * Created by Jeka on 08/09/2016.
 */

@Setter
@Benchmark
public final class IRobot {
    @InjectByType
    private Speaker speaker;
    @InjectByType
    private Cleaner cleaner;

    @PostConstruct
    public void init() {
        System.out.println(speaker.getClass());
        System.out.println(cleaner.getClass());
    }

    public void cleanRoom(){
        speaker.speak("I started");
        cleaner.clean();
        speaker.speak("I finished");
    }
}
