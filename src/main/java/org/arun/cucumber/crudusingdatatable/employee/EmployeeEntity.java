package org.arun.cucumber.crudusingdatatable.employee;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.*;

@Entity
@Table(name = "employee")
@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class EmployeeEntity implements Serializable {

  @Id
  private Long id;

  private String firstName;
  private String lastName;

  public LocalDate dateOfBirth;
  public LocalDate startDate;
  public LocalDate endDate;
  private String employmentType;

  private String email;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "employee_id", referencedColumnName = "id")
  private List<PhoneEntity> phones;
}
