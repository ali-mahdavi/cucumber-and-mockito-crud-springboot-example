package org.arun.cucumber.crudusingdatatable.employee;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.*;

@Entity
@Table(name = "phone")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class PhoneEntity implements Serializable {

  @Id
  private Long id;

  private String type;
  private String isdCode;
  private String phoneNumber;
  private String extension;

}
