package main.java.com.nexta.model;

public class WebSite {

    private int id;
    private String name;
    private String url;
    private int alex;
    private String country;

    public WebSite() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getAlex() {
        return alex;
    }

    public void setAlex(int alex) {
        this.alex = alex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "WebSite{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", alex=" + alex +
                ", country='" + country + '\'' +
                '}';
    }
}
