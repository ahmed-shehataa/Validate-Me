# Validate-Me
An android lib to test validations by easy way (support both [java, kotlin])   
Validate-Me well tested using jUnit.

<p align="center">
	<img src="https://cdn-media-1.freecodecamp.org/images/1*otuQiVYDCBjZee9xZ0UnvA.jpeg"  width="800"  />
</p>

## Setup:   

**Step 1.** Add it in your root build.gradle at the end of repositories:

``` groovy
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

**Step 2.** Add the dependency
 
``` groovy
dependencies {
	  implementation 'com.github.Eng-AhmedShehata:Custom-View-Group-Loading:Tag'
	}
```

**Hint :**  
 replace Tag with latest verion here
 [![](https://jitpack.io/v/Eng-AhmedShehata/Custom-View-Group-Loading.svg)](https://jitpack.io/#Eng-AhmedShehata/Custom-View-Group-Loading)


---

## How to use it:   
TODO make a preview pic for methods

in kotlin:   

``` kotlin
ValidateME.checkAllValidation(
            listOf(
                ValidateME.validateEmail("ahsdw@yahoo.com"),
                ValidateME.validateRegularNumber(5, 0, 10, 1),
                ValidateME.validatePhoneNumber("01064261149", 11),
                ValidateME.validatePasswordAndConfirm("01064261149", "01064261149", 4),
                ValidateME.validatePasswordAndConfirm("01064261149", "0101414", 4),
                ValidateME.validateEmail("ahsdw@yah22o.com"),
                /**
                 *   add more validation types here
                 */
            ),
            onValidationResult = object : ValidateME.OnValidationResult {
                override fun onSuccess() {
                    // so, continue your flow after a successfully validation

                }

                override fun onError(validateErrorType: ValidateErrorType?, validatePosition: Int) {
                    // handle your error here after validation has failed
                    val value = when (validateErrorType) {
                        ValidateErrorType.PhoneNumber -> "phone"
                        ValidateErrorType.RegularNumber -> "num"
                        ValidateErrorType.Email -> "email"
                        ValidateErrorType.TextNumber -> "text"
                        ValidateErrorType.Password -> "pass"
                        ValidateErrorType.PasswordConfirm -> "confirm"
                        ValidateErrorType.Custom -> "custom"
                        null -> ""
                    }
                    
                }
            }
        )

```

in java:   
``` java
List<ValidateModel> validateModels = new ArrayList<>();

        validateModels.add(ValidateME.validateEmail("asdsadsadsad"));
        validateModels.add(ValidateME.validatePassword("1241", 5));
        validateModels.add(ValidateME.validatePhoneNumber("1071927410", 12));
        /*
         *   add more validation types here
         */

        // So now check all fields
        ValidateME.checkAllValidation(validateModels,
                new ValidateME.OnValidationResult() {
                    @Override
                    public void onSuccess() {
                        // so, continue your flow after a successfully validation
                    }

                    @Override
                    public void onError(@Nullable ValidateErrorType validateErrorType, int validatePosition) {
                        // handle your error here after validation has failed
                        switch (validateErrorType) {
                            case Email :
                                //TODO
                                break;
                            case PhoneNumber :
                                //TODO
                                break;
                            /*
                             * And so on
                             */

                        }
                    }
                }
        );
```

### Add your custom validation: (2 ways)   
### 1:
use ->  ValidateME.validateCustom(yourRegexPattern, yourText)   
``` kotlin
	ValidateME.validateCustom("[a-zA-Z0-9]{2}", "m2")
```
yourRegexPattern: Pass your [Regex Pattern](https://www.vogella.com/tutorials/JavaRegularExpressions/article.html) here.    
yourText: Pass your text the you wanna validate it.   

Then:  
Pass the ValidateME.validateCustom(yourRegexPattern, yourText) to validtor class like this   

``` kotlin

	ValidateME.checkAllValidation(
            listOf(
                ValidateME.validateEmail("ahsdw@yahoo.com"),
                ValidateME.validateCustom("[a-zA-Z0-9]{2}", "m2")
                /**
                 *   add more validation types here
                 */
            ),
            onValidationResult = object : ValidateME.OnValidationResult {
                override fun onSuccess() {
                    // so, continue your flow after a successfully validation

                }

                override fun onError(validateErrorType: ValidateErrorType?, validatePosition: Int) {
                    // handle your error here after validation has failed
                    val value = when (validateErrorType) {
                        ValidateErrorType.Custom -> "Custom error"
			// add other types here
                        
                    }
                    
                }
            }
        )
```



### 2: (more customization but need more code)

First:   
make your own validtor method and make it return a ValidateModel corresponding to your bussiness logic
Todo add example

Then:   
pass it to to validtor class like this   
TODO add pic

Finally:   
You can handle error message if not valid loke this.   
TODO add pic



