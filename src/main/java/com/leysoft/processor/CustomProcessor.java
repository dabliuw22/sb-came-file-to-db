
package com.leysoft.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomProcessor implements Processor {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        LOGGER.info("body -> {}", exchange.getIn().getBody());
    }
}
