package entities;

import lombok.Getter;
import java.time.LocalDate;
import java.util.List;

@Getter
public class Objects {
    List<Roles> roles = List.of(new Roles.RolesBuilder().role("Szef").build(),new Roles.RolesBuilder().role("Pracownik").build());
    List<Login> logins = List.of(new Login.LoginBuilder().password("xd").login("login").build(),new Login.LoginBuilder().password("jan").login("jan").build());
    Orders order = new Orders.OrdersBuilder().localDate(LocalDate.of(2023,12,1)).build();

}
