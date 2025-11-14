package com.PowerOver.PowerOver.repository;

import com.PowerOver.PowerOver.model.ItemSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemSaleRepository extends JpaRepository<ItemSale, Long> {

}
