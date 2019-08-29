package com.example.demo.services;

import com.example.demo.models.testModels.Employee;
import com.example.demo.models.testModels.Friend;
import com.example.demo.services.mappers.Friend2EmployeeMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class QuickTestMapStruct {

    @Test
    public void testMapStruct() {

        Friend2EmployeeMapper mapper = Mappers.getMapper(Friend2EmployeeMapper.class);

        Friend friend = new Friend();
        friend.setName("Peter");
        friend.setLastName("Parker");
        friend.setAge(22);

        Employee employee = mapper.friend2Employee(friend);

        assertEquals(friend.getName(), employee.getName());
        assertEquals(friend.getLastName(), employee.getLastName());
        assertEquals(friend.getAge(), employee.getAge());
    }
}
