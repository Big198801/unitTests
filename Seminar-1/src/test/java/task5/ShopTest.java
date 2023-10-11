package task5;

/*
1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ShopTest {
    private Shop shop;
    private List<Product> sortedProductList = new ArrayList<>();
    private Product mostExpensiveProduct;

    // Формируем состав продуктов, чтобы потом на нём производить тесты
    @BeforeEach
    void setUp() {
        List<Product> productList = new ArrayList<>();
        Product productA = new Product();
        productA.setTitle("Колбаса");
        productA.setCost(100);

        Product productB = new Product();
        productB.setTitle("Молоко");
        productB.setCost(80);

        Product productC = new Product();
        productC.setTitle("Творог");
        productC.setCost(90);

        productList.add(productA);
        productList.add(productB);
        productList.add(productC);

        shop = new Shop();

        shop.setProducts(productList);

        sortedProductList.add(productB);
        sortedProductList.add(productC);
        sortedProductList.add(productA);

        mostExpensiveProduct = productA;
    }

    @Test
    @DisplayName("Магазин хранит верное количество продуктов")
    void testProductList() {
        assertThat(shop.getProducts().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("Верность сортировки продуктов по цене")
    void testSortProductList() {
        assertThat(shop.sortProductsByPrice()).isEqualTo(sortedProductList);
    }

    @Test
    @DisplayName("Верность выбора самого дорогого продукта")
    void testMostExpensiveProduct() {
        assertThat(shop.getMostExpensiveProduct()).isEqualTo(mostExpensiveProduct);
    }
}
