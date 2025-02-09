package tech.jhipster.lite.generator.server.springboot.database.postgresql.domain;

import tech.jhipster.lite.generator.buildtool.generic.domain.Dependency;

public class Postgresql {

  public static final String POSTGRESQL_DOCKER_VERSION = "14.1";

  public static final String POSTGRESQL_DOCKER_IMAGE = "postgres:" + POSTGRESQL_DOCKER_VERSION;

  private Postgresql() {}

  public static String getPostgresqlDockerVersion() {
    return POSTGRESQL_DOCKER_VERSION;
  }

  public static String getPostgresqlDockerImage() {
    return POSTGRESQL_DOCKER_IMAGE;
  }

  public static Dependency psqlDriver() {
    return Dependency.builder().groupId("org.postgresql").artifactId("postgresql").build();
  }

  public static Dependency psqlHikari() {
    return Dependency.builder().groupId("com.zaxxer").artifactId("HikariCP").build();
  }

  public static Dependency psqlHibernateCore() {
    return Dependency.builder().groupId("org.hibernate").artifactId("hibernate-core").build();
  }
}
