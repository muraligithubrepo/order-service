package org.order.service.repo;

import org.order.service.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderServiceRepo extends JpaRepository<Order,Long> {

}
