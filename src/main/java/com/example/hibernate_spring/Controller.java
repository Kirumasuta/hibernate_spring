package com.example.hibernate_spring;

import com.example.hibernate_spring.model.Department;
import com.example.hibernate_spring.model.EmpToDep;
import com.example.hibernate_spring.model.Employee;
import com.example.hibernate_spring.model.Organization;
import com.example.hibernate_spring.service.DepartmentService;
import com.example.hibernate_spring.service.EmpToDepService;
import com.example.hibernate_spring.service.EmployeeService;
import com.example.hibernate_spring.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
class RestController{

    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmpToDepService empToDepService;

    @GetMapping("/getO")
    public ResponseEntity getOrg(){

        try{
            System.out.println(organizationService.getOrganization(1).getName());
            return ResponseEntity.ok("Organization find - " +
                    organizationService.getOrganization(1).getName());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e);
        }

    }
    @GetMapping("/getD")
    public ResponseEntity getD(@RequestParam Integer id){

        try{
            System.out.println(departmentService.getDepartment(id).getName());
            return ResponseEntity.ok("Department find - " +
                    departmentService.getDepartment(id).getName());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e);
        }

    }
    @GetMapping("/getE")
    public ResponseEntity getE(@RequestParam Integer id){

        try{
            System.out.println(employeeService.getEmployee(id).getName());
            return ResponseEntity.ok("Employee find - " +
                    employeeService.getEmployee(id).getName());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e);
        }

    }
    @GetMapping("/getEtd")
    public ResponseEntity getEtd(@RequestParam Integer id){

        try{
            System.out.println(empToDepService.getEmpToDep(id));
            return ResponseEntity.ok("Etd find - " + empToDepService.getEmpToDep(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e);
        }

    }



}


@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmpToDepService empToDepService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Test(Model model){
        //Organization select
        List<Organization> orgList = organizationService.getAllOrganization(Organization.class);
        //Department by organization[0] select
        List<Department> depList = departmentService.getDepartmentByOrganization(orgList.get(0).getId());
        List<EmpToDep> etdList = empToDepService.getAllEmpToDep(EmpToDep.class);
        List<Employee> employees = employeeService.getAllEmployees(Employee.class);


        StringBuilder s = new StringBuilder();
        s.append("<ul>").append(orgList.get(0).getName());
        s.append("<ul>");

        depList.forEach( dep -> {
            if(dep.getDepId() == null){
                WriteDeps(s, depList, dep, etdList, employees);
            }
        });

        s.append("</ul>");
        System.out.println(s);

        model.addAttribute("data", s.toString());
        return "index";
    }

    private static void WriteDeps(StringBuilder s,
                                  List<Department> departments,
                                  Department dep,
                                  List<EmpToDep> empToDeps,
                                  List<Employee> employees){

        s.append("<ul>").append(dep.getName()).append("<a> close branch </a>");

        empToDeps.forEach(etd -> {
            if(etd.getDep().getId() == dep.getId()){
                s.append("<li>").append("Employee - ").append(employees.get(etd.getEmp().getId()-1).getName()).append("</li>");
            }
        });

        List<Department> subDep = new ArrayList<>();
        departments.forEach( deps -> {
            if(Objects.equals(deps.getDepId(), dep.getId())){
                subDep.add(deps);
            }
        });

        if(subDep.size() > 0){
            s.append("<ul>");
            subDep.forEach( sub-> {
                if((int)departments.stream().filter
                        (deps->Objects.equals(deps.getDepId(),sub.getId())).count() > 0){
                    WriteDeps(s,departments,sub, empToDeps, employees);
                }else {
                    s.append("<ul>").append(sub.getName()).append("<a> close branch </a>");

                    empToDeps.forEach(etd -> {
                        if(etd.getDep().getId() == sub.getId()){
                            s.append("<li>").append("Employee - ").append(employees.get(etd.getEmp().getId()-1).getName()).append("</li>");
                        }
                    });
                    s.append("</ul>");
                }
            });
            s.append("</ul>");
        }

        s.append("</ul>");
    }

}
