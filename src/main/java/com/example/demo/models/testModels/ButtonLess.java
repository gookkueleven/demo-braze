package com.example.demo.models.testModels;

import com.example.demo.services.interfaces.JavaFunctionalInterface;
import lombok.Data;

@Data
public class ButtonLess {

  public void testFunctionalInterface(JavaFunctionalInterface javaFunctionalInterface) {
    System.out.println("this is not from functional interface");
    javaFunctionalInterface.onlyThisMethodAvailable
        ("whatever, it will use what the interface has been implement anyway");
  }

  public void testFunctionalInterfaceWithAnotherParameter(String name, JavaFunctionalInterface javaFunctionalInterface) {
    System.out.println(name);
    javaFunctionalInterface.onlyThisMethodAvailable
        ("functional interface has been passed into this function");
  }

}
