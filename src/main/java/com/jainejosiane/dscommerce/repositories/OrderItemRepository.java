package com.jainejosiane.dscommerce.repositories;

import com.jainejosiane.dscommerce.entities.OrderItem;
import com.jainejosiane.dscommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}