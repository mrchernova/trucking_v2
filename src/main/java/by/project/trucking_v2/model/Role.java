package by.project.trucking_v2.model;

//public enum Role {
//    ADMINISTRATOR,
//    CLIENT,
//    CARRIER,
//    UNDEFINED;
//
//
//    public static Role getByOrdinal(int ordinal) {
//        Role[] values = Role.values();
//        if(ordinal >= values.length || ordinal < 0) {
//            return UNDEFINED;
//        }
//        return values[ordinal];
//    }
//
//}

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    ADMINISTRATOR(Set.of(Permission.USERS_READ, Permission.USERS_WRITE)),
    CLIENT(Set.of(Permission.USERS_READ)),
    CARRIER(Set.of(Permission.USERS_READ));

    private final Set<Permission> permissions;


    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities(){
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
