package com.muhammetcakir;

import com.muhammetcakir.data.entity.EmployeeEntity;
import com.muhammetcakir.data.repository.EmployeeRepository;
import com.muhammetcakir.test.TestCrud;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KodluyoruzSpringBootApplicationTests implements TestCrud {

    @Autowired
    EmployeeRepository employeeRepository;


    @Test
    void contextLoads() {
    }

    //CREATE
    @Test
    @Override
    public void testCreate() {
        EmployeeEntity employeeEntity = EmployeeEntity
                .builder()
                .firstName("Muhammet Test")
                .lastName("Çakır Test")
                .emailId("muhammetcakir@gmail.com")
                .build();
        employeeRepository.save(employeeEntity);

        //nesne null ise assertionError hatası göndersin
        //1. kayda göre verileri getir
        assertNotNull(employeeRepository.findById(1L).get());
    }

    //LIST
    @Test
    @Override
    public void testList() {
        List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();

        //Eğer 0'dan büyükse liste vardır.
        assertThat(employeeEntityList).size().isGreaterThan(0);
    }


    //FINDBYID
    @Test
    @Override
    public void testFindById() {
        EmployeeEntity employeeEntity = employeeRepository.findById(1L).get();

        //Muhammet Test adında kayıt var mı yok mu
        assertEquals("Muhammet Test", employeeEntity.getFirstName());
    }

    //UPDATE
    @Test
    @Override
    public void testUpdate() {
        EmployeeEntity employeeEntity = employeeRepository.findById(1L).get();
        employeeEntity.setFirstName("Muhammet 74 Test");
        employeeRepository.save(employeeEntity);

        //1L Id'li kayıdın önceki adına eşit mi diye soruyoruz
        assertNotEquals("Muhammet Test", employeeRepository.findById(1L).get().getFirstName());
    }


    @Test
    @Override
    public void testDelete() {
        employeeRepository.deleteById(1L);
        //isFalse
        assertThat(employeeRepository.existsById(1L)).isFalse();
    }
}
