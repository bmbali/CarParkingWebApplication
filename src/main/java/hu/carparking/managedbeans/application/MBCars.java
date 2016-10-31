package hu.carparking.managedbeans.application;

import hu.carparking.vo.CarVO;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by bmbal on 2016.10.31..
 */
@ManagedBean(name = "cars")
@ApplicationScoped
public class MBCars {

    private Collection<CarVO> cars = new LinkedList<CarVO>();

    {
        cars.add(new CarVO("ABC-342", "BMW", "M3", "BLACK"));
        cars.add(new CarVO("DEF-342", "BMW", "M3", "BLACK"));
        cars.add(new CarVO("GHI-342", "BMW", "M3", "BLACK"));
    }

    public void addCar(CarVO car){
        cars.add(car);
    }

    public void deleteCar(CarVO car){
        cars.remove(car);
    }

    public Collection<CarVO> getCars() {
        return cars;
    }

    public void setCars(Collection<CarVO> cars) {
        this.cars = cars;
    }

}
