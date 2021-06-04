package application.contoller;


import application.model.dto.InsuranceCompanyMonthInfoDto;
import application.service.InsuranceCompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/info")
public class InsuranceCompanyMonthInfoController {

    private InsuranceCompanyService insuranceCompanyService;

    public InsuranceCompanyMonthInfoController(InsuranceCompanyService insuranceCompanyService) {
        this.insuranceCompanyService = insuranceCompanyService;
    }

    @PostMapping
    public void add(@RequestBody InsuranceCompanyMonthInfoDto insuranceCompanyMonthInfo) {
        insuranceCompanyService.add(insuranceCompanyMonthInfo);
    }

    @GetMapping("/{id}")
    public InsuranceCompanyMonthInfoDto getInsuranceCompanyMonthInfoById(@PathVariable("id") Integer id) {
        return insuranceCompanyService.findById(id);
    }

    @GetMapping
    public List<InsuranceCompanyMonthInfoDto> getInsuranceCompanyMonthInfos() {
        return insuranceCompanyService.findAll();
    }

    @PutMapping
    public void update(@RequestBody InsuranceCompanyMonthInfoDto insuranceCompanyMonthInfo) {
        insuranceCompanyService.update(insuranceCompanyMonthInfo);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        insuranceCompanyService.deleteById(id);
    }
}
