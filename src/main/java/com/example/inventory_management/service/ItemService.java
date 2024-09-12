package com.example.inventorymanagement.service;

import com.example.inventorymanagement.dto.ItemDto;
import com.example.inventorymanagement.model.Item;

import java.util.List;

public interface ItemService {
    Item createItem(ItemDto itemDto);
    List<Item> getAllItems();
    Item getItemById(Long id);
    Item updateItem(Long id, ItemDto itemDto);
    void deleteItem(Long id);
}
