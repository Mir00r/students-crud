package com.mir00r.studentscrudapis.domains.students.models.dtos;

import com.mir00r.studentscrudapis.commons.models.dtos.BaseDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author mir00r on 11/5/22
 * @project IntelliJ IDEA
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto extends BaseDto {

    @NotNull
    @ApiModelProperty(example = "Jhon Doe", notes = "The name of student", required = true)
    private String name;
}
