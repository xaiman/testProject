package ru.test.service.impl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.test.exception.TestException;
import ru.test.model.TestModel;
import ru.test.repository.TestRepository;
import ru.test.service.TestService;

import java.sql.*;

@Service
public class TestServiceImpl implements TestService {


    @Autowired
    private TestRepository testRepository;

    @Override
    public String firstTestService(String path) {
        String result = path.concat(" World");
        return result;
    }

    @Override
    public void workWithDatabase(TestModel testModel) throws SQLException {

        /*
                Работа с базой без spring
        */
/*
        try(Connection connection1 = DriverManager.getConnection("","","")) {
            try (Statement statement = connection1.createStatement()) {

                // Просто вызов к базе
                String sql = "select * from testtable where userName = '123'";
                ResultSet resultSet = statement.executeQuery(sql);
                TestModel testModel1 = new TestModel();
                testModel.setUserName(resultSet.getString("userName"));

                // Вызов процедуры в базе с возвращаемым значением
                String callSql = "? = call test_proc_in_sql(?,?)";
                CallableStatement callableStatement = connection1.prepareCall(callSql);
                callableStatement.setString(1, "Petya");
                callableStatement.setString(2, "Vasya");
                //? = call test_proc_in_sql(Petya,Vasya)
                callableStatement.execute();
                callableStatement.close();

                // Вызов к базе с подготовков реквеста
                String preparedSql = "select * from testtable where userName = ?";
                PreparedStatement preparedStatement = connection1.prepareStatement(preparedSql);
                try {
                    preparedStatement.setString(1, "Hi");
                    ResultSet preparedResultSet = preparedStatement.executeQuery();
                }
                finally {
                    preparedStatement.close();
                }
            }
        }

        try {
            //Действие все проводим
        }
        catch ( Exception ex) {
            //Если ошибка, то попадаем сюда и обработка ее
        }
        finally {
            // выполняется всегда, последние методы
        }
*/
        testRepository.save(testModel);
    }

    @Override
    public TestModel findInDatabase(String userName) {
        TestModel result = testRepository.findByUserName(userName);
        if (result == null) {
            throw new TestException("No such user");
        }
        return result;
    }


}
