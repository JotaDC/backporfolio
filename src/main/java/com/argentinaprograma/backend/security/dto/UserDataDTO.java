package com.argentinaprograma.backend.security.dto;



import java.util.List;

//import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.argentinaprograma.backend.security.model.AppUserRole;

@Data
@NoArgsConstructor
public class UserDataDTO {
  
  //@ApiModelProperty(position = 0)
  private String username;
  //@ApiModelProperty(position = 1)
  //private String email;
  //@ApiModelProperty(position = 2)
  private String password;
  //@ApiModelProperty(position = 3)
  //private List<AppUserRole> appUserRoles;

}
