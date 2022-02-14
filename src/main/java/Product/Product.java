package Product;

import java.util.Objects;

enum Category {
    MILK,
    WINE,
    COFFEE
}

public class Product {

    String name;
    Double price;
    String description;
    Category category;

    Product(String name, Double price, String description, Category category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public String getName() {return name;}
    public Double getPrice() {return price;}
    public String getDescription() {return description;}
    public Category getCategory() {return category;}

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Product product = (Product) o;
        if (!name.equals(product.name)) {
            return false;
        }
        if (!price.equals(product.price)) {
            return false;
        }
        if (!description.equals(product.description)) {
            return false;
        }
        return category == product.category;
    }

    public int hashCode() {
        return Objects.hash(name, price, description, category);}

    public String toString() {
        return name + price + description + category;}
}
