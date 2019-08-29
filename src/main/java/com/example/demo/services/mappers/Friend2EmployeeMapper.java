package com.example.demo.services.mappers;

import com.example.demo.models.testModels.Employee;
import com.example.demo.models.testModels.Friend;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface Friend2EmployeeMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "age", source = "age")
    Employee friend2Employee(Friend friend);
}
