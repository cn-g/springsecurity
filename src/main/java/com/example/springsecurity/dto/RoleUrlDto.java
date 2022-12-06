package com.example.springsecurity.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Admin
 */
@Data
@Accessors(chain = true)
public class RoleUrlDto {

    private Long roleId;

    private String path;

    private String roleName;

}
