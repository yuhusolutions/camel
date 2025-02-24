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
package org.apache.camel.component.azure.storage.blob.integration;

import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.azure.storage.blob.BlobConstants;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

@Ignore("Requires real credentials")
class BlobCopyProducerIt extends CamelTestSupport {

    @EndpointInject
    private ProducerTemplate template;

    @Test
    void testCopyBlob() {

        template.send("direct:uploadBlockBlob", exchange -> {
            exchange.getIn().setHeader(BlobConstants.BLOB_NAME, "pmi.txt");
            exchange.getMessage().setHeader(BlobConstants.SOURCE_BLOB_CONTAINER_NAME, "test214");
            exchange.getMessage().setHeader(BlobConstants.SOURCE_BLOB_ACCOUNT_NAME, "testblob214");
        });

    }

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                from("direct:copyBlob")
                        .to("azure-storage-blob://testblob214/test215?operation=copyBlob&sourceBlobAccessKey=RAW(sourceAccessKey)&credentialType=SHARED_ACCOUNT_KEY&accessKey=(accessKey)");
            }
        };
    }
}
