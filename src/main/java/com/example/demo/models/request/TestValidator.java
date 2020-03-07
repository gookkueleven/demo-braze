package com.example.demo.models.request;

import com.example.demo.validators.TestValidatorAnnotationInterface;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestValidator {

    @NotNull(message = "must not be null")
    @TestValidatorAnnotationInterface(message = "damn it! I'm cool")
    private List<String> stringList;

}
