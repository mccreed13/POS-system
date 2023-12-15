package system.pos.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import system.pos.entity.Order;
import system.pos.entity.OrderMenuItems;
import system.pos.repository.OrderRepository;
import system.pos.strategies.PayStrategy;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserService userService;

    public List<Order> listAll(){
       return orderRepository.findAll();
    }

    public Order getById(Long id){
        Order order = orderRepository.findById(id).orElseThrow();
        double sum = 0;
        for (OrderMenuItems o: order.getOrderMenuItems()) {
            sum += o.getTotalPrice();
        }
        order.setBill(sum);
        return order;
    }

    public void pay(PayStrategy strategy, Order order){
         if(strategy.pay(order.getBill())){
             order.setPayed(true);
             orderRepository.save(order);
         }
    }

}
