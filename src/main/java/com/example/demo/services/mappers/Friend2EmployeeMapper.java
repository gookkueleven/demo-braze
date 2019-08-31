package com.example.demo.services.mappers;

import com.example.demo.models.testModels.RelationShip;
import com.example.demo.models.testModels.Employee;
import com.example.demo.models.testModels.Friend;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper
public interface Friend2EmployeeMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "age", source = "age")
    @Mapping(target = "relationShip", source = "friend", qualifiedByName = "f2r")
    Employee friend2Employee(Friend friend);

    @Named("f2r")
    @Mapping(target = "spouseName", source = "friend.GFriend.name")
    @Mapping(target = "parentName", source = "friend.FParent.name")
    RelationShip friend2RelationShip(Friend friend);
}
