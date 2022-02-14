package Product;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.Test;

class ProductTests {

    Product coconutMilk = new Product("Aroy-D ",190.0," 1L ", Category.MILK);
    Product soyaMilk = new Product("Alpro ", 80.0, " 1L ", Category.MILK);
    Product sparklingWine = new Product("Veuve Clicquot ", 1090.0, " 0.375 ", Category.WINE);
    Product whiteWine = new Product("Marlborough Sun ", 380.0, " 0.75 ", Category.WINE);
    Product groundCoffee = new Product("Illy ", 222.0, " 0.25KG ", Category.COFFEE);
    Product instantCoffee = new Product("Jacobs ", 125.0, " 0.19KG ", Category.COFFEE);

    @Test
    public void shouldCountSumOfProductsInTheList() {
        // given
        List<Product> allProducts = Arrays.asList
                (coconutMilk, soyaMilk,
                 sparklingWine, whiteWine,
                 groundCoffee, instantCoffee);
        // when
        long quantity = allProducts.size();
        // then
        assertThat(quantity).isEqualTo(6L);
    }

    @Test
    public void shouldSortByCategory() {
        // given
        List<Product> allProducts = Arrays.asList
                (coconutMilk, soyaMilk,
                        sparklingWine, whiteWine,
                        groundCoffee, instantCoffee);
        // when
        Map<Category, List<Product>> productsByCategory = allProducts.stream().collect(groupingBy(Product::getCategory));
        // then
        assertThat(productsByCategory.get(Category.MILK).size()).isEqualTo(2);
        assertThat(productsByCategory.get(Category.WINE).size()).isEqualTo(2);
        assertThat(productsByCategory.get(Category.COFFEE).size()).isEqualTo(2);
    }

    @Test
    public void shouldBe5ProductsWithThePriceLessThan500() {
        // given
        List<Product> allProducts = Arrays.asList
                (coconutMilk, soyaMilk,
                 sparklingWine, whiteWine,
                 groundCoffee, instantCoffee);
        // when
        Stream<Product> priceIsLessThan500 = allProducts.stream().filter(l -> l.price < 500);
        long count1 = priceIsLessThan500.count();
        // then
        assertThat(count1).isEqualTo(5L);
    }

    @Test
    public void shouldBe3ProductsWithTheParticleRo() {
        // given
        List<Product> allProducts = Arrays.asList
                (coconutMilk, soyaMilk,
                 sparklingWine, whiteWine,
                 groundCoffee, instantCoffee);
        // when
        Stream<Product> nameHasParticleRo = allProducts.stream().filter(p -> p.name.matches("(.*)ro(.*)"));
        long count2 = nameHasParticleRo.count();
        // then
        assertThat(count2).isEqualTo(3L);
    }
}