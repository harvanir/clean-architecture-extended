package org.harvanir.item.core.usecase.create;

import org.harvanir.item.core.entity.common.ItemResponse;

/**
 * @author Harvan Irsyadi
 */
public interface CreateItemOutputBoundary {

    void present(ItemResponse response);
}
