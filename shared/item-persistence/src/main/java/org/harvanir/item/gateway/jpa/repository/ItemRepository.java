package org.harvanir.item.gateway.jpa.repository;

import org.harvanir.item.gateway.jpa.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Harvan Irsyadi
 */
public interface ItemRepository extends JpaRepository<Item, Integer> {

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    List<Item> findAll();
}
