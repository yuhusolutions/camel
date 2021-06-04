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
package org.apache.camel.builder.component.dsl;

import javax.annotation.Generated;
import org.apache.camel.Component;
import org.apache.camel.builder.component.AbstractComponentBuilder;
import org.apache.camel.builder.component.ComponentBuilder;
import org.apache.camel.component.aws.firehose.KinesisFirehoseComponent;

/**
 * Consume data from AWS Kinesis Firehose streams.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.maven.packaging.ComponentDslMojo")
public interface AwsKinesisFirehoseComponentBuilderFactory {

    /**
     * AWS Kinesis Firehose (camel-aws-kinesis)
     * Consume data from AWS Kinesis Firehose streams.
     * 
     * Category: cloud,messaging
     * Since: 2.19
     * Maven coordinates: org.apache.camel:camel-aws-kinesis
     * 
     * @return the dsl builder
     */
    static AwsKinesisFirehoseComponentBuilder awsKinesisFirehose() {
        return new AwsKinesisFirehoseComponentBuilderImpl();
    }

    /**
     * Builder for the AWS Kinesis Firehose component.
     */
    interface AwsKinesisFirehoseComponentBuilder
            extends
                ComponentBuilder<KinesisFirehoseComponent> {
        /**
         * Amazon Kinesis Firehose client to use for all requests for this
         * endpoint.
         * 
         * The option is a:
         * &lt;code&gt;com.amazonaws.services.kinesisfirehose.AmazonKinesisFirehose&lt;/code&gt; type.
         * 
         * Group: producer
         * 
         * @param amazonKinesisFirehoseClient the value to set
         * @return the dsl builder
         */
        default AwsKinesisFirehoseComponentBuilder amazonKinesisFirehoseClient(
                com.amazonaws.services.kinesisfirehose.AmazonKinesisFirehose amazonKinesisFirehoseClient) {
            doSetProperty("amazonKinesisFirehoseClient", amazonKinesisFirehoseClient);
            return this;
        }
        /**
         * Setting the autoDiscoverClient mechanism, if true, the component will
         * look for a client instance in the registry automatically otherwise it
         * will skip that checking.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: true
         * Group: common
         * 
         * @param autoDiscoverClient the value to set
         * @return the dsl builder
         */
        default AwsKinesisFirehoseComponentBuilder autoDiscoverClient(
                boolean autoDiscoverClient) {
            doSetProperty("autoDiscoverClient", autoDiscoverClient);
            return this;
        }
        /**
         * The component configuration.
         * 
         * The option is a:
         * &lt;code&gt;org.apache.camel.component.aws.firehose.KinesisFirehoseConfiguration&lt;/code&gt; type.
         * 
         * Group: producer
         * 
         * @param configuration the value to set
         * @return the dsl builder
         */
        default AwsKinesisFirehoseComponentBuilder configuration(
                org.apache.camel.component.aws.firehose.KinesisFirehoseConfiguration configuration) {
            doSetProperty("configuration", configuration);
            return this;
        }
        /**
         * Whether the producer should be started lazy (on the first message).
         * By starting lazy you can use this to allow CamelContext and routes to
         * startup in situations where a producer may otherwise fail during
         * starting and cause the route to fail being started. By deferring this
         * startup to be lazy then the startup failure can be handled during
         * routing messages via Camel's routing error handlers. Beware that when
         * the first message is processed then creating and starting the
         * producer may take a little time and prolong the total processing time
         * of the processing.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: false
         * Group: producer
         * 
         * @param lazyStartProducer the value to set
         * @return the dsl builder
         */
        default AwsKinesisFirehoseComponentBuilder lazyStartProducer(
                boolean lazyStartProducer) {
            doSetProperty("lazyStartProducer", lazyStartProducer);
            return this;
        }
        /**
         * To define a proxy host when instantiating the Kinesis Firehose
         * client.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: producer
         * 
         * @param proxyHost the value to set
         * @return the dsl builder
         */
        default AwsKinesisFirehoseComponentBuilder proxyHost(
                java.lang.String proxyHost) {
            doSetProperty("proxyHost", proxyHost);
            return this;
        }
        /**
         * To define a proxy port when instantiating the Kinesis Firehose
         * client.
         * 
         * The option is a: &lt;code&gt;java.lang.Integer&lt;/code&gt; type.
         * 
         * Group: producer
         * 
         * @param proxyPort the value to set
         * @return the dsl builder
         */
        default AwsKinesisFirehoseComponentBuilder proxyPort(
                java.lang.Integer proxyPort) {
            doSetProperty("proxyPort", proxyPort);
            return this;
        }
        /**
         * To define a proxy protocol when instantiating the Kinesis Firehose
         * client.
         * 
         * The option is a: &lt;code&gt;com.amazonaws.Protocol&lt;/code&gt;
         * type.
         * 
         * Default: HTTPS
         * Group: producer
         * 
         * @param proxyProtocol the value to set
         * @return the dsl builder
         */
        default AwsKinesisFirehoseComponentBuilder proxyProtocol(
                com.amazonaws.Protocol proxyProtocol) {
            doSetProperty("proxyProtocol", proxyProtocol);
            return this;
        }
        /**
         * The region in which Kinesis client needs to work. When using this
         * parameter, the configuration will expect the capitalized name of the
         * region (for example AP_EAST_1)You'll need to use the name
         * Regions.EU_WEST_1.name().
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: producer
         * 
         * @param region the value to set
         * @return the dsl builder
         */
        default AwsKinesisFirehoseComponentBuilder region(
                java.lang.String region) {
            doSetProperty("region", region);
            return this;
        }
        /**
         * Whether autowiring is enabled. This is used for automatic autowiring
         * options (the option must be marked as autowired) by looking up in the
         * registry to find if there is a single instance of matching type,
         * which then gets configured on the component. This can be used for
         * automatic configuring JDBC data sources, JMS connection factories,
         * AWS Clients, etc.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: true
         * Group: advanced
         * 
         * @param autowiredEnabled the value to set
         * @return the dsl builder
         */
        default AwsKinesisFirehoseComponentBuilder autowiredEnabled(
                boolean autowiredEnabled) {
            doSetProperty("autowiredEnabled", autowiredEnabled);
            return this;
        }
        /**
         * Amazon AWS Access Key.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: security
         * 
         * @param accessKey the value to set
         * @return the dsl builder
         */
        default AwsKinesisFirehoseComponentBuilder accessKey(
                java.lang.String accessKey) {
            doSetProperty("accessKey", accessKey);
            return this;
        }
        /**
         * Amazon AWS Secret Key.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: security
         * 
         * @param secretKey the value to set
         * @return the dsl builder
         */
        default AwsKinesisFirehoseComponentBuilder secretKey(
                java.lang.String secretKey) {
            doSetProperty("secretKey", secretKey);
            return this;
        }
    }

    class AwsKinesisFirehoseComponentBuilderImpl
            extends
                AbstractComponentBuilder<KinesisFirehoseComponent>
            implements
                AwsKinesisFirehoseComponentBuilder {
        @Override
        protected KinesisFirehoseComponent buildConcreteComponent() {
            return new KinesisFirehoseComponent();
        }
        private org.apache.camel.component.aws.firehose.KinesisFirehoseConfiguration getOrCreateConfiguration(
                org.apache.camel.component.aws.firehose.KinesisFirehoseComponent component) {
            if (component.getConfiguration() == null) {
                component.setConfiguration(new org.apache.camel.component.aws.firehose.KinesisFirehoseConfiguration());
            }
            return component.getConfiguration();
        }
        @Override
        protected boolean setPropertyOnComponent(
                Component component,
                String name,
                Object value) {
            switch (name) {
            case "amazonKinesisFirehoseClient": getOrCreateConfiguration((KinesisFirehoseComponent) component).setAmazonKinesisFirehoseClient((com.amazonaws.services.kinesisfirehose.AmazonKinesisFirehose) value); return true;
            case "autoDiscoverClient": getOrCreateConfiguration((KinesisFirehoseComponent) component).setAutoDiscoverClient((boolean) value); return true;
            case "configuration": ((KinesisFirehoseComponent) component).setConfiguration((org.apache.camel.component.aws.firehose.KinesisFirehoseConfiguration) value); return true;
            case "lazyStartProducer": ((KinesisFirehoseComponent) component).setLazyStartProducer((boolean) value); return true;
            case "proxyHost": getOrCreateConfiguration((KinesisFirehoseComponent) component).setProxyHost((java.lang.String) value); return true;
            case "proxyPort": getOrCreateConfiguration((KinesisFirehoseComponent) component).setProxyPort((java.lang.Integer) value); return true;
            case "proxyProtocol": getOrCreateConfiguration((KinesisFirehoseComponent) component).setProxyProtocol((com.amazonaws.Protocol) value); return true;
            case "region": getOrCreateConfiguration((KinesisFirehoseComponent) component).setRegion((java.lang.String) value); return true;
            case "autowiredEnabled": ((KinesisFirehoseComponent) component).setAutowiredEnabled((boolean) value); return true;
            case "accessKey": getOrCreateConfiguration((KinesisFirehoseComponent) component).setAccessKey((java.lang.String) value); return true;
            case "secretKey": getOrCreateConfiguration((KinesisFirehoseComponent) component).setSecretKey((java.lang.String) value); return true;
            default: return false;
            }
        }
    }
}