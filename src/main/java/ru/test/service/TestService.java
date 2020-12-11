package ru.test.service;

import ru.test.model.TestModel;

import java.sql.SQLException;

public interface TestService {

    String firstTestService(String path);

    void workWithDatabase(TestModel testModel) throws SQLException;

    TestModel findInDatabase(String userName);

}
