package org.harvanir.item.core.usecase.create;

import org.harvanir.item.core.entity.create.CreateItemRequest;
import org.harvanir.item.core.entity.common.ItemResponse;
import org.harvanir.item.core.gateway.ItemGateway;

/**
 * @author Harvan Irsyadi
 */
public class CreateItemUseCase implements CreateItemInputBoundary {

    private final ItemGateway itemGateway;

    public CreateItemUseCase(ItemGateway itemGateway) {
        this.itemGateway = itemGateway;
    }

    @Override
    public void execute(CreateItemRequest request, CreateItemOutputBoundary presenter) {
        if (request == null) {
            throw new InvalidRequestException("Request cannot be null");
        }
        if (request.getPrice() == null) {
            throw new InvalidRequestException("Price cannot be null");
        }
        if (request.getName() == null) {
            throw new InvalidRequestException("Name cannot be null");
        }

        ItemResponse response = itemGateway.save(request);
        presenter.present(response);
    }
}
