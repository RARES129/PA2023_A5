package homework.items;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * this class describes a Catalog
 */
@NoArgsConstructor
public class Catalog {
    private String name;
    private List<Item> items;

    public Catalog(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    
    public List<Item> getItems() {
        return items;
    }

    public Item getItem(int index) {
        return this.items.get(index);
    }

    /**
     * adds an item in the items list
     *
     * @param item an item
     */
    public void add(Item item) {
        this.items.add(item);
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}
