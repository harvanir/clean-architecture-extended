package org.harvanir.item.core.usecase.create;

import org.harvanir.item.core.entity.create.CreateItemRequest;
import org.harvanir.item.core.entity.common.ItemResponse;
import org.harvanir.item.core.gateway.ItemGateway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * @author Harvan Irsyadi
 */
@ExtendWith(MockitoExtension.class)
class CreateItemUseCaseTest {

    private CreateItemUseCase useCase;

    @Mock
    private CreateItemOutputBoundary presenter;

    @Mock
    private ItemGateway itemGateway;

    @BeforeEach
    void beforeEach() {
        useCase = new CreateItemUseCase(itemGateway);
    }

    @AfterEach
    void afterEach() {
        verifyNoMoreInteractions(presenter, itemGateway);
    }

    @Test
    void givenInValidParameterWhenExecuteThenFailed() {
        assertThrows(InvalidRequestException.class, () -> useCase.execute(null, presenter));
    }

    @Test
    void givenInValidPriceWhenExecuteThenFailed() {
        CreateItemRequest request = new CreateItemRequest();
        request.setName("Name");

        assertThrows(InvalidRequestException.class, () -> useCase.execute(request, presenter));
    }

    @Test
    void givenInValidNameWhenExecuteThenFailed() {
        CreateItemRequest request = new CreateItemRequest();
        request.setPrice(BigDecimal.valueOf(15));

        assertThrows(InvalidRequestException.class, () -> useCase.execute(request, presenter));
    }

    @Test
    void givenValidParameterWhenExecuteThenReturnGeneratedId() {
        when(itemGateway.save(any(CreateItemRequest.class))).thenAnswer(invocation -> {
            ItemResponse response = new ItemResponse();
            response.setId(10);

            return response;
        });

        CreateItemRequest request = new CreateItemRequest();
        request.setName("Name");
        request.setPrice(BigDecimal.valueOf(15));

        useCase.execute(request, presenter);

        ArgumentCaptor<ItemResponse> captor = ArgumentCaptor.forClass(ItemResponse.class);
        verify(presenter, times(1)).present(captor.capture());
        verify(itemGateway, times(1)).save(any(CreateItemRequest.class));
        assertNotNull(captor.getValue());
        assertNotNull(captor.getValue().getId());
    }
}
