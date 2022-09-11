package com.example.controller;

import com.example.SwaggerConfig;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.views.View;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.inject.Inject;
import org.slf4j.LoggerFactory;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

import static java.util.Collections.singletonList;

@Hidden
@Controller("/api")
public class SwaggerController {

    @Inject
    SwaggerConfig config;

    @View("swagger/index")
    @Get("/swagger-ui.html")
    @PermitAll
    public SwaggerConfig index() {
        LoggerFactory.getLogger(SwaggerController.class).info("Trying to render swagger-view");
        return config;
    }

    @View("swagger/index")
    @Get("/api/{url}")
    @PermitAll
    public SwaggerConfig renderSpec(@NotNull String url) {
        return new SwaggerConfig.Builder()
                .withDeepLinking(config.isDeepLinking())
                .withLayout(config.getLayout())
                .withVersion(config.getVersion())
                .withUrls(singletonList(new SwaggerConfig.URIConfig.Builder()
                        .withName(url)
                        .withURI(url)
                        .build()))
                .build();
    }

    @View("swagger/index")
    @Post("/api")
    @PermitAll
    public SwaggerConfig renderSpecs(@Body @NotEmpty List<SwaggerConfig.URIConfig> urls) {
        return new SwaggerConfig.Builder()
                .withDeepLinking(config.isDeepLinking())
                .withLayout(config.getLayout())
                .withVersion(config.getVersion())
                .withUrls(urls)
                .build();
    }

}
