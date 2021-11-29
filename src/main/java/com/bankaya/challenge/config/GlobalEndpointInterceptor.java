package com.bankaya.challenge.config;

import com.bankaya.challenge.model.RequestHistory;
import com.bankaya.challenge.repository.RequestHistoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.server.endpoint.MethodEndpoint;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;

@Slf4j
@Component
@AllArgsConstructor
public class GlobalEndpointInterceptor implements EndpointInterceptor {

    private HttpServletRequest httpServletRequest;
    private RequestHistoryRepository requestHistoryRepository;

    @Override
    public boolean handleRequest(MessageContext messageContext, Object endpoint) throws Exception {
        log.debug("Global Request Handling");
        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext, Object endpoint) throws Exception {
        log.debug("Global Response Handling");
        requestHistoryRepository.save(buildRequestHistory(messageContext, endpoint, true));
        return true;
    }

    @Override
    public boolean handleFault(MessageContext messageContext, Object endpoint) throws Exception {
        log.debug("Global Exception Handling");
        requestHistoryRepository.save(buildRequestHistory(messageContext, endpoint, false));
        return true;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Object endpoint, Exception ex) throws Exception {
        log.debug("Execute Code After Completion");
    }

    private RequestHistory buildRequestHistory(MessageContext messageContext, Object endpoint, boolean successful) throws IOException {
        var method = endpoint instanceof MethodEndpoint ? ((MethodEndpoint) endpoint).getMethod().getName() : null;
        return RequestHistory.builder()
                .method(method)
                .sourceIp(httpServletRequest.getRemoteAddr())
                .requestDate(OffsetDateTime.now())
                .successful(successful)
                .request(getMessageContent(messageContext.getRequest()))
                .build();
    }

    private String getMessageContent(WebServiceMessage message) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        message.writeTo(bos);
        return bos.toString(StandardCharsets.UTF_8);
    }

}
