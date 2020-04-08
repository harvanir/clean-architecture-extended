package org.harvanir.item.core.gateway;

import org.harvanir.item.core.entity.common.ItemResponse;
import org.harvanir.item.core.entity.create.CreateItemRequest;

import java.util.List;

/**
 * @author Harvan Irsyadi
 */
public interface ItemGateway {

    ItemResponse save(CreateItemRequest request);

    List<ItemResponse> findAll();
}
