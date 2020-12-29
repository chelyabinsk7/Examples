package ru.zhenyaak.alfa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import lombok.Getter;
import lombok.Setter;

//Проверка, установлен ли Ломбок
public class UserIntegrationTest {
	
    @Test
    public void givenAnnotatedUser_thenHasGettersAndSetters() {
        User user = new User();
        user.setFirstName("Test");
        assertEquals(user.getFirstName(), "Test");
    }

    @Getter @Setter
    class User {
        private String firstName;
    }
}
