package br.com.bossawebsolutions.bws_site_backend.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmailRequest {
    private String name;
    private String email;
    private String phone;
    private String message;

}
