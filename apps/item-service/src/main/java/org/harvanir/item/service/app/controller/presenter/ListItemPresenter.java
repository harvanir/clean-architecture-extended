package org.harvanir.item.service.app.controller.presenter;

import org.harvanir.item.core.entity.common.ItemResponse;
import org.harvanir.item.core.usecase.list.ListItemOutboundBoundary;
import org.harvanir.item.service.entity.common.ItemServiceResponse;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Harvan Irsyadi
 */
public class ListItemPresenter implements ListItemOutboundBoundary {

    private List<ItemServiceResponse> itemServiceResponses;

    public List<ItemServiceResponse> getItemServiceResponses() {
        return itemServiceResponses;
    }

    @Override
    public void present(List<ItemResponse> responses) {
        itemServiceResponses = responses.stream()
                .map(response -> ItemServiceResponse.builder()
                        .id(response.getId())
                        .name(response.getName())
                        .price(response.getPrice())
                        .build())
                .collect(Collectors.toList());
    }
}