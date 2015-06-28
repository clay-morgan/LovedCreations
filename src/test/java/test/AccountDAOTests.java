package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@ActiveProfiles( "development" )
@ContextConfiguration( locations = { "classpath:config/security-context.xml",
                                     "classpath:config/data-context.xml",
                                     "classpath:config/service-context.xml" })
@RunWith( SpringJUnit4ClassRunner.class )
public class AccountDAOTests
{
    @Test
    public void testAddUser()
    {
        assertEquals( "Dummy test", 1, 1 );
    }

}
