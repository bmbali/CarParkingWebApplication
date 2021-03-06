package hu.carparking.vo;

import java.io.Serializable;

/**
 * Created by bmbal on 2016.10.31..
 */
public class CarVO implements Serializable{

    private static final long serialVersionUID = 1L;
    private String licensePlateNumber;
    private String brand;
    private String type;
    private String color;

    public CarVO() {
    }

    public CarVO(String licensePlateNumber, String brand, String type, String color) {
        this.licensePlateNumber = licensePlateNumber;
        this.brand = brand;
        this.type = type;
        this.color = color;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
