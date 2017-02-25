package ru.tandser.polling.repository;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.tandser.polling.UserTestData;

@ActiveProfiles("localhost")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/repository.xml")
@Sql(scripts = "classpath:ddl/insert.ddl", config = @SqlConfig(encoding = "UTF-8"))
public abstract class AbstractRepositoryTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void beforeClass() throws Exception {
        UserTestData.loadMocks();
    }
}