package tech.jhipster.lite.generator.server.springboot.logging.aop.application;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static tech.jhipster.lite.TestUtils.*;
import static tech.jhipster.lite.common.domain.FileUtils.getPath;
import static tech.jhipster.lite.generator.project.domain.Constants.*;
import static tech.jhipster.lite.generator.project.domain.Constants.POM_XML;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tech.jhipster.lite.IntegrationTest;
import tech.jhipster.lite.error.domain.GeneratorException;
import tech.jhipster.lite.generator.buildtool.maven.application.MavenApplicationService;
import tech.jhipster.lite.generator.init.application.InitApplicationService;
import tech.jhipster.lite.generator.project.domain.Project;
import tech.jhipster.lite.generator.server.springboot.core.application.SpringBootApplicationService;

@IntegrationTest
class AopLoggingApplicationServiceIT {

  @Autowired
  InitApplicationService initApplicationService;

  @Autowired
  MavenApplicationService mavenApplicationService;

  @Autowired
  SpringBootApplicationService springBootApplicationService;

  @Autowired
  AopLoggingApplicationService aopLoggingApplicationService;

  @Test
  void shouldInit() {
    Project project = tmpProject();
    project.addConfig("springBootVersion", "0.0.0");
    initApplicationService.init(project);
    mavenApplicationService.addPomXml(project);
    springBootApplicationService.init(project);

    aopLoggingApplicationService.init(project);

    assertFileContent(
      project,
      POM_XML,
      List.of("<groupId>org.springframework.boot</groupId>", "<artifactId>spring-boot-starter-aop</artifactId>")
    );

    assertFileExist(project, getPath(MAIN_JAVA, "com/mycompany/myapp/technical/infrastructure/secondary/aop/logging/LoggingAspect.java"));
    assertFileExist(
      project,
      getPath(MAIN_JAVA, "com/mycompany/myapp/technical/infrastructure/secondary/aop/logging/LoggingAspectConfiguration.java")
    );

    assertFileContent(project, getPath(MAIN_RESOURCES, "config/application.properties"), "application.aop.logging=false");
    assertFileContent(project, getPath(MAIN_RESOURCES, "config/application-local.properties"), "application.aop.logging=true");
    assertFileContent(project, getPath(TEST_RESOURCES, "config/application.properties"), "application.aop.logging=true");
  }

  @Test
  void shouldAddDialectJava() {
    Project project = tmpProject();
    project.addConfig("springBootVersion", "0.0.0");
    initApplicationService.init(project);
    mavenApplicationService.addPomXml(project);
    springBootApplicationService.init(project);

    aopLoggingApplicationService.addDialectJava(project);

    assertFileExist(project, getPath(MAIN_JAVA, "com/mycompany/myapp/technical/infrastructure/secondary/aop/logging/LoggingAspect.java"));
    assertFileExist(
      project,
      getPath(MAIN_JAVA, "com/mycompany/myapp/technical/infrastructure/secondary/aop/logging/LoggingAspectConfiguration.java")
    );
    assertFileExist(
      project,
      getPath(TEST_JAVA, "com/mycompany/myapp/technical/infrastructure/secondary/aop/logging/LoggingAspectTest.java")
    );
  }

  @Test
  void shouldMavenDependencies() {
    Project project = tmpProject();
    project.addConfig("springBootVersion", "0.0.0");
    initApplicationService.init(project);
    mavenApplicationService.addPomXml(project);

    aopLoggingApplicationService.addMavenDependencies(project);

    assertFileContent(
      project,
      POM_XML,
      List.of("<groupId>org.springframework.boot</groupId>", "<artifactId>spring-boot-starter-aop</artifactId>")
    );
  }

  @Test
  void shouldNotAddMavenDendenciesWhenNoPomXml() {
    Project project = tmpProject();

    assertThatThrownBy(() -> aopLoggingApplicationService.addMavenDependencies(project)).isExactlyInstanceOf(GeneratorException.class);
  }

  @Test
  void shoulAddProperties() {
    Project project = tmpProject();
    project.addConfig("springBootVersion", "0.0.0");
    initApplicationService.init(project);
    mavenApplicationService.addPomXml(project);
    springBootApplicationService.init(project);

    aopLoggingApplicationService.addProperties(project);

    assertFileContent(project, getPath(MAIN_RESOURCES, "config/application.properties"), "application.aop.logging=false");
    assertFileContent(project, getPath(MAIN_RESOURCES, "config/application-local.properties"), "application.aop.logging=true");
    assertFileContent(project, getPath(TEST_RESOURCES, "config/application.properties"), "application.aop.logging=true");
  }

  @Test
  void shouldNotAddPropertiesWhenNoSpringbootInit() {
    Project project = tmpProject();
    initApplicationService.init(project);

    assertThatThrownBy(() -> aopLoggingApplicationService.addProperties(project)).isExactlyInstanceOf(GeneratorException.class);
  }

  @Test
  void shouldAddJavaClasses() {
    Project project = tmpProject();
    initApplicationService.init(project);
    mavenApplicationService.addPomXml(project);
    springBootApplicationService.addMainApp(project);

    aopLoggingApplicationService.addDialectJava(project);

    assertFileExist(project, getPath(MAIN_JAVA, "com/mycompany/myapp/technical/infrastructure/secondary/aop/logging/LoggingAspect.java"));
    assertFileExist(
      project,
      getPath(MAIN_JAVA, "com/mycompany/myapp/technical/infrastructure/secondary/aop/logging/LoggingAspectConfiguration.java")
    );
    assertFileExist(
      project,
      getPath(TEST_JAVA, "com/mycompany/myapp/technical/infrastructure/secondary/aop/logging/LoggingAspectTest.java")
    );
  }
}
