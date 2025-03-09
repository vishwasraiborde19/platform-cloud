package com.platform.webcore.rest.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.Objects;

@ConfigurationProperties(prefix = "com.platform.api")
@Component
@RefreshScope
public class RestProperties {
    private Map<String, String> templateMapping;

    public void setTemplateMapping(Map<String, String> templateMapping) {
        this.templateMapping = templateMapping;
        for (Map.Entry<String, String> stringStringEntry : templateMapping.entrySet()) {
            System.out.println("loaded properties: " + stringStringEntry.getKey() + " = " + stringStringEntry.getValue());
        }
    }

    public Map<String, String> getTemplateMapping() {
        return templateMapping;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RestProperties that = (RestProperties) o;
        return Objects.equals(templateMapping, that.templateMapping);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(templateMapping);
    }
}
