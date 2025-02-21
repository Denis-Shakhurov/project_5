package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.order.OrderCreateDTO;
import org.example.dto.order.OrderDTO;
import org.example.dto.order.OrderUpdateDTO;
import org.example.exception.ResourceNotFoundException;
import org.example.mapper.OrderMapper;
import org.example.model.Order;
import org.example.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public List<OrderDTO> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::map)
                .toList();
    }

    public OrderDTO findById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + id));
        return orderMapper.map(order);
    }

    public List<OrderDTO> findByUserId(Long userId) {
        return orderRepository.findByUserId(userId)
                .stream()
                .map(orderMapper::map)
                .toList();
    }

    public OrderDTO create(OrderCreateDTO orderDTO) {
        Order order = orderMapper.map(orderDTO);
        order = orderRepository.save(order);
        return orderMapper.map(order);
    }

    public OrderDTO update(OrderUpdateDTO orderDTO, Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + id));
        orderMapper.update(orderDTO, order);
        orderRepository.save(order);
        return orderMapper.map(order);
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
