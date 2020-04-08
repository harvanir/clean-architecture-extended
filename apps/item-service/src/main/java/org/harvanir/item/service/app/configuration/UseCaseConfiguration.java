package org.harvanir.item.service.app.configuration;

import org.harvanir.item.core.gateway.ItemGateway;
import org.harvanir.item.core.usecase.create.CreateItemInputBoundary;
import org.harvanir.item.core.usecase.create.CreateItemUseCase;
import org.harvanir.item.core.usecase.list.ListItemInputBoundary;
import org.harvanir.item.core.usecase.list.ListItemUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Harvan Irsyadi
 */
@Configuration(proxyBeanMethods = false)
public class UseCaseConfiguration {

    @Bean
    public CreateItemInputBoundary createItemUseCase(ItemGateway itemGateway) {
        return new CreateItemUseCase(itemGateway);
    }

    @Bean
    public ListItemInputBoundary listItemUseCase(ItemGateway itemGateway) {
        return new ListItemUseCase(itemGateway);
    }
}
