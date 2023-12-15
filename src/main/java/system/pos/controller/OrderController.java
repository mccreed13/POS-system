package system.pos.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import system.pos.dto.MenuItemDto;
import system.pos.entity.Order;
import system.pos.service.OrderService;
import system.pos.service.UserService;
import system.pos.strategies.PayCard;
import system.pos.strategies.PayCash;
import system.pos.strategies.PayStrategy;

import java.util.List;

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;
    private static final String REDIRECT = "redirect:/orders";

    @GetMapping(value = "/")
    public String getOrders(){
        return REDIRECT;
    }

    @GetMapping(value = "")
    public ModelAndView getListOrders(){
        ModelAndView result = new ModelAndView("orders/ordersList");
        List<Order> orders = orderService.listAll();
        result.addObject("orders", orders);
        return result;
    }

    @GetMapping(value = "/{id}")
    public ModelAndView getOrder(@PathVariable Long id){
        ModelAndView result = new ModelAndView("orders/order");
        Order order = orderService.getById(id);
        result.addObject("order", order);
        return result;
    }

    @PostMapping(value = "/{id}/pay")
    public String payOrder(@PathVariable Long id,  @RequestParam(name = "strategy") String strategy){
        Order order = orderService.getById(id);
        if(strategy.equals("card")){
            System.out.println();
            orderService.pay(new PayCard(), order);
        }else {orderService.pay(new PayCash(), order);}
        return "redirect:/orders/"+id;
    }
}
