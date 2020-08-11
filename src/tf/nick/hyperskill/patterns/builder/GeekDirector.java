package tf.nick.hyperskill.patterns.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Builder Director.
 */
class GeekDirector {
    void buildAdmin(Builder builder) {
        builder.setType("Admin");
        ArrayList<String> languages = new ArrayList<>(List.of("Perl", "PowerShell"));
        builder.setLanguages(languages);
        builder.setExperience(10);
    }

    void buildRockstar(Builder builder) {
        builder.setType("Rockstar");
        ArrayList<String> languages = new ArrayList<>(
            List.of("Java", "Kotlin", "Scala", "Angular"));
        builder.setLanguages(languages);
        builder.setExperience(20);
    }

    void buildBackend(Builder builder) {
        builder.setType("Backend");
        ArrayList<String> languages = new ArrayList<>(List.of("Python", "PHP"));
        builder.setLanguages(languages);
        builder.setExperience(5);
    }
}
