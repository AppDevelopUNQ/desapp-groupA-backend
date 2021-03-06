package ar.edu.unq.desapp.grupoa.backenddesappapi.requestbody.user;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.requestbody.UserBodyPost;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.MailValidation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserBodyPostTest {

    private UserBodyPost body;

    @BeforeEach
    void setUp() {
        body = new UserBodyPost("", "", "a@gmail.com", "");
    }

    @AfterEach
    void tearDown() {
        body = null;
    }

    @Test
    public void test00WhenADonationThatIsEmptyReceivesTheAnyGetterMessageResponseWithNull(){
        assertEquals(body.getName(), "");
        assertEquals(body.getNickname(), "");
        assertEquals(body.getEmail(), "a@gmail.com");
        assertEquals(body.getPassword(), "");
    }

    @Test
    public void test01WhenADonationThatIsEmptyReceivesTheAnyGetterMessageResponseWithNull(){
        body.setName("a");
        assertEquals(body.getName(), "a");
        body.setNickname("a");
        assertEquals(body.getNickname(), "a");
        body.setEmail("A@gmail.com");
        assertEquals(body.getEmail(), "A@gmail.com");
        body.setPassword("password");
        assertEquals(body.getPassword(), "password");
    }

    @Test
    public void test02WhenADonationThatIsEmptyReceivesTheAnyGetterMessageResponseWithNull() throws MailValidation {
        User user = body.setValues(new User());

        assertEquals(body.getName(), user.getName());
        assertEquals(body.getNickname(), user.getNickname());
        assertEquals(body.getEmail(), user.getEmail());
        assertEquals(body.getPassword(), user.getPassword());
    }
}
