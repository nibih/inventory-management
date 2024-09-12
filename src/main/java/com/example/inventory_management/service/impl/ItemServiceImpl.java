package com.example.inventorymanagement.service.impl;

import com.example.inventorymanagement.dto.ItemDto;
import com.example.inventorymanagement.model.Item;
import com.example.inventorymanagement.repository.ItemRepository;
import com.example.inventorymanagement.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    @Autowired
    private final ItemRepository itemRepository;

    @Override
    public Item createItem(ItemDto itemDto) {
        Item item = Item.builder()
                .namaBarang(itemDto.getNamaBarang())
                .jumlahStokBarang(itemDto.getJumlahStokBarang())
                .nomorSeriBarang(itemDto.getNomorSeriBarang())
                .additionalInfo(itemDto.getAdditionalInfo())
                .gambarBarang(itemDto.getGambarBarang())
                .createdAt(LocalDateTime.now())
                .createdBy(itemDto.getCreatedBy())
                .updatedAt(LocalDateTime.now())
                .updatedBy(itemDto.getUpdatedBy())
                .build();
        return itemRepository.save(item);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
    }

    @Override
    public Item updateItem(Long id, ItemDto itemDto) {
        Optional<Item> itemOptional = itemRepository.findById(id);
        if (itemOptional.isPresent()) {
            Item item = itemOptional.get();
            item.setNamaBarang(itemDto.getNamaBarang());
            item.setJumlahStokBarang(itemDto.getJumlahStokBarang());
            item.setNomorSeriBarang(itemDto.getNomorSeriBarang());
            item.setAdditionalInfo(itemDto.getAdditionalInfo());
            item.setGambarBarang(itemDto.getGambarBarang());
            item.setUpdatedAt(LocalDateTime.now());
            item.setUpdatedBy(itemDto.getUpdatedBy());
            return itemRepository.save(item);
        } else {
            throw new RuntimeException("Item not found");
        }
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
