package mock;

import com.chige.service.GuestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author wangyc
 * @date 2021/12/16
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GuestControllerTest {
    @Autowired
    private WebApplicationContext wc;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GuestService guestService;
    @Test
    public void test() {
        System.out.println();
        Mockito.doReturn("合理").when(guestService).allGuests();
    }
}
