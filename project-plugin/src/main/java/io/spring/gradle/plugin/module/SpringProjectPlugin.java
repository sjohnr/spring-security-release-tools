/*
 * Copyright 2002-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.spring.gradle.plugin.module;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.BasePlugin;
import org.gradle.api.plugins.JavaLibraryPlugin;
import org.gradle.api.plugins.PluginManager;

import org.springframework.gradle.SpringJavaPlugin;
import org.springframework.gradle.classpath.SpringCheckClasspathForProhibitedDependenciesPlugin;
import org.springframework.gradle.classpath.SpringCheckProhibitedDependenciesLifecyclePlugin;

/**
 * @author Steve Riesenberg
 */
public class SpringProjectPlugin implements Plugin<Project> {

	@Override
	public void apply(Project project) {
		// Apply default plugins
		PluginManager pluginManager = project.getPluginManager();
		if (project.getRootProject().equals(project)) {
			pluginManager.apply(BasePlugin.class);
			// pluginManager.apply(SpringNoHttpPlugin.class);
			pluginManager.apply(SpringCheckProhibitedDependenciesLifecyclePlugin.class);
		}
		else {
			pluginManager.apply(JavaLibraryPlugin.class);
			pluginManager.apply(SpringJavaPlugin.class);
			pluginManager.apply(SpringCheckClasspathForProhibitedDependenciesPlugin.class);
		}
	}

}
