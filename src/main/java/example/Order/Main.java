package example.Order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class);
        /*Category category1 = Category.builder().cno(1).cname("햄버거").build();
        Category category2 = Category.builder().cno(2).cname("사이드").build();

        Product product1 = Product.builder().pno(1).pname("불고기버거").build();
        Product product2 = Product.builder().pno(2).pname("치킨버거").build();
        Product product3 = Product.builder().pno(3).pname("감자튀김").build();
        Product product4 = Product.builder().pno(4).pname("치즈스틱").build();

        Order order1 = Order.builder().ono(1).oprice(5000).build();
        Order order2 = Order.builder().ono(2).oprice(3000).build();

        category1.getProductList().add(product1);
        category1.getProductList().add(product2);
        category2.getProductList().add(product3);
        category2.getProductList().add(product4);

        product1.setCategory(category1);
        product2.setCategory(category1);
        product3.setCategory(category2);
        product4.setCategory(category2);

        product1.setOrder(order1);
        product3.setOrder(order2);

        order1.setProduct(product1);
        order2.setProduct(product3);


        System.out.println("category1 : " + category1 );
        System.out.println("category2 : " + category2 );

        System.out.println( "product1 : " + product1 );
        System.out.println( "product3 : " + product3 );

        System.out.println( "order1 : " + order1 );
        System.out.println( "order2 : " + order2 );
*/
    }
}
