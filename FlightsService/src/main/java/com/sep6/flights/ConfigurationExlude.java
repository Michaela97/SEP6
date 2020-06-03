package com.sep6.flights;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;
import org.springframework.boot.autoconfigure.cache.CouchbaseCacheConfiguration;
import org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseAutoConfiguration;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraReactiveDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraReactiveRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.couchbase.CouchbaseDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.couchbase.CouchbaseReactiveDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.couchbase.CouchbaseReactiveRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.couchbase.CouchbaseRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.elasticsearch.ReactiveElasticsearchRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.elasticsearch.ReactiveElasticsearchRestClientAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jdbc.JdbcRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.ldap.LdapRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoReactiveDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoReactiveRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.r2dbc.R2dbcDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.r2dbc.R2dbcRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.r2dbc.R2dbcTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisReactiveAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.data.solr.SolrRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchRestClientAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.autoconfigure.groovy.template.GroovyTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.autoconfigure.h2.H2ConsoleAutoConfiguration;
import org.springframework.boot.autoconfigure.hateoas.HypermediaAutoConfiguration;
import org.springframework.boot.autoconfigure.hazelcast.HazelcastAutoConfiguration;
import org.springframework.boot.autoconfigure.hazelcast.HazelcastJpaDependencyAutoConfiguration;
import org.springframework.boot.autoconfigure.influx.InfluxDbAutoConfiguration;
import org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration;
import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;
import org.springframework.boot.autoconfigure.jersey.JerseyAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.JndiConnectionFactoryAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisAutoConfiguration;
import org.springframework.boot.autoconfigure.jooq.JooqAutoConfiguration;
import org.springframework.boot.autoconfigure.jsonb.JsonbAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.boot.autoconfigure.ldap.LdapAutoConfiguration;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration;
import org.springframework.boot.autoconfigure.mail.MailSenderValidatorAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoReactiveAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mustache.MustacheAutoConfiguration;
import org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;
import org.springframework.boot.autoconfigure.rsocket.RSocketMessagingAutoConfiguration;
import org.springframework.boot.autoconfigure.rsocket.RSocketRequesterAutoConfiguration;
import org.springframework.boot.autoconfigure.rsocket.RSocketServerAutoConfiguration;
import org.springframework.boot.autoconfigure.rsocket.RSocketStrategiesAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.client.reactive.ReactiveOAuth2ClientAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.client.servlet.OAuth2ClientAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.resource.reactive.ReactiveOAuth2ResourceServerAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.rsocket.RSocketSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.autoconfigure.sendgrid.SendGridAutoConfiguration;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.boot.autoconfigure.solr.SolrAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.*;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.webservices.WebServicesAutoConfiguration;
import org.springframework.boot.autoconfigure.webservices.client.WebServiceTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.websocket.reactive.WebSocketReactiveAutoConfiguration;
import org.springframework.boot.autoconfigure.websocket.servlet.WebSocketMessagingAutoConfiguration;
import org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration(exclude = {ActiveMQAutoConfiguration.class, AopAutoConfiguration.class, ArtemisAutoConfiguration.class,
        BatchAutoConfiguration.class, CassandraAutoConfiguration.class, CassandraDataAutoConfiguration.class,
        CassandraReactiveDataAutoConfiguration.class, CassandraReactiveRepositoriesAutoConfiguration.class, CassandraRepositoriesAutoConfiguration.class,
        CouchbaseDataAutoConfiguration.class, CouchbaseReactiveDataAutoConfiguration.class, CouchbaseAutoConfiguration.class,
        CouchbaseReactiveRepositoriesAutoConfiguration.class, CouchbaseRepositoriesAutoConfiguration.class,
        DispatcherServletAutoConfiguration.class, EmbeddedLdapAutoConfiguration.class, ElasticsearchDataAutoConfiguration.class,
        ElasticsearchRepositoriesAutoConfiguration.class, ElasticsearchRestClientAutoConfiguration.class, EmbeddedMongoAutoConfiguration.class,
        ErrorMvcAutoConfiguration.class, FlywayAutoConfiguration.class, FreeMarkerAutoConfiguration.class, GroovyTemplateAutoConfiguration.class,
        GsonAutoConfiguration.class, H2ConsoleAutoConfiguration.class, HazelcastAutoConfiguration.class, HazelcastJpaDependencyAutoConfiguration.class,
        HypermediaAutoConfiguration.class, InfluxDbAutoConfiguration.class,
        IntegrationAutoConfiguration.class, JdbcRepositoriesAutoConfiguration.class, JerseyAutoConfiguration.class, JmsAutoConfiguration.class,
        JndiConnectionFactoryAutoConfiguration.class, JooqAutoConfiguration.class, JsonbAutoConfiguration.class, KafkaAutoConfiguration.class,
        LdapAutoConfiguration.class, LdapRepositoriesAutoConfiguration.class, LiquibaseAutoConfiguration.class, MailSenderAutoConfiguration.class,
        MailSenderValidatorAutoConfiguration.class, MessageSourceAutoConfiguration.class, MongoAutoConfiguration.class, MongoDataAutoConfiguration.class,
        MongoReactiveAutoConfiguration.class, MongoReactiveDataAutoConfiguration.class, MongoReactiveRepositoriesAutoConfiguration.class,
        MongoRepositoriesAutoConfiguration.class, MultipartAutoConfiguration.class, MustacheAutoConfiguration.class, Neo4jDataAutoConfiguration.class,
        Neo4jRepositoriesAutoConfiguration.class, OAuth2ClientAutoConfiguration.class, OAuth2ResourceServerAutoConfiguration.class,
        ProjectInfoAutoConfiguration.class, QuartzAutoConfiguration.class, R2dbcAutoConfiguration.class, R2dbcDataAutoConfiguration.class,
        R2dbcRepositoriesAutoConfiguration.class, R2dbcTransactionManagerAutoConfiguration.class, RSocketMessagingAutoConfiguration.class,
        RSocketRequesterAutoConfiguration.class, RSocketSecurityAutoConfiguration.class, RSocketServerAutoConfiguration.class,
        RSocketStrategiesAutoConfiguration.class, RabbitAutoConfiguration.class, ReactiveElasticsearchRepositoriesAutoConfiguration.class,
        ReactiveElasticsearchRestClientAutoConfiguration.class, ReactiveOAuth2ClientAutoConfiguration.class, ReactiveOAuth2ResourceServerAutoConfiguration.class,
        ReactiveSecurityAutoConfiguration.class, ReactiveUserDetailsServiceAutoConfiguration.class, RedisAutoConfiguration.class,
        RedisReactiveAutoConfiguration.class, RedisRepositoriesAutoConfiguration.class, RepositoryRestMvcAutoConfiguration.class,
        Saml2RelyingPartyAutoConfiguration.class, SecurityAutoConfiguration.class, SecurityFilterAutoConfiguration.class,
        SendGridAutoConfiguration.class,  SessionAutoConfiguration.class,
        SolrAutoConfiguration.class, SolrRepositoriesAutoConfiguration.class,
        ThymeleafAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class, ValidationAutoConfiguration.class,
        WebSocketMessagingAutoConfiguration.class, WebSocketReactiveAutoConfiguration.class, WebSocketServletAutoConfiguration.class,
})
public class ConfigurationExlude {
}