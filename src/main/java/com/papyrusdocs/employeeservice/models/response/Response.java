package com.papyrusdocs.employeeservice.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Response {
    public String statusCode;
    public String message;
    public List<?> data;
}
