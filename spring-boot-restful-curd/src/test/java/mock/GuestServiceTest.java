package mock;

import com.chige.dao.GuestDao;
import com.chige.domain.Guest;
import com.chige.service.impl.GuestServiceImp;
import com.jayway.jsonpath.JsonPath;
import lombok.extern.slf4j.Slf4j;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.List;

/**
 * @author wangyc
 * @date 2021/12/16
 */
@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class GuestServiceTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Rule
    public ExpectedException thrown = ExpectedException.none(); //忽略异常

    @InjectMocks
    private GuestServiceImp guestServiceImp; // 目标测试类
    @Mock
    private GuestDao guestDao;

    @Test
    public void testGuest() {
        List<Guest> guests = guestServiceImp.allGuests();
        Guest guest = guestServiceImp.selectOne("啊");
        log.info("guests = {}", JsonPath.parse(guests).jsonString());
        log.info("guest = {}", guest);
    }



}
