package org.harvanir.item.core.entity.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author Harvan Irsyadi
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateItemRequest {

    private String name;

    private BigDecimal price;
}
