package org.harvanir.item.core.usecase.list;

import org.harvanir.item.core.gateway.ItemGateway;

/**
 * @author Harvan Irsyadi
 */
public class ListItemUseCase implements ListItemInputBoundary {

    private final ItemGateway itemGateway;

    public ListItemUseCase(ItemGateway itemGateway) {
        this.itemGateway = itemGateway;
    }

    @Override
    public void execute(ListItemOutboundBoundary presenter) {
        presenter.present(itemGateway.findAll());
    }
}