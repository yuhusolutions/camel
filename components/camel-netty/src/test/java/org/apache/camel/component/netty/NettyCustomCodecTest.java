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
package org.apache.camel.component.netty;

import io.netty.channel.ChannelHandler;
import org.apache.camel.BindToRegistry;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.util.ObjectHelper;
import org.junit.jupiter.api.Test;

public class NettyCustomCodecTest extends BaseNettyTest {

    @BindToRegistry("myCustomDecoder")
    private ChannelHandlerFactory customDec = MyCustomCodec.createMyCustomDecoder();

    @BindToRegistry("myCustomDecoder2")
    private ChannelHandler customDec2 = MyCustomCodec.createMyCustomDecoder2();

    @BindToRegistry("myCustomEncoder")
    private ChannelHandler customEnc = MyCustomCodec.createMyCustomEncoder();

    private String uri = "netty:tcp://localhost:{{port}}?disconnect=true&sync=false"
                         + "&allowDefaultCodec=false&decoders=#myCustomDecoder,#myCustomDecoder2&encoders=#myCustomEncoder";

    // use reaadble bytes
    private byte[] data = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 0, 0 };

    @Test
    public void testCustomCodec() throws Exception {
        getMockEndpoint("mock:input").expectedMessageCount(1);

        template.sendBody(uri, data);

        assertMockEndpointsSatisfied();

        byte[] mockData = getMockEndpoint("mock:input").getReceivedExchanges().get(0).getIn().getBody(byte[].class);
        ObjectHelper.equalByteArray(data, mockData);
    }

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                from(uri).to("log:input").to("mock:input");
            }
        };
    }
}
