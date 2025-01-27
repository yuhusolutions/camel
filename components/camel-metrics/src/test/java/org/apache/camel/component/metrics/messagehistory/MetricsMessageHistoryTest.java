/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.metrics.messagehistory;

import com.codahale.metrics.MetricRegistry;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MetricsMessageHistoryTest extends CamelTestSupport {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private MetricRegistry registry = new MetricRegistry();

    @Override
    protected CamelContext createCamelContext() throws Exception {
        CamelContext context = super.createCamelContext();

        MetricsMessageHistoryFactory factory = new MetricsMessageHistoryFactory();
        factory.setUseJmx(false);
        factory.setMetricsRegistry(registry);
        context.setMessageHistoryFactory(factory);

        return context;
    }

    @Test
    public void testMetricsHistory() throws Exception {
        getMockEndpoint("mock:foo").expectedMessageCount(5);
        getMockEndpoint("mock:bar").expectedMessageCount(5);
        getMockEndpoint("mock:baz").expectedMessageCount(5);

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                template.sendBody("seda:foo", "Hello " + i);
            } else {
                template.sendBody("seda:bar", "Hello " + i);
            }
        }

        assertMockEndpointsSatisfied();

        // there should be 3 names
        assertEquals(3, registry.getNames().size());

        // get the message history service
        MetricsMessageHistoryService service = context.hasService(MetricsMessageHistoryService.class);
        assertNotNull(service);
        String json = service.dumpStatisticsAsJson();
        assertNotNull(json);
        log.info(json);

        assertTrue(json.contains("foo.history"));
        assertTrue(json.contains("bar.history"));
        assertTrue(json.contains("baz.history"));
    }

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                from("seda:foo")
                        .to("mock:foo").id("foo");

                from("seda:bar")
                        .to("mock:bar").id("bar")
                        .to("mock:baz").id("baz");
            }
        };
    }
}
