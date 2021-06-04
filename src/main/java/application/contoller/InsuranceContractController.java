package application.contoller;


import application.model.dto.InsuranceContractDto;
import application.service.InsuranceContractService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contracts")
public class InsuranceContractController {

    private InsuranceContractService insuranceContractService;

    public InsuranceContractController(InsuranceContractService insuranceContractService) {
        this.insuranceContractService = insuranceContractService;
    }

    @PostMapping
    public void add(@RequestBody InsuranceContractDto insuranceContract) {
        insuranceContractService.add(insuranceContract);
    }

    @GetMapping("/{id}")
    public InsuranceContractDto getInsuranceContractById(@PathVariable("id") Integer id) {
        return insuranceContractService.findById(id);
    }

    @GetMapping
    public List<InsuranceContractDto> getInsuranceContracts() {
        return insuranceContractService.findAll();
    }

    @PutMapping
    public void update(@RequestBody InsuranceContractDto insuranceContract) {
        insuranceContractService.update(insuranceContract);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        insuranceContractService.deleteById(id);
    }
}
