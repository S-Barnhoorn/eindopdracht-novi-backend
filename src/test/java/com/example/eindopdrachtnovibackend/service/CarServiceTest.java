package com.example.eindopdrachtnovibackend.service;

import com.example.eindopdrachtnovibackend.controller.dto.CarDto;
import com.example.eindopdrachtnovibackend.exception.RecordNotFoundException;
import com.example.eindopdrachtnovibackend.model.Car;
import com.example.eindopdrachtnovibackend.model.Customer;
import com.example.eindopdrachtnovibackend.repository.CarRepository;
import com.example.eindopdrachtnovibackend.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @Mock
    CarRepository carRepository;

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    private CarServiceImpl carService;

    @Captor
    ArgumentCaptor<Car> carArgumentCaptor;

    @Test
    public void getCarTest() {
        Car car = new Car();
        car.setLicensePlate("234-ABC-34");

        when(carRepository.findById(1L)).thenReturn(Optional.of(car));

        var car1 = carService.getCar(1L);

        assertThat(car1.getLicensePlate()).isEqualTo("234-ABC-34");
    }

    @Test
    public void getCarExceptionTest() {
        assertThrows(RecordNotFoundException.class, () -> carService.getCar(0));
    }

    @Test
    public void getCarsTest() {
        List<Car> testCars = new ArrayList<>();
        Car car1 = new Car();
        car1.setId(1L);
        car1.setLicensePlate("234-DFR-98");
        Car car2 = new Car();
        car1.setId(2L);
        car1.setLicensePlate("454-DGR-88");
        Car car3 = new Car();
        car1.setId(3L);
        car1.setLicensePlate("22-ACF-78");

        testCars.add(car1);
        testCars.add(car2);
        testCars.add(car3);

        when(carRepository.findAll()).thenReturn(testCars);
        carService.getCars();

        verify(carRepository, times(1)).findAll();

        assertThat(testCars.size()).isEqualTo(3);

        assertThat(testCars.get(0)).isEqualTo(car1);

        assertThat(testCars.get(1)).isEqualTo(car2);

        assertThat(testCars.get(2)).isEqualTo(car3);
    }

    @Test
    public void addCarTest() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("Piet");
        customer.setLastName("Vogel");
        customer.setPhoneNumber("1234567890");
        customerRepository.save(customer);
        Car car = new Car();
        car.setId(1L);
        car.setLicensePlate("234-DRE-24");
        car.setDayOfCarCheck("16-07-2021");
        car.setDayOfRepairJob("23-07-2021");
        car.setCustomer(customer);
        carRepository.save(car);
        verify(carRepository, times(1)).save(carArgumentCaptor.capture());
        var car1 = carArgumentCaptor.getValue();
        assertThat(car1.getLicensePlate()).isEqualTo("234-DRE-24");
        assertThat(car1.getCustomer()).isEqualTo(customer);
        assertThat(car1.getDayOfCarCheck()).isEqualTo("16-07-2021");
        assertThat(car1.getDayOfRepairJob()).isEqualTo("23-07-2021");
        assertThat(car1.getId()).isEqualTo(1);
    }

    @Test
    public void updateCarTest() {
        Car car1 = new Car();
        car1.setId(1L);
        car1.setLicensePlate("234-DRE-24");
        when(carRepository.findById(1L)).thenReturn(Optional.of(car1));
        car1.setLicensePlate("243-DRE-24");
        carService.updateCar(1L, car1);
        verify(carRepository).save(car1);
        assertThat(car1.getId()).isEqualTo(1);
        assertThat(car1.getLicensePlate()).isEqualTo("243-DRE-24");
    }

    @Test
    public void updateCarExceptionTest() {
        assertThrows(RecordNotFoundException.class, () -> carService.getCar(0));
    }

    @Test
    public void removeCarTest() {
        Car car1 = new Car();
        car1.setId(1L);
        car1.setLicensePlate("243-DRE-24");
        carRepository.delete(car1);
        carService.removeCar(1L);
        verify(carRepository, times(1)).delete(car1);
    }
}