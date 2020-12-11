package ru.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.test.model.TestModel;

public interface TestRepository extends JpaRepository<TestModel, Long> {

    TestModel findByUserName(String userName);


}
