package com.ashehata.mylibrary

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ValidateMETest {

    @Test
    fun `validateRegularNumber() correct num between min and max and correct digit return true`() {
        val result = ValidateME.validateRegularNumber(
            3,
            1,
            10,
            2
        )
        assertThat(result.isValid).isTrue()
    }

    @Test
    fun `validateRegularNumber() enter wrong num between min and max and correct digit return false`() {
        val result = ValidateME.validateRegularNumber(
            50,
            0,
            20,
            3
        )
        assertThat(result.isValid).isFalse()
    }

    @Test
    fun `validateRegularNumber() enter correct num between min and max and wrong digit return false`() {
        val result = ValidateME.validateRegularNumber(
            5,
            1,
            10,
            0
        )
        assertThat(result.isValid).isFalse()
    }


    @Test
    fun `enter wrong num between min and max and wrong digit`() {
        val result = ValidateME.validateRegularNumber(
            50,
            0,
            20,
            1
        )
        assertThat(result.isValid).isFalse()
    }

    @Test
    fun `enter num = max and wrong digit`() {
        val result = ValidateME.validateRegularNumber(
            50,
            50,
            20,
            1
        )
        assertThat(result.isValid).isFalse()
    }


    @Test
    fun `enter num = min and correct digit`() {
        val result = ValidateME.validateRegularNumber(
            20,
            20,
            50,
            2
        )
        assertThat(result.isValid).isTrue()
    }

    @Test
    fun `enter num = min = max,  correct digit`() {
        val result = ValidateME.validateRegularNumber(
            20,
            20,
            20,
            2
        )
        assertThat(result.isValid).isTrue()
    }


    @Test
    fun `enter num = min = max, digit more than them`() {
        val result = ValidateME.validateRegularNumber(
            10,
            10,
            10,
            5
        )
        assertThat(result.isValid).isTrue()
    }


    @Test
    fun `enter num = min = max, digit less than them`() {
        val result = ValidateME.validateRegularNumber(
            10,
            10,
            10,
            1
        )
        assertThat(result.isValid).isFalse()
    }

    @Test
    fun `enter num = min = max = digit = 0`() {
        val result = ValidateME.validateRegularNumber(
            0,
            0,
            0,
            0
        )
        assertThat(result.isValid).isFalse()
    }

    @Test
    fun `enter num = min = max = digit = 1`() {
        val result = ValidateME.validateRegularNumber(
            1,
            1,
            1,
            1
        )
        assertThat(result.isValid).isTrue()
    }

    @Test
    fun `enter num, minus min and max, correct digit`() {
        val result = ValidateME.validateRegularNumber(
            -10,
            -50,
            -1,
            2
        )
        assertThat(result.isValid).isTrue()
    }

    @Test
    fun `enter num, minus min and max, wrong digit`() {
        val result = ValidateME.validateRegularNumber(
            -10,
            -50,
            -1,
            0
        )
        assertThat(result.isValid).isFalse()
    }

    @Test
    fun `enter inverse max with min, correct digit`() {
        val result = ValidateME.validateRegularNumber(
            -15,
            -10,
            -50,
            2
        )
        assertThat(result.isValid).isFalse()
    }

    @Test
    fun `enter correct date to validate num`() {
        val result = ValidateME.validatePhoneNumber(
            "01064261149",
            11
        )
        assertThat(result.isValid).isTrue()
    }

    @Test
    fun `validatePhoneNumber() enter nums with letter return false`() {
        val result = ValidateME.validatePhoneNumber(
            "01064j611pk",
            11
        )
        assertThat(result.isValid).isFalse()
    }

    @Test
    fun `enter wrong num`() {
        val result = ValidateME.validatePhoneNumber(
            "010642619",
            11
        )
        assertThat(result.isValid).isFalse()
    }

    @Test
    fun `enter correct num with minus maxValue`() {
        val result = ValidateME.validatePhoneNumber(
            "01064261149",
            -11
        )
        assertThat(result.isValid).isFalse()
    }

    @Test
    fun `enter empty data`() {
        val result = ValidateME.validatePhoneNumber(
            "",
            0
        )
        assertThat(result.isValid).isFalse()
    }

    @Test
    fun `enter valide yahoo`() {
        val result = ValidateME.validateEmail(
            "ahme@yahoo.com"
        )
        assertThat(result).isEqualTo(ValidateModel(true))
    }

    @Test
    fun `enter valide gmail`() {
        val result = ValidateME.validateEmail(
            "ahme1234@gamil.com"
        )
        assertThat(result).isEqualTo(ValidateModel(true))
    }

    @Test
    fun `enter empty gmail`() {
        val result = ValidateME.validateEmail(
            ""
        )
        assertThat(result).isEqualTo(ValidateModel(false, ValidateErrorType.Email))
    }

    @Test
    fun `validateEmail() enter invalide gmail`() {
        val result = ValidateME.validateEmail(
            "ahme@gmail2.com"
        )
        assertThat(result).isEqualTo(ValidateModel(false, ValidateErrorType.Email))
    }

    @Test
    fun `validateEmail() enter invalide yahoo`() {
        val result = ValidateME.validateEmail(
            "ahme@yaho2.co"
        )
        assertThat(result).isEqualTo(ValidateModel(false, ValidateErrorType.Email))
    }


    @Test
    fun `enter valid pass`() {
        val result = ValidateME.validatePassword(
            "ahme@yah/",
            5
        )
        assertThat(result).isEqualTo(ValidateModel(true))
    }

    @Test
    fun `enter empty pass`() {
        val result = ValidateME.validatePassword(
            "",
            20
        )
        assertThat(result).isEqualTo(ValidateModel(false, ValidateErrorType.Password))
    }


    @Test
    fun `enter max lenght less than pass`() {
        val result = ValidateME.validatePassword(
            "sddfdffds",
            5
        )
        assertThat(result).isEqualTo(ValidateModel(true))
    }

    @Test
    fun `enter max lenght = pass`() {
        val result = ValidateME.validatePassword(
            "asdasd",
            6
        )
        assertThat(result).isEqualTo(ValidateModel(true))
    }

    @Test
    fun `validatePasswordAndConfirm(), pass = confirm pass return true`() {
        val result = ValidateME.validatePasswordAndConfirm(
            "ahmed",
            "ahmed",
            5
        )
        assertThat(result).isEqualTo(ValidateModel(true))
    }

    @Test
    fun `validatePasswordAndConfirm(), pass != confirm pass return false`() {
        val result = ValidateME.validatePasswordAndConfirm(
            "ahmed",
            "ahm22",
            3
        )
        assertThat(result).isEqualTo(ValidateModel(false, ValidateErrorType.PasswordConfirm))
    }

    @Test
    fun `validatePasswordAndConfirm(), pass == confirm pass but minChar less, return false`() {
        val result = ValidateME.validatePasswordAndConfirm(
            "ahmed",
            "ahmed",
            6
        )
        assertThat(result).isEqualTo(ValidateModel(false, ValidateErrorType.PasswordConfirm))
    }


    @Test
    fun `validateCustom(), pattern = mytText, return true`() {
        val result = ValidateME.validateCustom(
            "[a-zA-Z0-9]",
            "f"
        )
        assertThat(result).isEqualTo(ValidateModel(true))
    }


    @Test
    fun `checkAllValidation(), pass valid fields`() {
        ValidateME.checkAllValidation(
            listOf(
                ValidateME.validateEmail("ahsdw@yahoo.com"),
                ValidateME.validateRegularNumber(20, 0, 10, 1),
                ValidateME.validatePhoneNumber("01064261149", 9)
                /**
                 *   add more validation types here
                 */
            ),
            onValidationResult = object : ValidateME.OnValidationResult {
                override fun onSuccess() {
                    // so, continue your flow after a successfully validation
                    println("Success")

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
                    println(value)
                }
            }
        )

        assertThat(true)
    }

    @Test
    fun `checkAllValidation(), pass invalid confirm pass and email  field`() {
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
                    println("Success")

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
                    println("$value $validatePosition")
                    assertThat(validateErrorType).isEqualTo(ValidateErrorType.PasswordConfirm)
                }
            }
        )

    }
}