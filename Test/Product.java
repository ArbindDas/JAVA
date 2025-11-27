package Test;

public sealed class Product permits ProductService {

    private Integer id;
    private String productName;
    private Double productPrice;
    public Product(){}

    public Product(Integer id, String productName, Double productPrice) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

   @Override
public String toString() {
    return "Product{id=" + id + ", productName='" + productName + "', productPrice=" + productPrice + "}";
}

}
