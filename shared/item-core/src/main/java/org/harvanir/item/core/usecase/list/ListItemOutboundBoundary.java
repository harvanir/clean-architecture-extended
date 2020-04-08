package org.harvanir.item.core.usecase.list;

import org.harvanir.item.core.entity.common.ItemResponse;

import java.util.List;

/**
 * @author Harvan Irsyadi
 */
public interface ListItemOutboundBoundary {

    void present(List<ItemResponse> responses);
}