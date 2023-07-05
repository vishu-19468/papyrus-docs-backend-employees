package com.papyrusdocs.employeeservice.controllers;

import com.papyrusdocs.employeeservice.models.request.Request;
import com.papyrusdocs.employeeservice.models.response.Response;
import com.papyrusdocs.employeeservice.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService _empService;

    @RequestMapping(value = "/getallemployees", method = RequestMethod.GET)
    public ResponseEntity<Response> getAllEmployees(){
        return ResponseEntity.ok(_empService.getAllEmployees());
    }

    @RequestMapping(value = "/updateemployee", method = RequestMethod.POST)
    public ResponseEntity<Response> updateProjects(@RequestBody Request request){
        return ResponseEntity.ok(_empService.updateEmployee(request));
    }

    @RequestMapping(value = "/deleteproject/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Response> deleteProjects(@PathVariable int id){
        return ResponseEntity.ok(_empService.deleteEmployee(id));
    }
}
