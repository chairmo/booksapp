package com.chairmo.service.jpaServices;

import com.chairmo.model.*;
import com.chairmo.service.CustomerService;
import com.chairmo.service.OrderService;
import com.chairmo.service.ProductService;
import com.chairmo.util.OrderStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {
    private OrderService orderService;
    private CustomerService customerService;
    private ProductService productService;
    @Autowired
    public void setProductService(ProductService productService) { this.productService = productService; }
    @Autowired
    public void setCustomerService(CustomerService customerService) { this.customerService = customerService; }
    @Autowired
    public void setOrderService(OrderService orderService) { this.orderService = orderService; }

    @Test
    public void saveOrUpdate() {
        loadCustomer();
        loadProducts();

        List<Customer> customers = (List<Customer>) customerService.listAll();
        List<Product> products = (List<Product>) productService.listAll();

        Order order = new Order();
        order.setOrderStatus(OrderStatus.SHIPPED);

        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setQuantity(2);
        orderDetails.setProduct(products.get(0));

        order.addOrderDetails(orderDetails);
        order.setCustomer(customers.get(1));

       Order savedOrder = orderService.saveOrUpdate(order);


        assert savedOrder.getId() != null;
        assert savedOrder.getOrderDetails().size() == 1;
    }

    private void loadCustomer(){
        Customer customer = new Customer();
        customer.setEmail("jayjay@gmail.com");
        customer.setFirstName("james");
        customer.setLastName("jatau");
        customer.setPhoneNumber("09038499721");
        customer.setBillingAddress(new Address());
        customer.getBillingAddress().setCity("kuje");
        customer.getBillingAddress().setCountry("naija");
        customer.getBillingAddress().setState("abj");
        customerService.saveOrUpdate(customer);

        Customer customer1 = new Customer();
        customer1.setEmail("kanas@gmail.com");
        customer1.setFirstName("johny");
        customer1.setLastName("drill");
        customer1.setPhoneNumber("0908499721");
        customer1.setBillingAddress(new Address());
        customer1.getBillingAddress().setCity("kwalije");
        customer1.getBillingAddress().setCountry("naija");
        customer1.getBillingAddress().setState("abuja");
        customerService.saveOrUpdate(customer1);
    }
    private void loadProducts() {
        Product product = new Product();
        product.setDescription("food items");
        product.setPrice(BigDecimal.valueOf(29));
        product.setImageUrl("http://images_good");
        productService.saveOrUpdate(product);

        Product product1 = new Product();
        product1.setDescription("i love books items");
        product1.setPrice(BigDecimal.valueOf(49));
        product1.setImageUrl("http://images_of_books");
        productService.saveOrUpdate(product1);

        Product product2 = new Product();
        product2.setDescription("anything for sale items");
        product2.setPrice(BigDecimal.valueOf(39.5));
        product2.setImageUrl("http://images_anything");
    }
}