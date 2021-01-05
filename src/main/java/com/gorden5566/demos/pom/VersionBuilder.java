package com.gorden5566.demos.pom;

import java.io.IOException;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * @author gorden5566
 * @date 2020/10/12
 */
public class VersionBuilder {

    public static final Logger logger = LoggerFactory.getLogger(VersionBuilder.class);
    private static final String RESOURCE_PATTERN = "/META-INF/**/pom.properties";
    private static ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
    private static final List<Artifact> ARTIFACT_LIST = new ArrayList<>();

    static {
        init();
    }

    public static void init() {
        String pattern = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + RESOURCE_PATTERN;

        Set<Artifact> artifacts = new HashSet<>();
        try {
            Resource[] resources = resourcePatternResolver.getResources(pattern);
            for (Resource resource : resources) {
                Properties properties = PropertiesLoaderUtils.loadProperties(resource);
                Artifact artifact = new Artifact();
                artifact.setGroupId(String.valueOf(properties.get("groupId")));
                artifact.setArtifactId(String.valueOf(properties.get("artifactId")));
                artifact.setVersion(String.valueOf(properties.get("version")));

                artifacts.add(artifact);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ARTIFACT_LIST.addAll(artifacts);
    }

    public static List<Artifact> getArtifacts() {
        return ARTIFACT_LIST;
    }
}
