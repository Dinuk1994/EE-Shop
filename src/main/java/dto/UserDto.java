package dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {

    private String userId;
    private String address;
    private int contactNumber;
    private String email;
    private String name;
    private String primaryPassword;

}
