package com.processpuzzle.fitnesse.launcher.maven.plugin.artifact.resolver;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.DefaultArtifact;
import org.apache.maven.artifact.handler.DefaultArtifactHandler;
import org.junit.Assert;
import org.junit.Test;

import com.processpuzzle.fitnesse.launcher.maven.plugin.artifact.resolver.OptionalArtifactFilter;

public class OptionalArtifactFilterTest {

	@Test
	public void testOptionalArtifactFilter() {
        Artifact artifact = new DefaultArtifact(
        	getClass().getPackage().getName(), getClass().getSimpleName(),
        	"version", "scope", "type", "classifier", new DefaultArtifactHandler());
        
		artifact.setOptional(false);
		Assert.assertTrue(OptionalArtifactFilter.INSTANCE.include(artifact));
		
		artifact.setOptional(true);
		Assert.assertFalse(OptionalArtifactFilter.INSTANCE.include(artifact));
	}
}
