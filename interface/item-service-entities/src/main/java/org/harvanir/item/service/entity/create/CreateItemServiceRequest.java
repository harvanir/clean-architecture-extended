package org.harvanir.item.service.entity.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author Harvan Irsyadi
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateItemServiceRequest {

    private String name;

    private BigDecimal price;
}
