package at.savovuksan.VSMServer.Security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

@SpringBootTest
public class BasicAuthUDSTests {

    @Autowired
    private BasicAuthUDS service;

    @Test
    public void shouldGetUserDetails(){
        UserDetails ud = service.loadUserByUsername("savo");
        assertNotNull(ud,"Couldn't find user savo");
        assertEquals("savo", ud.getUsername());

    }
}
