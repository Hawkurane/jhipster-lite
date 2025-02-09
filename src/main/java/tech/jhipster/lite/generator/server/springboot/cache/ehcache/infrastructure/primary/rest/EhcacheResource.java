package tech.jhipster.lite.generator.server.springboot.cache.ehcache.infrastructure.primary.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.jhipster.lite.generator.project.domain.Project;
import tech.jhipster.lite.generator.project.infrastructure.primary.dto.ProjectDTO;
import tech.jhipster.lite.generator.server.springboot.cache.ehcache.application.EhcacheApplicationService;
import tech.jhipster.lite.technical.infrastructure.primary.annotation.GeneratorStep;

@RestController
@RequestMapping("/api/servers/spring-boot/cache/ehcache")
@Tag(name = "Spring Boot - Cache")
class EhcacheResource {

  private final EhcacheApplicationService ehcacheApplicationService;

  public EhcacheResource(EhcacheApplicationService ehcacheApplicationService) {
    this.ehcacheApplicationService = ehcacheApplicationService;
  }

  @Operation(summary = "Add Ehcache with Java configuration")
  @ApiResponse(responseCode = "500", description = "An error occurred while adding Ehcache with Java configuration")
  @PostMapping("java-configuration")
  @GeneratorStep(id = "ehcache-with-java-config")
  public void initJavaConfiguration(@RequestBody ProjectDTO projectDTO) {
    Project project = ProjectDTO.toProject(projectDTO);
    ehcacheApplicationService.initJavaConfiguration(project);
  }

  @Operation(summary = "Add Ehcache with XML configuration")
  @ApiResponse(responseCode = "500", description = "An error occurred while adding Ehcache with XML configuration")
  @PostMapping("xml-configuration")
  @GeneratorStep(id = "ehcache-with-xml-config")
  public void initXmlConfiguration(@RequestBody ProjectDTO projectDTO) {
    Project project = ProjectDTO.toProject(projectDTO);
    ehcacheApplicationService.initXmlConfiguration(project);
  }
}
