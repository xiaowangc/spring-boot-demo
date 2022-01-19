package com.chige.retrying;

import com.github.rholder.retry.Attempt;
import com.github.rholder.retry.RetryListener;


/**
 *  该监听类可以获取当前重试信息
 */
public class WebResponseListener implements RetryListener {

    @Override
    public <Response> void onRetry(Attempt<Response> attempt) {
        // 获取第n次尝试
        long attemptNumber = attempt.getAttemptNumber();
        // 距离第一次重试的延迟
        long delaySinceFirstAttempt = attempt.getDelaySinceFirstAttempt();
        if (attemptNumber == 3) {
            if (attempt.hasException()) {
                //达到第3次重试了还是存在异常，则进行相应的告警处理
            }
        }
        if (attempt.hasException()) {
            // 获取异常的原因
            String exceptionCause = attempt.getExceptionCause().toString();
        }else {
            Response result = attempt.getResult();
            System.out.println("相应结果打印：" + result);
        }
    }
    public WebResponseListener() {}

}
