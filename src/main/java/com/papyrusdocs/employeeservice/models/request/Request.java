package com.papyrusdocs.employeeservice.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Request {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
}
