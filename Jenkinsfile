/*
 * Hibernate Tools, Tooling for your Hibernate Projects
 * 
 * Copyright 2016-2024 Red Hat, Inc.
 *
 * Licensed under the GNU Lesser General Public License (LGPL), 
 * version 2.1 or later (the "License").
 * You may not use this file except in compliance with the License.
 * You may read the licence in the 'lgpl.txt' file in the root folder of 
 * project or obtain a copy at
 *
 *     http://www.gnu.org/licenses/lgpl-2.1.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@Library('hibernate-jenkins-pipeline-helpers') _

pipeline {
	agent {
		label 'Worker&&Containers'
	}
	tools {
		maven 'Apache Maven 3.9'
		jdk 'OpenJDK 21 Latest'
	}
	options {
		buildDiscarder logRotator(daysToKeepStr: '30', numToKeepStr: '10')
		disableConcurrentBuilds(abortPrevious: false)
	}
	stages {
		stage('Build') {
			when {
				beforeAgent true
				// Releases must be triggered explicitly
				// This is just for safety; normally the Jenkins job for this pipeline
				// should be configured to "Suppress automatic SCM triggering"
				// See https://stackoverflow.com/questions/58259326/prevent-jenkins-multibranch-pipeline-from-triggering-builds-for-new-branches
				triggeredBy cause: "UserIdCause"
			}
			steps {
				script {
					withMaven(mavenLocalRepo: env.WORKSPACE_TMP + '/.m2repository') {
						sh "mvn clean install"
					}
				}
			}
		}
	}
	post {
		always {
			notifyBuildResult notifySuccessAfterSuccess: true, maintainers: 'koen@hibernate.org'
		}
	}
}
