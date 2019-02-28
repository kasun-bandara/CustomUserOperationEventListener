# Custom user operation event listner

This custom user operation event listner can be used to generate password which won't violate the predefined password policy [1] in the event of creating a user using the feature "Ask password from user"[2].

Generated password has following characteristics, 
* 10 characters
* numbers
* capital letters
* lowercase letters

[1] - https://docs.wso2.com/display/IS560/Password+Patterns

[2] - https://docs.wso2.com/display/IS560/Creating+Users+using+the+Ask+Password+Option

Build the project using following command
```
mnv clean install
```
