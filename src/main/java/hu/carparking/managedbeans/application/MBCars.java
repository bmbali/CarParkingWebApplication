package hu.carparking.managedbeans.application;

import hu.carparking.vo.CarVO;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by bmbal on 2016.10.31..
 */
@ManagedBean(name = "cars")
@ApplicationScoped
public class MBCars implements Serializable{

    private static final long serialVersionUID = 1L;

    private Collection<CarVO> cars = new LinkedList<CarVO>();

    {
        cars.add(new CarVO("ABC-342", "BMW", "M3", "BLACK"));
        cars.add(new CarVO("DEF-342", "BMW", "M3", "BLACK"));
        cars.add(new CarVO("GHI-342", "BMW", "M3", "BLACK"));
    }

    public boolean isContains(String licensePlateNumber){
        for (CarVO car : cars
             ) {
            if(car.getLicensePlateNumber().equals(licensePlateNumber)){
                return true;
            }
        }
        return false;
    }

    public void addCar(CarVO car){
        cars.add(car);
    }

    public void deleteCar(String licensePlateNumber){
        for (CarVO car: cars
             ) {
            if(car.getLicensePlateNumber().equals(licensePlateNumber)){
                cars.remove(car);
                return;
            }
        }
    }

    public Collection<CarVO> getCars() {
        return cars;
    }

    public void setCars(Collection<CarVO> cars) {
        this.cars = cars;
    }

}
