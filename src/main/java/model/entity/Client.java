package model.entity;

public class Client {
    private long id;
    private String name;
    private long dni;
    private long cuit;
    private long cuil;
    private String category;
    private String description;
    private String email;
    private long phoneNumber;

    public Client() {}

    public Client(String name, long dni, long cuit, long cuil, String category, String description, String email, long phoneNumber) {
        this.name = name;
        this.dni = dni;
        this.cuit = cuit;
        this.cuil = cuil;
        this.category = category;
        this.description = description;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public long getCuit() {
        return cuit;
    }

    public void setCuit(long cuit) {
        this.cuit = cuit;
    }

    public long getCuil() {
        return cuil;
    }

    public void setCuil(long cuil) {
        this.cuil = cuil;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
