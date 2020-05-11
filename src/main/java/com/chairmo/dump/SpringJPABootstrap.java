package com.chairmo.dump;


import com.chairmo.model.*;
import com.chairmo.model.role.Role;
import com.chairmo.repositories.services.OrderService;
import com.chairmo.repositories.services.ProductService;
import com.chairmo.repositories.security.RoleService;
import com.chairmo.repositories.services.UserService;
import com.chairmo.util.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;


@Component
@Profile("jpaDao")
public class SpringJPABootstrap implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    public SpringJPABootstrap(ProductService productService, UserService userService,
                              RoleService roleService, OrderService orderService) {
        this.productService = productService;
        this.userService = userService;
        this.roleService = roleService;
        this.orderService = orderService;
    }

    private ProductService productService;
    private UserService userService;
    private RoleService roleService;
    private OrderService orderService;



    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        createRoles();
        loadProducts();
        loadUsersAndCustomers();
        loadCarts();
        loadOrderHistory();
       assignDefaultRoleToUsers();
    }

    private void assignDefaultRoleToUsers() {
        List<User> userList =  userService.findAll();
        List<Role> roleList =  roleService.findAll();

        roleList.forEach(role -> {
            if (role.getRole().equalsIgnoreCase("customer"))
                userList.forEach(user -> {
                    user.addRole(role);
                    userService.save(user);
                });
        });
    }

    private void createRoles() {

            Role role = new Role();
            role.setRole("BASICS");
            roleService.save(role);

            Role role1 = new Role();
            role1.setRole("Admin");
            roleService.save(role1);

            Role role2 = new Role();
            role2.setRole("classA");
            roleService.save(role2);
    }

    private void loadOrderHistory() {
        List<User> userList =  userService.findAll();
        List<Product> productList =  productService.findAll();

        userList.forEach(user -> {
            Order order = new Order();
            order.setCustomer(user.getCustomer());
            order.setOrderStatus(OrderStatus.SHIPPED);
            order.updateTimeStamp();

            productList.forEach(product -> {
                OrderDetails orderDetails = new OrderDetails();
                orderDetails.setProduct(product);
                orderDetails.setQuantity(2);

                order.addOrderDetails(orderDetails);

                orderService.save(order);
            });
        });
    }

    private void loadCarts() {
        List<User> userList =  userService.findAll();
        List<Product> productList =  productService.findAll();

        userList.forEach(user -> {
            user.setCart(new Cart());
            CartDetails cartDetails = new CartDetails();
            cartDetails.setProduct(productList.get(0));
            cartDetails.setQuantity(2);
            user.getCart().addCartDetails(cartDetails);

            userService.save(user);
        });
    }

    private void loadUsersAndCustomers() {
        User user = new User();
        Customer customer = new Customer();
        customer.setEmail("jayjay@gmail.com");
        customer.setFirstName("james");
        customer.setLastName("jatau");
        customer.setPhoneNumber("09038499721");
        customer.setBillingAddress(new Address());
        customer.getBillingAddress().setCity("kuje");
        customer.getBillingAddress().setCountry("naija");
        customer.getBillingAddress().setState("abj");
        customer.updateTimeStamp();

        user.setUsername("jayboi");
        user.setPassword("jayjay");
        user.updateTimeStamp();
        user.setCustomer(customer);
        userService.save(user);

        User user1 = new User();

        Customer customer1 = new Customer();
        customer1.setEmail("kanas@gmail.com");
        customer1.setFirstName("johny");
        customer1.setLastName("drill");
        customer1.setPhoneNumber("0908499721");
        customer1.setBillingAddress(new Address());
        customer1.getBillingAddress().setCity("kwalije");
        customer1.getBillingAddress().setCountry("naija");
        customer1.getBillingAddress().setState("abuja");
        customer1.updateTimeStamp();

        user1.setUsername("jay");
        user1.setPassword("jayjay");
        user1.updateTimeStamp();
        user1.setCustomer(customer1);
        userService.save(user1);
    }

    private void loadProducts() {
        Product product = new Product();
        product.setDescription("food items");
        product.setPrice(BigDecimal.valueOf(29));
        product.setImageUrl("http://images_good");
        productService.save(product);

        Product product1 = new Product();
        product1.setDescription("i love books items");
        product1.setPrice(BigDecimal.valueOf(49));
        product1.setImageUrl("http://images_of_books");
        productService.save(product1);

        Product product2 = new Product();
        product2.setDescription("anything for sale items");
        product2.setPrice(BigDecimal.valueOf(39.5));
        product2.setImageUrl("http://images_anything");
    }

}
