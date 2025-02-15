package com.ait.ServiceImpl;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.model.CustomerEntity;
import com.ait.model.ProductOrderEntity;
import com.ait.pojo.Customer;
import com.ait.pojo.ProductOrder;
import com.ait.repository.CustomerRepository;
import com.ait.repository.OrderRepository;
import com.ait.service.CustomerService;

import jakarta.transaction.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;

    
    @Override
    public Customer register(Customer customer) {
        
        CustomerEntity entity = new CustomerEntity();
        
        BeanUtils.copyProperties(customer, entity);
    entity = customerRepository.save(entity);

    
        List<ProductOrderEntity> productOrders = new ArrayList<>();
        for(ProductOrder productOrders1: customer.getProductOrder()) {
        	ProductOrderEntity order = new ProductOrderEntity();
            order.setDescription(productOrders1.getDescription());
            order.setProductName(productOrders1.getProductName());
            order.setCustomer(entity); 
            productOrders.add(order);
        }
      
        orderRepository.saveAll(productOrders);
      
        //orderRepository.saveAll(productOrders);

        
        BeanUtils.copyProperties(entity, customer);
        return customer;
    }

   
    @Override
    @Transactional
    public List<Customer> getAllCustomer() {
        List<CustomerEntity> allCustomer = customerRepository.findAll();
        
        System.out.println(allCustomer);
        
        allCustomer.forEach(data ->{
        	List<ProductOrderEntity> productOrder = data.getProductOrder();
        	productOrder.forEach(System.out::println);
        	
        });
        
        
        
        List<Customer> customers = new ArrayList<>();
           
        allCustomer.forEach(data -> {
            Customer customer = new Customer();
            BeanUtils.copyProperties(data, customer);
            customers.add(customer);
        });
        
        return customers;
    }
}
