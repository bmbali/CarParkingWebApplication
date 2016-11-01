package hu.carparking.managedbeans.view;

import hu.carparking.managedbeans.application.MBCars;
import hu.carparking.managedbeans.application.MBParkingLot;
import hu.carparking.vo.CarVO;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.io.Serializable;

/**
 * Created by bmbal on 2016.10.31..
 */
@ManagedBean(name = "carsData")
@ViewScoped
public class CarsDataGrid implements Serializable {

    private static final long serialVersionUID = 1L;

    private CarVO selectedCar;

    @ManagedProperty("#{cars}")
    private MBCars cars;

    @ManagedProperty("#{parkingLot}")
    private MBParkingLot parkingLot;

    @PostConstruct
    public void init() {
        selectedCar = new CarVO();
    }

    public void addCar(ActionEvent actionEvent){
        if(cars.isContains(selectedCar.getLicensePlateNumber())){
            FacesContext.getCurrentInstance().addMessage
                    ("MessageId", new FacesMessage(FacesMessage.SEVERITY_WARN, "\n" +
                            "Unable to add new car", "\n" +
                            "This license plate number already in use!"));
        } else if(!(selectedCar.getLicensePlateNumber().equals(""))
                && !(selectedCar.getType().equals(""))
                && !(selectedCar.getBrand().equals(""))
                && !(selectedCar.getColor().equals(""))){
            cars.addCar(selectedCar);
            FacesContext.getCurrentInstance().addMessage
                    ("MessageId", new FacesMessage  (FacesMessage.SEVERITY_INFO,
                            "Car saved successfully!",
                            "License plate number: " + selectedCar.getLicensePlateNumber()));
            selectedCar = new CarVO();
        } else {
            FacesContext.getCurrentInstance().addMessage
                    ("MessageId", new FacesMessage(FacesMessage.SEVERITY_WARN, "\n" +
                            "Unable to add new car", "\n" +
                            "All information required!"));
        }
    }

    public void deleteCar(String licensePlateNumber){
        if(!parkingLot.isContains(licensePlateNumber)) {
            cars.deleteCar(licensePlateNumber);
            FacesContext.getCurrentInstance().addMessage
                    ("MessageId", new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Car deleted successfully!",
                            "License plate number: " + licensePlateNumber));
            selectedCar = new CarVO();
        } else {
            FacesContext.getCurrentInstance().addMessage
                    ("MessageId", new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Car cant be deleted!",
                            "It's in a parking lot: " + licensePlateNumber));
        }
    }

    public MBCars getCars() {
        return cars;
    }

    public void setCars(MBCars cars) {
        this.cars = cars;
    }

    public CarVO getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(CarVO selectedCar) {
        this.selectedCar = selectedCar;
    }

    public MBParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(MBParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
}
