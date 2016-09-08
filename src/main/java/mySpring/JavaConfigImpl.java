package mySpring;

/**
 * Created by Jeka on 08/09/2016.
 */
public class JavaConfigImpl extends JavaConfig {
    @Override
    protected void configure() {
        addBinding(Speaker.class,PopupSpeaker.class);

    }
}
