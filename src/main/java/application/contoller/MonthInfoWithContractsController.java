package application.contoller;

import application.service.MonthInfoWithContractsService;
import org.springframework.web.bind.annotation.*;


@RestController
public class MonthInfoWithContractsController {

    private MonthInfoWithContractsService monthInfoWithContractsService;

    public MonthInfoWithContractsController(MonthInfoWithContractsService monthInfoWithContractsService) {
        this.monthInfoWithContractsService = monthInfoWithContractsService;
    }

    @PostMapping("/add/{month_id}/{contract_id}")
    public void add(@PathVariable("month_id") Integer monthId, @PathVariable("contract_id") Integer contractId) {
        monthInfoWithContractsService.addContract(monthId, contractId);
    }

    @DeleteMapping("/delete/{month_id}/{contract_id}")
    public void delete(@PathVariable("month_id") Integer monthId, @PathVariable("contract_id") Integer contractId) {
        monthInfoWithContractsService.deleteContract(monthId, contractId);
    }
}
