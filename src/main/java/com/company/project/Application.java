package com.company.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot默认支持两种技术来和 ES 交互
 * 1：Jest（默认不生效）。需要导入相应的jar包生效
 * 2：SpringData ElasticSearch（这里需要注意SpringBoot的版本(2.1.4.RELEASE) 与 ES的版本(6.4.0)兼容 ）
 * https://github.com/spring-projects/spring-data-elasticsearch
 *    1)、Client 节点信息clusterNodes; clusterName
 *    2)、ElasticSearchTemplate操作es
 */
@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
