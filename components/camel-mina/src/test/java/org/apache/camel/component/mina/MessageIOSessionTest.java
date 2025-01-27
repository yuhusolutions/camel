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
package org.apache.camel.component.mina;

import java.net.SocketAddress;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Unit test to check if the message of an exchange send from the MinaConsumer is a MinaMessage.
 */
public class MessageIOSessionTest extends BaseMinaTest {

    @Test
    public void testIoSession() throws Exception {
        MockEndpoint mock = getMockEndpoint("mock:result");
        mock.expectedMessageCount(1);
        template.sendBody(String.format("mina:tcp://localhost:%1$s?textline=true", getPort()), "Hello World");
        assertMockEndpointsSatisfied();

        Exchange exchange = mock.getExchanges().get(0);
        Message message = exchange.getIn();
        assertNotNull(message.getHeader(MinaConstants.MINA_IOSESSION));

    }

    @Test
    public void testLocalAndRemoteAddressHeaders() throws Exception {
        MockEndpoint mock = getMockEndpoint("mock:result");
        mock.expectedMessageCount(1);
        template.sendBody(String.format("mina:tcp://localhost:%1$s?textline=true", getPort()), "Hello World");
        assertMockEndpointsSatisfied();

        Message message = mock.getExchanges().get(0).getIn();
        // Not making assumptions on what these headers contain, because it might differ
        // on different machines/OSs.
        assertNotNull(message.getHeader(MinaConstants.MINA_LOCAL_ADDRESS, SocketAddress.class));
        assertNotNull(message.getHeader(MinaConstants.MINA_REMOTE_ADDRESS, SocketAddress.class));
    }

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {

            @Override
            public void configure() {
                from(String.format("mina:tcp://localhost:%1$s?textline=true", getPort()))
                        .to("log://mytest")
                        .to("mock:result");
            }
        };
    }
}
