import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.File;

//@JsonDeserialize
public class Output {
    private  String productName;
    private  Integer retailPrice;
    private Integer discountedPrice;
    private String description;
    private String brandName;

    private Output(String productName, Integer retailPrice, Integer discountedPrice, String description, String brandName) {
        this.productName = productName;
        this.retailPrice = retailPrice;
        this.discountedPrice = discountedPrice;
        this.description = description;
        this.brandName = brandName;
    }

    public static void writeJson() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Output output = new Output("Shirt", 950, 450, "White t-shirt with basic design", "Gucci");
        objectMapper.writeValue(new File("object.json"), output);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Integer retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Integer getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(Integer discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
