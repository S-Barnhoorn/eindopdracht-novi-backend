package com.example.eindopdrachtnovibackend.service;

import com.example.eindopdrachtnovibackend.exception.RecordNotFoundException;
import com.example.eindopdrachtnovibackend.model.Car;
import com.example.eindopdrachtnovibackend.model.Customer;
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
public class CustomerServiceTest {


    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Captor
    ArgumentCaptor<Customer> customerArgumentCaptor;

    @Test
    public void getCustomerTest(){
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("Jan");

        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));

        var customer1 = customerService.getCustomer(1L);

        assertThat(customer1.getId()).isEqualTo(1L);
        assertThat(customer1.getFirstName()).isEqualTo("Jan");
    }
    @Test
    public void getCarExceptionTest() {

        assertThrows(RecordNotFoundException.class, () -> customerService.getCustomer(0));
    }

    @Test
    public void getCustomersTest() {
        List<Customer> testCustomers = new ArrayList<>();

        Customer customer1 = new Customer();
        customer1.setFirstName("Willem");
        customer1.setLastName("Willemse");
        customer1.setPhoneNumber("0612345678");

        Customer customer2 = new Customer();
        customer2.setFirstName("Jan");
        customer2.setLastName("Jansen");
        customer2.setPhoneNumber("0687654321");

        testCustomers.add(customer1);
        testCustomers.add(customer2);

        when(customerRepository.findAll()).thenReturn(testCustomers);
        customerService.getCustomers();

        verify(customerRepository, times(1)).findAll();

        assertThat(testCustomers.size()).isEqualTo(2);

        assertThat(testCustomers.get(0)).isEqualTo(customer1);

        assertThat(testCustomers.get(1)).isEqualTo(customer2);

    }

    @Test
    public void addCustomerTest() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("Piet");
        customer.setLastName("Vogel");
        customer.setPhoneNumber("1234567890");
        customerRepository.save(customer);
        verify(customerRepository, times(1)).save(customerArgumentCaptor.capture());
        var customer1 = customerArgumentCaptor.getValue();
        assertThat(customer1.getFirstName()).isEqualTo("Piet");
        assertThat(customer1.getLastName()).isEqualTo("Vogel");
        assertThat(customer1.getPhoneNumber()).isEqualTo("1234567890");
        assertThat(customer1.getId()).isEqualTo(1);
    }

    @Test
    public void updateCustomerTest() {
        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setFirstName("Frans");
        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer1));
        customer1.setFirstName("Gerda");
        customerService.updateCustomer(1L, customer1);
        verify(customerRepository).save(customer1);
        assertThat(customer1.getId()).isEqualTo(1);
        assertThat(customer1.getFirstName()).isEqualTo("Gerda");
    }

    @Test
    public void updateCustomerExceptionTest() {
        assertThrows(RecordNotFoundException.class, () -> customerService.getCustomer(0));
    }

    @Test
    public void removeCustomerTest() {
        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setFirstName("Hans");
        customerRepository.delete(customer1);
        customerService.removeCustomer(1L);
        verify(customerRepository, times(1)).delete(customer1);
    }
}
