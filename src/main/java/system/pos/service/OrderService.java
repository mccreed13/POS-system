package system.pos.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import system.pos.bill.BillFormer;
import system.pos.command.BillSender;
import system.pos.command.SendBillType;
import system.pos.entity.Order;
import system.pos.entity.OrderMenuItems;
import system.pos.repository.OrderRepository;
import system.pos.strategies.PayStrategy;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class OrderService {
    public double getFullCostOrder(Long id){
        Order order = getById(id);
        return order.getFullCost();
    }
    private final OrderRepository orderRepository;
    private final UserService userService;

    private final Map<SendBillType, BillSender> map;

    public OrderService(OrderRepository orderRepository, UserService userService, List<BillSender> senderList) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.map = senderList.stream().collect(Collectors.toMap(BillSender::getType, Function.identity()));
    }

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

    public void sendBill(SendBillType sendBillType, Long id){
        BillSender billSender = map.get(sendBillType);
        Set<OrderMenuItems> orderMenuItems = orderRepository.findById(id).get().getOrderMenuItems();
        String bill = BillFormer.form(orderMenuItems);
        billSender.send(bill);
    }
}
