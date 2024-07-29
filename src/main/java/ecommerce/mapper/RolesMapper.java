package ecommerce.mapper;

import ecommerce.dto.RolesResponse;
import ecommerce.entity.Role;

import java.util.ArrayList;
import java.util.List;

public class RolesMapper {
    public static List<RolesResponse> RoleToRolesResponse(List<Role> roles){

        List<RolesResponse> res = new ArrayList<>();

        for(Role ro : roles){
            res.add(new RolesResponse(ro.getId(),ro.getAuthority()));
        }

        return res;
    }
}
