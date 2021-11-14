package com.example.eindopdrachtnovibackend.service;


import com.example.eindopdrachtnovibackend.exception.RecordNotFoundException;
import com.example.eindopdrachtnovibackend.model.Customer;
import com.example.eindopdrachtnovibackend.model.RepairItem;
import com.example.eindopdrachtnovibackend.repository.RepairItemRepository;
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
public class RepairItemServiceTest {

    @Mock
    RepairItemRepository repairItemRepository;

    @InjectMocks
    private RepairItemServiceImpl repairItemService;

    @Captor
    ArgumentCaptor<RepairItem> repairItemArgumentCaptor;

    @Test
    public void getRepairItemsTest(){
        RepairItem repairItem = new RepairItem();
        repairItem.setId(1L);
        repairItem.setInspection("inspection");

        when(repairItemRepository.findById(1L)).thenReturn(Optional.of(repairItem));

        var repairItem1 = repairItemService.getRepairItem(1L);

        assertThat(repairItem1.getId()).isEqualTo(1L);
        assertThat(repairItem1.getInspection()).isEqualTo("inspection");
    }

    @Test
    public void addRepairItemTest() {
        RepairItem repairItem = new RepairItem();
        repairItem.setId(1L);
        repairItem.setInspection("inspection");

        repairItemRepository.save(repairItem);
        verify(repairItemRepository, times(1)).save(repairItemArgumentCaptor.capture());
        var repairItem1 = repairItemArgumentCaptor.getValue();
        assertThat(repairItem1.getInspection()).isEqualTo("inspection");

        assertThat(repairItem1.getId()).isEqualTo(1);
    }

    @Test
    public void updateRepairItemTest() {
        RepairItem repairItem = new RepairItem();
        repairItem.setId(1L);
        repairItem.setInspection("inspection");
        repairItemRepository.save(repairItem);

        verify(repairItemRepository, times(1)).save(repairItemArgumentCaptor.capture());
        var repairItem1 = repairItemArgumentCaptor.getValue();
        assertThat(repairItem1.getInspection()).isEqualTo("inspection");

        assertThat(repairItem1.getId()).isEqualTo(1);
    }

    @Test
    public void removeRepairItemTest() {
        RepairItem repairItem1 = new RepairItem();
        repairItem1.setId(1L);
        repairItem1.setInspection("inspection");
        repairItemRepository.delete(repairItem1);
        repairItemService.removeRepairItem(1L);
        verify(repairItemRepository, times(1)).delete(repairItem1);
    }
}






