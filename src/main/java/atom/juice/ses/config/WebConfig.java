package atom.juice.ses.config;

import atom.juice.ses.serialization.converter.YamlJackson2HttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Map;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public static final MediaType APPLICATION_X_YAML = MediaType.valueOf("application/x-yaml");
    private static final Map<String, MediaType> MEDIA_TYPES = Map.of("json", MediaType.APPLICATION_JSON, "xml", MediaType.APPLICATION_XML, "x-yaml", APPLICATION_X_YAML);

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new YamlJackson2HttpMessageConverter());
    }


    /*
    * Deve ser acessado via HEADER PARAM.
    * */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorParameter(false).ignoreAcceptHeader(false).useRegisteredExtensionsOnly(false).defaultContentType(MediaType.APPLICATION_JSON).mediaTypes(MEDIA_TYPES);
    }

}
