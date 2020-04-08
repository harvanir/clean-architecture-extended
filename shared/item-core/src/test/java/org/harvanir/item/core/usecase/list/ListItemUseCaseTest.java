package org.harvanir.item.core.usecase.list;

import org.harvanir.item.core.entity.common.ItemResponse;
import org.harvanir.item.core.gateway.ItemGateway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * @author Harvan Irsyadi
 */
@ExtendWith(MockitoExtension.class)
class ListItemUseCaseTest {

    private ListItemUseCase useCase;

    @Mock
    private ItemGateway itemGateway;

    @Mock
    private ListItemOutboundBoundary presenter;

    @BeforeEach
    void beforeEach() {
        useCase = new ListItemUseCase(itemGateway);
    }

    @AfterEach
    void afterEach() {
        verifyNoMoreInteractions(itemGateway);
    }

    @Test
    void shouldReturnData() {
        Mockito.when(itemGateway.findAll()).thenAnswer(invocation -> {
            List<ItemResponse> responses = new ArrayList<>();

            responses.add(ItemResponse.builder()
                    .id(1)
                    .name("Name1")
                    .price(BigDecimal.valueOf(11))
                    .build());
            responses.add(ItemResponse.builder()
                    .id(2)
                    .name("Name2")
                    .price(BigDecimal.valueOf(12))
                    .build());

            return responses;
        });

        useCase.execute(presenter);

        @SuppressWarnings("unchecked")
        ArgumentCaptor<List<ItemResponse>> captor = ArgumentCaptor.forClass(List.class);
        verify(presenter, times(1)).present(captor.capture());
        List<ItemResponse> responses = captor.getValue();
        assertNotNull(responses);
        assertFalse(responses.isEmpty());

        verify(itemGateway, times(1)).findAll();
    }
}
