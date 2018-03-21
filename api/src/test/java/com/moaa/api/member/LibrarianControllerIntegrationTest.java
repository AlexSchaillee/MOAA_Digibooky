
package com.moaa.api.member;

import com.moaa.domain.member.LibrarianRepository;
import com.moaa.domain.member.databases.LibrarianDataBase;
import com.moaa.service.member.LibrarianService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import static com.moaa.api.member.LibrarianDTO.librarianDTO;
import static org.springframework.boot.SpringApplication.run;
import static java.lang.String.format;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LibrarianControllerIntegrationTest.LibrarianControllerTestRunner.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LibrarianControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Inject
    private LibrarianRepository librarianRepository;

    @Test
    public void registerLibrarian() {
        LibrarianDTO librarianDTO = new TestRestTemplate()
                .postForObject(format("http://localhost:%s/%s", port, "librarian"),
                        librarianDTO().withFirstname("Donald").withLastName("Truck").withEmail("alex.schaillee@cm.be"),
                        LibrarianDTO.class);

/*Assertions.assertThat(librarianDTO.getLastName()).isNull();*/


        Assertions.assertThat(librarianDTO.getFirstName()).isEqualTo("Donald");
        Assertions.assertThat(librarianDTO.getLastName()).isEqualTo("Truck");
        Assertions.assertThat(librarianDTO.getEmail()).isEqualTo("alex.schaillee@cm.be");
    }

    @SpringBootApplication(scanBasePackages = {"com.moaa.api.member", "com.moaa.service.member", "com.moaa.domain.member"})
    public static class LibrarianControllerTestRunner{

        public static void main(String[] args) {
            run(LibrarianControllerTestRunner.class,args);
        }
    }
}


/*    @SpringBootApplication(scanBasePackages = {"com.moaa"})
    public class Application {

        public static void main(String[] args) {
            run(Application.class, args);
        }*//*
*/
/*

}*/

