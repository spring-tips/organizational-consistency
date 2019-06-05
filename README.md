# Organizational Consistency

Hi Spring fans! In this installment we look at things you might do to achieve organizational consistency.



* autoconfiguration
* Starters 
* Spring javaformat plugin 
* initializr 
  Add something like this to your Initializr `application.yml`: 

  ```
    - name: Bootiful
      content:
        - name: Go Long!
          id: go-long
          groupId: com.joshlong
          artifactId: go-long
          versionRange: 1.2.0.RELEASE
          description: a library that will change your life
  ```
