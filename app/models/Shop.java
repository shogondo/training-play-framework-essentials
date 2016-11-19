package models;

import java.util.List;
import models.Item;

public interface Shop {
    List<Item> list();

    Item create(String name, Double price);

    Item get(Long id);

    Item update(Long id, String name, Double price);

    Boolean delete(Long id);
}
