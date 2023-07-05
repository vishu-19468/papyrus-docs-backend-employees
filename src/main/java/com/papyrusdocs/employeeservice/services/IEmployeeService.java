package com.papyrusdocs.employeeservice.services;

import com.papyrusdocs.employeeservice.models.request.Request;
import com.papyrusdocs.employeeservice.models.response.Response;


public interface IEmployeeService {
    Response getAllEmployees();
    Response deleteEmployee(int id);
    Response updateEmployee(Request request);
}
