package hu.carparking.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by bmbal on 2016.11.01..
 */
public class ParkingLotVO implements Serializable{

    private static final long serialVersionUID = 1L;
    private String carLicensePlate;
    private Date timeIn;
    private Date timeOut;

    public ParkingLotVO() {
    }

    public ParkingLotVO(String carLicensePlate, Date timeIn, Date timeOut) {
        this.carLicensePlate = carLicensePlate;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCarLicensePlate() {
        return carLicensePlate;
    }

    public void setCarLicensePlate(String carLicensePlate) {
        this.carLicensePlate = carLicensePlate;
    }

    public Date getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(Date timeIn) {
        this.timeIn = timeIn;
    }

    public Date getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Date timeOut) {
        this.timeOut = timeOut;
    }
}
