package models;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import models.Shop;

public class OnMemoryShop implements Shop {
    private final SortedMap<Long, Item> items = new ConcurrentSkipListMap<>();

    private final AtomicLong seq = new AtomicLong();
    
    public OnMemoryShop() {
    }

    @Override
    public List<Item> list() {
        return new ArrayList<>(items.values());
    }

    @Override
    public Item create(String name, Double price) {
        Long id = seq.incrementAndGet();
        Item item = new Item(id, name, price);
        items.put(id, item);
        return item;
    }

    @Override
    public Item get(Long id) {
        return items.get(id);
    }

    @Override
    public synchronized Item update(Long id, String name, Double price) {
        Item item = items.get(id);
        if (item != null) {
            Item updated = new Item(id, name, price);
            items.put(id, updated);
            return updated;
        }
        else {
            return null;
        }
    }

    @Override
    public Boolean delete(Long id) {
        return items.remove(id) != null;
    }
}
