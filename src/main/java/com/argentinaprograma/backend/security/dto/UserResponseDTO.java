package com.argentinaprograma.backend.security.dto;



import java.util.List;

//import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.argentinaprograma.backend.security.model.AppUserRole;

@Data
public class UserResponseDTO {

  //@ApiModelProperty(position = 0)
  private Integer id;
  //@ApiModelProperty(position = 1)
  private String username;
  //@ApiModelProperty(position = 2)
  private String password;
 
  //@ApiModelProperty(position = 3)
  //private List<AppUserRole> appUserRoles;

}
