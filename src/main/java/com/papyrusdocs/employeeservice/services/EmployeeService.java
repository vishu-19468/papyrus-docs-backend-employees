package com.papyrusdocs.employeeservice.services;

import com.papyrusdocs.employeeservice.models.Employee;
import com.papyrusdocs.employeeservice.models.request.Request;
import com.papyrusdocs.employeeservice.models.response.Response;
import com.papyrusdocs.employeeservice.repository.IEmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService{
    private final IEmployeeRepository _empRepo;

    public EmployeeService(IEmployeeRepository empRepo) {
        _empRepo = empRepo;
    }

    public Response getAllEmployees(){
        var response = _empRepo.findAll();

        if (response == null){
            return Response.builder()
                    .statusCode("204 No content")
                    .message("There are no records on the database")
                    .build();
        }
        return  Response.builder()
                .statusCode("200 Ok")
                .message("Success")
                .data(response)
                .build();
    }

    public Response updateEmployee(Request request){
        try{
            if (request == null){

                return Response.builder()
                        .statusCode("400 Bad request")
                        .message("Request cannot be empty")
                        .build();
            }

            var emp = _empRepo.findById(request.getId());

            if (emp.isPresent()){
                emp.get().setFirstName(request.getFirstName());
                emp.get().setLastName(request.getLastName());
                emp.get().setEmail(request.getEmail());

                _empRepo.save(emp.get());

                return Response.builder()
                        .statusCode("200 Ok")
                        .message("Success")
                        .build();
            }

            return Response.builder()
                    .statusCode("404 Not found")
                    .message("Unable to find a user")
                    .build();

        } catch (Exception ex){

            return Response.builder()
                    .statusCode("500 Internal server error")
                    .message(ex.getMessage())
                    .build();
        }
    }

    public Response deleteEmployee(int id){
        try{
            if (id == 0){

                return Response.builder()
                        .statusCode("400 Bad request")
                        .message("Id cannot be 0")
                        .build();
            }

            _empRepo.deleteById(id);

            return Response.builder()
                    .statusCode("200 Ok")
                    .message("Success")
                    .build();

        }catch (Exception ex){
            return Response.builder()
                    .statusCode("500 Internal server error")
                    .message(ex.getMessage())
                    .build();
        }
    }

}
