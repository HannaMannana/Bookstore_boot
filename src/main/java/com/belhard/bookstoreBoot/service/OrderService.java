package com.belhard.bookstoreBoot.service;
import com.belhard.bookstoreBoot.service.dto.OrderDto;

import java.util.List;

public interface OrderService {

    OrderDto getById(Long id);

    List<OrderDto> getAll();

    OrderDto create(OrderDto dto);

    OrderDto update( OrderDto dto);

    boolean delete(Long id);
}
