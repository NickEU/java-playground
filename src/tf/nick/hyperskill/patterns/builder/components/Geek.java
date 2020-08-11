package tf.nick.hyperskill.patterns.builder.components;

import java.util.List;

/**
 * ConcreteComponent - Geek.
 **/
public class Geek {
    private final String type;
    private final List<String> languages;
    private final int experience;

    Geek(String type, List<String> languages, int experience) {
        this.type = type;
        this.languages = languages;
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Type : " + type + "\n" +
            "Languages : " + languages + "\n" +
            "Experience : " + experience + " years";
    }
}
