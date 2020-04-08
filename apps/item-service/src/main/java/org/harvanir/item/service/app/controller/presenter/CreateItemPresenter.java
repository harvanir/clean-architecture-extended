package org.harvanir.item.service.app.controller.presenter;

import org.harvanir.item.core.entity.common.ItemResponse;
import org.harvanir.item.core.usecase.create.CreateItemOutputBoundary;
import org.harvanir.item.service.entity.common.ItemServiceResponse;

/**
 * @author Harvan Irsyadi
 */
public class CreateItemPresenter implements CreateItemOutputBoundary {

    private ItemServiceResponse serviceResponse;

    public ItemServiceResponse getServiceResponse() {
        return serviceResponse;
    }

    @Override
    public void present(ItemResponse response) {
        serviceResponse = new ItemServiceResponse();
        serviceResponse.setId(response.getId());
        serviceResponse.setName(response.getName());
        serviceResponse.setPrice(response.getPrice());
    }
}