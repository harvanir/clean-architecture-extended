package org.harvanir.item.gateway.jpa.provider;

import org.harvanir.item.core.entity.common.ItemResponse;
import org.harvanir.item.core.entity.create.CreateItemRequest;
import org.harvanir.item.core.gateway.ItemGateway;
import org.harvanir.item.gateway.jpa.entity.Item;
import org.harvanir.item.gateway.jpa.repository.ItemRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Harvan Irsyadi
 */
public class JpaItemGateway implements ItemGateway {

    private final ItemRepository itemRepository;

    public JpaItemGateway(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public ItemResponse save(CreateItemRequest request) {
        Item item = new Item();
        item.setName(request.getName());
        item.setPrice(request.getPrice());

        itemRepository.save(item);

        return ItemResponse.builder()
                .id(item.getId())
                .name(item.getName())
                .price(item.getPrice())
                .build();
    }

    @Override
    public List<ItemResponse> findAll() {
        return itemRepository.findAll().stream()
                .map(item -> ItemResponse.builder()
                        .id(item.getId())
                        .name(item.getName())
                        .price(item.getPrice())
                        .build())
                .collect(Collectors.toList());
    }
}
