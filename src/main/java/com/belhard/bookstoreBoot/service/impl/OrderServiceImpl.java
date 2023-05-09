package com.belhard.bookstoreBoot.service.impl;


import com.belhard.bookstoreBoot.data.entity.Order;
import com.belhard.bookstoreBoot.data.repository.OrderRepository;
import com.belhard.bookstoreBoot.service.OrderService;
import com.belhard.bookstoreBoot.service.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private OrderDto toDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setUser(order.getUser());
        orderDto.setDetails(order.getDetails());
        orderDto.setStatus(order.getStatus());
        orderDto.setTotalCost(order.getTotalCost());
        return orderDto;
    }

    private Order toEntity(OrderDto orderDto) {
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setUser(orderDto.getUser());
        order.setDetails(orderDto.getDetails());
        order.setStatus(orderDto.getStatus());
        order.setTotalCost(orderDto.getTotalCost());
        return order;
    }

    @Override
    public OrderDto getById(Long id) {
        return toDto(orderRepository.findById(id).orElseThrow(()-> new RuntimeException("None order with id" + id)));
    }

    @Override
    public List<OrderDto> getAll() {
        List<OrderDto> dtos = orderRepository.findAll().stream().map(this::toDto).toList();
        return dtos;
    }

    @Override
    public OrderDto create(OrderDto dto) {
        dto.setStatus(Order.Status.PENDING);
        Optional<Order> optionalOrder = orderRepository.create(toEntity(dto));
        Order order = optionalOrder.orElseThrow(() -> new RuntimeException("Order didn't create"));
        log.debug("create: new Order ={}", dto);
        return toDto(order);

    }

    @Override
    public OrderDto update(OrderDto dto) {
        Optional<Order> opOrder = orderRepository.update(toEntity(dto));
        Order order = opOrder.orElseThrow(() -> new RuntimeException("Id is required"));
        log.debug("update id ={}",dto.getId());
        return toDto(order);
    }

    @Override
    public boolean delete(Long id) {
        boolean isDeleted = orderRepository.delete(id);
        if (!isDeleted) {
            return false;
        } else {
            log.debug("delete by id ={}",id);
            return true;
        }
    }
}
