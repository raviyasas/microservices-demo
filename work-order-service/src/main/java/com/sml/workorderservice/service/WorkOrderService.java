package com.sml.workorderservice.service;

import com.sml.workorderservice.model.WorkOrder;
import com.sml.workorderservice.repository.WorkOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class WorkOrderService implements CommandLineRunner {

    private WorkOrderRepository workOrderRepository;

    @Autowired
    public WorkOrderService(WorkOrderRepository workOrderRepository){
        this.workOrderRepository=workOrderRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Stream.of("One", "Two", "Three", "Four", "Five")
                .forEach(name -> workOrderRepository.save(new WorkOrder(name)));

        workOrderRepository.findAll().forEach(System.out::println);
    }
}
