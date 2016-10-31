package hu.carparking.managedbeans.view;

import hu.carparking.managedbeans.application.MBCars;
import hu.carparking.vo.CarVO;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 * Created by bmbal on 2016.10.31..
 */
@ManagedBean(name = "carsData")
@ViewScoped
public class CarsDataGrid {

    private CarVO selectedCar;

    @ManagedProperty("#{cars}")
    private MBCars cars;

    @PostConstruct
    public void init() {
        selectedCar = new CarVO();
    }

    public void addCar(ActionEvent actionEvent){
        if(selectedCar != null){
            cars.addCar(selectedCar);
            FacesContext.getCurrentInstance().addMessage
                    ("MessageId", new FacesMessage  (FacesMessage.SEVERITY_INFO,"Car saved successfully!", "License plate number: " + selectedCar.getLicensePlateNumber()));
            selectedCar = new CarVO();
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
}
