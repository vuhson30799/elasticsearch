package com.example.elasticsearch;


import com.example.elasticsearch.book.service.EmployeeService;
import com.example.elasticsearch.book.service.EmployeeEsServiceImpl;
import com.example.elasticsearch.book.service.EmployeeServiceImpl;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.net.InetAddress;

@SpringBootApplication(scanBasePackages = {"com.example.elasticsearch.book.service","com.example.elasticsearch.book.controller","com.example.elasticsearch.book.model"})
@EnableJpaRepositories(basePackages = "com.example.elasticsearch.book.repository")
@EntityScan(basePackages = "com.example.elasticsearch.book.model")
@EnableElasticsearchRepositories(basePackages = "com.example.elasticsearch.book.elasticsearchRepository")
public class ElasticsearchApplication {

    @Value("${spring.data.elasticsearch.clustername}")
    private String esClusterName;

    @Bean
    public Client client() throws Exception {

        Settings esSettings = Settings.builder()
                .put("cluster.name", "elasticsearch")
                .build();



        //https://www.elastic.co/guide/en/elasticsearch/guide/current/_transport_client_versus_node_client.html
        return new PreBuiltTransportClient(esSettings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300))
                .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));
    }

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchApplication.class, args);
    }

}
