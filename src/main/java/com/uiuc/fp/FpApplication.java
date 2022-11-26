package com.uiuc.fp;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.Type;

@SpringBootApplication
@AllArgsConstructor
public class FpApplication {

  private EntityManager entityManager;

  public static void main(String[] args) {
    SpringApplication.run(FpApplication.class, args);
  }

  /**
   * This method is used to return the autogenerated @Id fields from the Repository classes
   *
   * @return RepositoryRestConfigurer
   */
  @Bean
  public RepositoryRestConfigurer repositoryRestConfigurer() {
    return RepositoryRestConfigurer.withConfig(config -> config.exposeIdsFor(entityManager.getMetamodel()
            .getEntities()
            .stream()
            .map(Type::getJavaType)
            .toArray(Class[]::new)));
  }

}
