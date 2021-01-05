package com.gorden5566.demos.pom;

import lombok.Data;

import java.util.Objects;

/**
 * @author gorden5566
 * @date 2020/10/12
 */
@Data
public class Artifact {
    private String groupId;
    private String artifactId;
    private String version;


    @Override
    public String toString() {
        return groupId + ':' + artifactId + ':' + version;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Artifact artifact = (Artifact) object;
        return Objects.equals(groupId, artifact.groupId) &&
            Objects.equals(artifactId, artifact.artifactId) &&
            Objects.equals(version, artifact.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, artifactId, version);
    }
}
