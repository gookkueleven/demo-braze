package com.example.demo.services;

import com.example.demo.models.testModels.Employee;
import com.example.demo.models.testModels.FParent;
import com.example.demo.models.testModels.Friend;
import com.example.demo.models.testModels.GFriend;
import com.example.demo.services.mappers.Friend2EmployeeMapper;
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

        GFriend gFriend = new GFriend();
        gFriend.setName("MJ");

        FParent fParent = new FParent();
        fParent.setName("May");

        Friend friend = new Friend();
        friend.setName("Peter");
        friend.setLastName("Parker");
        friend.setAge(22);
        friend.setFParent(fParent);
        friend.setGFriend(gFriend);

        Employee employee = mapper.friend2Employee(friend);

        assertEquals(friend.getName(), employee.getName());
        assertEquals(friend.getLastName(), employee.getLastName());
        assertEquals(friend.getAge(), employee.getAge());
        assertEquals(friend.getGFriend().getName(), employee.getRelationShip().getSpouseName());
        assertEquals(friend.getFParent().getName(), employee.getRelationShip().getParentName());
    }
}
