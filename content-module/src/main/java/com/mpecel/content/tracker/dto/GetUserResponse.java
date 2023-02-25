package com.mpecel.content.tracker.dto;

import com.mpecel.content.tracker.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetUserResponse {
    public GetUserResponse(User user) {
        this.userName = user.getUserName();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
    }
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
}
