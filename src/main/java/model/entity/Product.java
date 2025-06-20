package model.entity;

public class Product {
    private long id;
    private long code;
    private String name;
    private String description;
    private float purchasePrice;
    private float sellPrice;
    private float suggestedPrice;
    private String category;

    public Product() {}

    public Product(long code, String name, String description, float purchasePrice, float sellPrice, float suggestedPrice, String category) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.purchasePrice = purchasePrice;
        this.sellPrice = sellPrice;
        this.suggestedPrice = suggestedPrice;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public float getSuggestedPrice() {
        return suggestedPrice;
    }

    public void setSuggestedPrice(float suggestedPrice) {
        this.suggestedPrice = suggestedPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Producto: " + name;
    }
}
