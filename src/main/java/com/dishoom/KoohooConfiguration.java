package com.dishoom;

import com.fasterxml.jackson.annotation.JsonProperty;
import in.vectorpro.dropwizard.swagger.SwaggerBundleConfiguration;
import io.dropwizard.Configuration;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class KoohooConfiguration  extends Configuration{

  @NotNull
  @Valid
  @JsonProperty("swagger")
  public SwaggerBundleConfiguration swagger;

}
