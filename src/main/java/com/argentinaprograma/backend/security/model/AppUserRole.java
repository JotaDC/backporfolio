package com.argentinaprograma.backend.security.model;



import org.springframework.security.core.GrantedAuthority;

public enum AppUserRole implements GrantedAuthority {
  ROLE_ADMIN, ROLE_CLIENT;

 
  @Override
  public String getAuthority() {
    return name();
  }

}
