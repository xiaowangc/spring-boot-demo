package com.chige.springannotation.async;

import com.chige.springannotation.SpringAnnotationApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringAnnotationApplication.class)
public class AsyncDemoTest {

    @Autowired
    private AsyncDemo asyncDemo;

    @Test
    public void test1() {
        for (int i = 0; i < 10; i++) {
            asyncDemo.userMyTaskExecutor(i);
        }
    }

}
