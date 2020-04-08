package org.harvanir.item.core.usecase.create;

import org.harvanir.item.core.entity.create.CreateItemRequest;

/**
 * @author Harvan Irsyadi
 */
public interface CreateItemInputBoundary {

    void execute(CreateItemRequest request, CreateItemOutputBoundary presenter);
}
