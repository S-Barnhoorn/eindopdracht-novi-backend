package com.example.eindopdrachtnovibackend.service;

import com.example.eindopdrachtnovibackend.model.Customer;
import com.example.eindopdrachtnovibackend.model.RepairJob;
import com.example.eindopdrachtnovibackend.repository.RepairJobRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RepairJobServiceTest {

    @Mock
    RepairJobRepository repairJobRepository;

    @InjectMocks
    private RepairJobServiceImpl repairJobService;

    @Captor
    ArgumentCaptor<RepairJob> repairJobArgumentCaptor;

    @Test
    public void getRepairJobTest(){
        RepairJob repairJob = new RepairJob();
        repairJob.setId(1L);
        repairJob.setCustomerAgrees("Yes");

        when(repairJobRepository.findById(1L)).thenReturn(Optional.of(repairJob));

        var repairJob1 = repairJobService.getRepairJob(1L);

        assertThat(repairJob1.getId()).isEqualTo(1L);
        assertThat(repairJob1.getCustomerAgrees()).isEqualTo("Yes");

    }

    @Test
    public void addCustomerTest() {
        RepairJob repairJob = new RepairJob();
        repairJob.setId(1L);
        repairJob.setCustomerAgrees("No");
        repairJobRepository.save(repairJob);
        verify(repairJobRepository, times(1)).save(repairJobArgumentCaptor.capture());
        var repairJob1 = repairJobArgumentCaptor.getValue();
        assertThat(repairJob1.getCustomerAgrees()).isEqualTo("No");
        assertThat(repairJob1.getId()).isEqualTo(1);
    }

    @Test
    public void updateCustomerTest() {
        RepairJob repairJob1 = new RepairJob();
        repairJob1.setId(1L);
        repairJob1.setCustomerAgrees("Yes");
        when(repairJobRepository.findById(1L)).thenReturn(Optional.of(repairJob1));
        repairJob1.setCustomerAgrees("No");
        repairJobService.updateRepairJob(1L, repairJob1);
        verify(repairJobRepository).save(repairJob1);
        assertThat(repairJob1.getId()).isEqualTo(1);
        assertThat(repairJob1.getCustomerAgrees()).isEqualTo("No");
    }

    @Test
    public void removeCustomerTest() {
        RepairJob repairJob1 = new RepairJob();
        repairJob1.setId(1L);
        repairJob1.setCustomerAgrees("Yes");
        repairJobRepository.delete(repairJob1);
        repairJobService.removeRepairJob(1L);
        verify(repairJobRepository, times(1)).delete(repairJob1);
    }

}

