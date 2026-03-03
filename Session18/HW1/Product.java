import java.sql.Date;

public class Product {
    private int id;
    private String name;
    private float price;
    private String title;
    private Date created;
    private String catalog;
    private boolean status;

    public Product() {}
    public Product(int id, String name, float price, String title, Date created, String catalog, boolean status) {
        this.id = id; this.name = name; this.price = price;
        this.title = title; this.created = created;
        this.catalog = catalog; this.status = status;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public float getPrice() { return price; }
    public String getTitle() { return title; }
    public Date getCreated() { return created; }
    public String getCatalog() { return catalog; }
    public boolean isStatus() { return status; }
}