package com.valtech.training.firstspringboot.service;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.firstspringboot.entities.Order;
import com.valtech.training.firstspringboot.repositories.OrderRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepo orderRepo;
	
	@PostConstruct
	public void populateOrders() {
		orderRepo.save(new Order("Macbook", 25, "For all emp", LocalDate.of(2023, 11, 8)));
		orderRepo.save(new Order("iPod", 26, "For all emp", LocalDate.of(2023, 11, 8)));
		orderRepo.save(new Order("iWatch", 25, "For all emp", LocalDate.of(2023, 11, 8)));
	}
	

	@Override
	public Order createOrder(Order order) {
		System.out.println(orderRepo.getClass().getName());
		return orderRepo.save(order);
	}
	

	@Override
	public Order updateOrder(Order order) {
		return orderRepo.save(order);
	}

	@Override
	public Order getOrder(long orderId) {
		return orderRepo.getReferenceById(orderId);
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}

}
