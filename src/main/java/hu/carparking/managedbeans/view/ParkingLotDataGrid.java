package hu.carparking.managedbeans.view;

import hu.carparking.managedbeans.application.MBCars;
import hu.carparking.managedbeans.application.MBParkingLot;
import hu.carparking.vo.ParkingLotVO;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by bmbal on 2016.11.01..
 */
@ManagedBean(name = "parkingLotData")
@ViewScoped
public class ParkingLotDataGrid implements Serializable{

    private static final long serialVersionUID = 1L;

    private Date timeIn;
    private Date timeOut;

    @ManagedProperty("#{cars}")
    private MBCars cars;

    @ManagedProperty("#{parkingLot}")
    private MBParkingLot parkingLot;

    @PostConstruct
    public void init() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.AM_PM, Calendar.AM);
        calendar.set(Calendar.HOUR, 8);
        calendar.set(Calendar.MINUTE, 15);
        timeIn = calendar.getTime();
        calendar.set(Calendar.HOUR, 11);
        calendar.set(Calendar.MINUTE, 40);
        timeOut = calendar.getTime();
    }

    public void parkIn(){
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
                .getRequest();
        String licensePlateNumber = request.getParameter("licensePlateNumber");
        if(licensePlateNumber != null) {
            if(parkingLot.isContains(licensePlateNumber)){
                FacesContext.getCurrentInstance().addMessage
                        ("MessageId", new FacesMessage(FacesMessage.SEVERITY_WARN,
                                "Car already parked in!",
                                "License plate number: " + licensePlateNumber));
            }else {
                parkingLot.getCarsIn().add(new ParkingLotVO(licensePlateNumber, timeIn, timeOut));
                FacesContext.getCurrentInstance().addMessage
                        ("MessageId", new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Car parked in successfully!",
                                "License plate number: " + licensePlateNumber));
            }
            return;
        } else {
            FacesContext.getCurrentInstance().addMessage
                    ("MessageId", new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Cant park in!",
                            "Chose one car in the manager page!"));
        }
    }

    public void parkOut(String licensePlateNumber){
        parkingLot.deleteByLicensePlateNumber(licensePlateNumber);
        FacesContext.getCurrentInstance().addMessage
                ("MessageId", new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Car cleared successfully!",
                        "License plate number: " + licensePlateNumber));
    }

    public String returnHome(){
        return "home";
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

    public MBParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(MBParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public MBCars getCars() {
        return cars;
    }

    public void setCars(MBCars cars) {
        this.cars = cars;
    }



}
