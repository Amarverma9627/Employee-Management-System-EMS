package com.company.ems.dto;

import lombok.Data;

//ye new bnayi hai
@Data
public class UserProfileResponse {
    private Long id;
    private String name;
    private String email;
    private String department;
    private String role;
    private String joiningDate;

    // Constructor
    public UserProfileResponse(Long id, String name, String email, String department, String role, String joiningDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.role = role;
        this.joiningDate = joiningDate;
    }

    // Getters and Setters (lombok @Data bhi use kar sakte hain)
    // ...
}

