package homework.items;

import lombok.NoArgsConstructor;

/**
 * this class describes how an item should look like
 */
@NoArgsConstructor
public class Item {
    private String name;
    private String title;
    private String location;

    public Item(String name, String title, String location) {
        this.name = name;
        this.title = title;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
