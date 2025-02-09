package tech.jhipster.lite.generator.server.springboot.logging.aop.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.jhipster.lite.generator.buildtool.generic.domain.BuildToolService;
import tech.jhipster.lite.generator.project.domain.ProjectRepository;
import tech.jhipster.lite.generator.server.springboot.common.domain.SpringBootCommonService;
import tech.jhipster.lite.generator.server.springboot.logging.aop.domain.AopLoggingDomainService;
import tech.jhipster.lite.generator.server.springboot.logging.aop.domain.AopLoggingService;

@Configuration
public class AopLoggingConfiguration {

  public final ProjectRepository projectRepository;
  public final BuildToolService buildToolService;
  public final SpringBootCommonService springBootCommonService;

  public AopLoggingConfiguration(
    ProjectRepository projectRepository,
    BuildToolService buildToolService,
    SpringBootCommonService springBootCommonService
  ) {
    this.projectRepository = projectRepository;
    this.buildToolService = buildToolService;
    this.springBootCommonService = springBootCommonService;
  }

  @Bean
  public AopLoggingService aopLoggingService() {
    return new AopLoggingDomainService(projectRepository, buildToolService, springBootCommonService);
  }
}
