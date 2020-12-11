package ru.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.test.model.TestModel;
import ru.test.service.TestService;

import java.sql.SQLException;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    public TestController(TestService testService) {
        this.testService = testService;
    }

    private final TestService testService;

    @RequestMapping(value = "/stringTest/{path}", method = RequestMethod.GET)
    public String testRest(@PathVariable(name = "path") String path) {
        return testService.firstTestService(path);
    }

    @PostMapping("/rest2")
    public void testRest2(@RequestBody TestModel passportImformation) throws SQLException {
        testService.workWithDatabase(passportImformation);
    }

    @GetMapping("/rest3")
    public TestModel testRest3(@RequestParam(name = "userName") String userName) {
        return testService.findInDatabase(userName);
    }


}
