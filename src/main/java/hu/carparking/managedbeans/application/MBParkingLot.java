package hu.carparking.managedbeans.application;

import hu.carparking.vo.ParkingLotVO;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created by bmbal on 2016.11.01..
 */
@ManagedBean(name = "parkingLot")
@ApplicationScoped
public class MBParkingLot implements Serializable{

    private static final long serialVersionUID = 1L;

    private Collection<ParkingLotVO> carsIn = new LinkedList<ParkingLotVO>();

    public void deleteByLicensePlateNumber(String licensePlateNumber){
        for (ParkingLotVO cars: carsIn
             ) {
            if(cars.getCarLicensePlate().equals(licensePlateNumber)){
                carsIn.remove(cars);
            }
        }
    }
    public boolean isContains(String licensePlateNumber){
        for (ParkingLotVO cars: carsIn
                ) {
            if(cars.getCarLicensePlate().equals(licensePlateNumber)){
                return true;
            }
        }
        return false;
    }

    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.AM_PM, Calendar.AM);
        calendar.set(Calendar.HOUR, 8);
        calendar.set(Calendar.MINUTE, 15);
        Date time = calendar.getTime();
        carsIn.add(new ParkingLotVO("ABC-342", time, time));
        carsIn.add(new ParkingLotVO("DEF-342", time, time));
    }


    public Collection<ParkingLotVO> getCarsIn() {
        return carsIn;
    }

    public void setCarsIn(Collection<ParkingLotVO> carsIn) {
        this.carsIn = carsIn;
    }
}
