# SecondsPicker-Android77
A Dialog-based library shown to the UI to Pick Hour Minutes and Seconds from Android

`implementation 'com.github.RedEyesNCode:SecondsPicker-Android77:1.0.8'`

For Publising Kotlin Android Library to Jitpack Follow below steps

#### Step 1
_Add this in the library.gradle file_
- 'plugins {
  id 'com.android.library'
  id 'kotlin-android'
  id 'maven-publish'
  }'

#### Step 2
_Put this at the end of the gradle file._
- afterEvaluate {
  publishing {
  publications {
  release(MavenPublication) {
  from components.release
  groupId = "your.package.name"
  artifactId = "your_lib_name"
  version = 'lib_version'
  }
  }
  }
  }

#### Step 4
_Run the following gradle task_
`./gradlew publishReleasePublicationToMavenLocal`