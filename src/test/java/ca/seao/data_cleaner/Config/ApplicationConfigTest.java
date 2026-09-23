package ca.seao.data_cleaner.Config;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest(classes = ApplicationConfig.class)
class ApplicationConfigTest {

    @Autowired
    private ApplicationConfig config;

    @Test
    void shouldLoadDataSourceProperties() {
        assertThat(config.getDbUrl()).isEqualTo("jdbc:postgresql://localhost:5432/seao");
        assertThat(config.getDbUser()).isEqualTo("tlemy");
        assertThat(config.getDbPass()).isEqualTo("pass1234");
    }
}
