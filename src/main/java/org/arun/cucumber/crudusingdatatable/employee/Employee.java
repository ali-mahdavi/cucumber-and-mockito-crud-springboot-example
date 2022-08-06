package org.arun.cucumber.crudusingdatatable.employee;

import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.arun.cucumber.crudusingdatatable.employee.ValidationGroups.CreateEmployee;
import org.arun.cucumber.crudusingdatatable.employee.ValidationGroups.UpdateEmployee;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

  @NotNull(groups = {UpdateEmployee.class})
  @JsonProperty("id")
  private Long id;

  @NotEmpty(groups = {CreateEmployee.class,
                      UpdateEmployee.class})
  @JsonProperty("firstName")
  private String firstName;

  @NotEmpty(groups = {CreateEmployee.class,
                      UpdateEmployee.class})
  @JsonProperty("lastName")
  private String lastName;

  @NotNull(groups = {CreateEmployee.class,
                     UpdateEmployee.class})
  @JsonProperty("dateOfBirth")
  public LocalDate dateOfBirth;

  @NotNull(groups = {CreateEmployee.class,
                     UpdateEmployee.class})
  @JsonProperty("startDate")
  public LocalDate startDate;
  @JsonProperty("endDate")
  public LocalDate endDate;

  @NotEmpty(groups = {CreateEmployee.class,
                      UpdateEmployee.class})
  @JsonProperty("employmentType")
  private String employmentType;

  @NotEmpty(groups = {CreateEmployee.class,
                      UpdateEmployee.class})
  @JsonProperty("email")
  private String email;

  @NotNull(groups = {CreateEmployee.class,
                     UpdateEmployee.class})
  private List<Phone> phones;

}
