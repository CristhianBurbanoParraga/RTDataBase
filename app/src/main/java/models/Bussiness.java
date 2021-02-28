package models;

public class Bussiness {

    private String nameBussinnes;
    private String ruc;
    private String city;
    private String address;

    public Bussiness() {

    }

    public Bussiness(String nameBussinnes, String ruc, String city, String address) {
        this.nameBussinnes = nameBussinnes;
        this.ruc = ruc;
        this.city = city;
        this.address = address;
    }

    public String getNameBussinnes() {
        return nameBussinnes;
    }

    public void setNameBussinnes(String nameBussinnes) {
        this.nameBussinnes = nameBussinnes;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        /*return "Bussiness{" +
                "nameBussinnes='" + nameBussinnes + '\'' +
                ", ruc='" + ruc + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                '}';*/
        return "Empresa: " + nameBussinnes + "\n" +
                "RUC: " + ruc + "\n" +
                "Ciudad: " + city + "\n" +
                "Direccion: " + address;
    }
}
