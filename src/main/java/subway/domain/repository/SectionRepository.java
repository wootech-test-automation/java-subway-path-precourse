package subway.domain.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.domain.type.Section;

public class SectionRepository {
    private static final List<Section> sections = new ArrayList<>();

    public static List<Section> sections() {
        return Collections.unmodifiableList(sections);
    }

    public static void addSection(Section section) {
        sections.add(section);
    }

    public static boolean deleteSectionByName(Section section) {
        return sections.removeIf(line -> line.equals(section));
    }

    public static void deleteAll() {
        sections.clear();
    }
}
