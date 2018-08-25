
package com.leysoft.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.leysoft.model.Person;
import com.leysoft.processor.CustomProcessor;
import com.leysoft.processor.SqlProcessor;

@Component
public class CustomCamelRoute extends RouteBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomCamelRoute.class);

    @Value(
            value = "${route.from}")
    private String from;

    @Value(
            value = "${route.to}")
    private String to;

    @Autowired
    private CustomProcessor customProcessor;

    @Autowired
    private SqlProcessor sqlProcessor;

    @Override
    public void configure() throws Exception {
        DataFormat dataFormat = new BindyCsvDataFormat(Person.class);
        onException(Exception.class).handled(true).log(LoggingLevel.ERROR, "Error")
                .process(exchange -> LOGGER.info("Error process..."));
        from(from).log("from -> ${body}").process(customProcessor).unmarshal(dataFormat)
                .log("unmarshal -> ${body}").split(body()).log("split -> ${body}")
                .process(sqlProcessor).to(to).end().process(exchange -> LOGGER.info("Success..."));
    }
}
