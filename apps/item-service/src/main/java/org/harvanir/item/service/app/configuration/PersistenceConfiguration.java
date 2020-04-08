package org.harvanir.item.service.app.configuration;

import org.harvanir.item.core.gateway.ItemGateway;
import org.harvanir.item.gateway.jpa.JpaRepositoryMarker;
import org.harvanir.item.gateway.jpa.entity.EntityMarker;
import org.harvanir.item.gateway.jpa.provider.JpaItemGateway;
import org.harvanir.item.gateway.jpa.repository.ItemRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Harvan Irsyadi
 */
@EnableJpaRepositories(basePackageClasses = JpaRepositoryMarker.class)
@EntityScan(basePackageClasses = EntityMarker.class)
@Configuration(proxyBeanMethods = false)
public class PersistenceConfiguration {

    @Bean
    public ItemGateway itemGateway(ItemRepository itemRepository) {
        return new JpaItemGateway(itemRepository);
    }
}
