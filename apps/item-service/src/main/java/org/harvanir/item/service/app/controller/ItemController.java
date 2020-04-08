package org.harvanir.item.service.app.controller;

import org.harvanir.item.core.entity.create.CreateItemRequest;
import org.harvanir.item.core.usecase.create.CreateItemInputBoundary;
import org.harvanir.item.core.usecase.list.ListItemInputBoundary;
import org.harvanir.item.service.app.controller.presenter.CreateItemPresenter;
import org.harvanir.item.service.app.controller.presenter.ListItemPresenter;
import org.harvanir.item.service.entity.common.ItemServiceResponse;
import org.harvanir.item.service.entity.create.CreateItemServiceRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Harvan Irsyadi
 */
@RestController
@RequestMapping("/v1/items")
public class ItemController {

    private final CreateItemInputBoundary createUseCase;

    private final ListItemInputBoundary listUseCase;

    public ItemController(CreateItemInputBoundary createUseCase, ListItemInputBoundary listUseCase) {
        this.createUseCase = createUseCase;
        this.listUseCase = listUseCase;
    }

    @PostMapping
    public ItemServiceResponse create(@RequestBody CreateItemServiceRequest request) {
        CreateItemPresenter presenter = new CreateItemPresenter();
        createUseCase.execute(CreateItemRequest.builder()
                .name(request.getName())
                .price(request.getPrice())
                .build(), presenter);

        return presenter.getServiceResponse();
    }

    @GetMapping
    public List<ItemServiceResponse> get() {
        ListItemPresenter presenter = new ListItemPresenter();
        listUseCase.execute(presenter);

        return presenter.getItemServiceResponses();
    }
}
