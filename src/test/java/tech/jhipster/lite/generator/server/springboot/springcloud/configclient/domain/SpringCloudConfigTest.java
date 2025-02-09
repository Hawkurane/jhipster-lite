package tech.jhipster.lite.generator.server.springboot.springcloud.configclient.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import tech.jhipster.lite.UnitTest;
import tech.jhipster.lite.generator.buildtool.generic.domain.Dependency;

@UnitTest
class SpringCloudConfigTest {

  @Test
  void shouldGetJhipsterRegistryDockerImageName() {
    assertThat(SpringCloudConfig.getJhipsterRegistryDockerImage()).isEqualTo("jhipster/jhipster-registry:v7.1.0");
  }

  @Test
  void shouldGetSpringCloudBootstrap() {
    Dependency dependency = SpringCloudConfig.springCloudBootstrap();

    assertThat(dependency.getGroupId()).isEqualTo("org.springframework.cloud");
    assertThat(dependency.getArtifactId()).isEqualTo("spring-cloud-starter-bootstrap");
  }

  @Test
  void shouldGetSpringCloudDependencies() {
    Dependency dependency = SpringCloudConfig.springCloudDependencies();

    assertThat(dependency.getGroupId()).isEqualTo("org.springframework.cloud");
    assertThat(dependency.getArtifactId()).isEqualTo("spring-cloud-dependencies");
  }

  @Test
  void shouldGetSpringCloudConfigClient() {
    Dependency dependency = SpringCloudConfig.springCloudConfigClient();

    assertThat(dependency.getGroupId()).isEqualTo("org.springframework.cloud");
    assertThat(dependency.getArtifactId()).isEqualTo("spring-cloud-starter-config");
  }
}
