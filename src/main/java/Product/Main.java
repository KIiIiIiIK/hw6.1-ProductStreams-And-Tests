package Product;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        System.out.print("\n");

        Product coconutMilk = new Product("Aroy-D ",190.0," 1L ", Category.MILK);
        Product soyaMilk = new Product("Alpro ", 80.0, " 1L ", Category.MILK);
        Product sparklingWine = new Product("Veuve Clicquot ", 1090.0, " 0.375 ", Category.WINE);
        Product whiteWine = new Product("Marlborough Sun ", 380.0, " 0.75 ", Category.WINE);
        Product groundCoffee = new Product("Illy ", 222.0, " 0.25KG ", Category.COFFEE);
        Product instantCoffee = new Product("Jacobs ", 125.0, " 0.19KG ", Category.COFFEE);

        List<Product> allProducts = Arrays.asList
                (coconutMilk, soyaMilk,
                sparklingWine, whiteWine,
                groundCoffee, instantCoffee);

        List<Product> milk = allProducts.stream().filter(c -> c.category.equals(Category.MILK)).toList();

        List<Product> wine = allProducts.stream().filter(c -> c.category.equals(Category.WINE)).toList();

        List<Product> coffee = allProducts.stream().filter(c -> c.category.equals(Category.COFFEE)).toList();

        Stream<Product> priceIsLessThan500 = allProducts.stream().filter(l -> l.price < 500);
        long count1 = priceIsLessThan500.count();

        Stream<Product> nameHasParticleRo = allProducts.stream().filter(p -> p.name.matches("(.*)ro(.*)"));
        long count2 = nameHasParticleRo.count();

        List<String> alphabeticOrder = allProducts.stream().map((n -> n.name)).sorted(Comparator.naturalOrder()).toList();

        List<Product> priceIncreasing = allProducts.stream().sorted(Comparator.comparing(Product::getPrice)).toList();

        System.out.println("Products list: " +allProducts);
        System.out.print("\n");
        System.out.println("milk: " + milk);
        System.out.print("\n");
        System.out.println("wine: " + wine);
        System.out.print("\n");
        System.out.println("coffee: " + coffee);
        System.out.print("\n");
        System.out.println("Quantity of products with the price 500>: " + count1);
        System.out.print("\n");
        System.out.println("Name has particle 'ro': " + count2);
        System.out.print("\n");
        System.out.println("Products in alphabetic order: " + alphabeticOrder);
        System.out.print("\n");
        System.out.println("Products sorted by price increasing: " + priceIncreasing);
    }
}
