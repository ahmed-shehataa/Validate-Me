package com.ashehata.mylibrary

import org.jetbrains.annotations.NotNull
import java.util.regex.Pattern
import kotlin.math.absoluteValue

class ValidateME {

    interface OnValidationResult {
        fun onSuccess()
        fun onError(validateErrorType: ValidateErrorType?, validatePosition: Int)
    }

    companion object {

        /**
         * Tested with 14 test case on test source set file
         */
        @JvmStatic
        fun validateRegularNumber(
            @NotNull yourNum: Int,
            @NotNull minValue: Int,
            @NotNull maxValue: Int,
            @NotNull maxNumDigit: Int
        ): ValidateModel {
            if (maxNumDigit < yourNum.absoluteValue.toString().trim().length) {
                return ValidateModel(false, ValidateErrorType.RegularNumber)
            }
            if (!(yourNum in minValue..maxValue))
                return ValidateModel(false, ValidateErrorType.RegularNumber)

            return ValidateModel(true)
        }

        @JvmStatic
        fun validatePhoneNumber(
            @NotNull yourNum: String,
            @NotNull maxValue: Int
        ): ValidateModel {
            val length = yourNum.trim().length
            if (length == 0 || maxValue == 0) return ValidateModel(
                false,
                ValidateErrorType.PhoneNumber
            )
            if (length != maxValue) return ValidateModel(false, ValidateErrorType.PhoneNumber)

            val result = Pattern.compile("[0-9]{$maxValue}").matcher(yourNum.trim()).matches()
            if (!result) return ValidateModel(false, ValidateErrorType.PhoneNumber)

            return ValidateModel(true)
        }

        @JvmStatic
        fun validateEmail(@NotNull email: String): ValidateModel {
            if (email.trim().isEmpty()) {
                return ValidateModel(false, ValidateErrorType.Email);
            } else {
                val pattern = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z.-]+$"
                val isValid =
                    Pattern.compile(pattern, Pattern.CASE_INSENSITIVE).matcher(email.trim()).matches()
                if (isValid)
                    return ValidateModel(true);
                else
                    return ValidateModel(false, ValidateErrorType.Email);
            }
        }

        @JvmStatic
        fun validatePassword(pass: String, minLength: Int): ValidateModel {
            if (pass.trim().isEmpty() || pass.trim().length < minLength)
                return ValidateModel(false, ValidateErrorType.Password)
            else
                return ValidateModel(true)

        }

        @JvmStatic
        fun validatePasswordAndConfirm(pass: String, confirmPass: String, minChar: Int): ValidateModel {
            if (pass.length < minChar || confirmPass.length < minChar) {
                return ValidateModel(false, ValidateErrorType.PasswordConfirm)
            }

            if (!pass.equals(confirmPass)) {
                return ValidateModel(false, ValidateErrorType.PasswordConfirm)
            }
            return ValidateModel(true)

        }


        @JvmStatic
        fun checkAllValidation(
            elements: List<ValidateModel>,
            onValidationResult: OnValidationResult
        ) {
            val validationFields = elements.asSequence()
            var position = -1
            val error = validationFields.firstOrNull {
                position ++
                !it.isValid
            }

            error?.let {
                onValidationResult.onError(it.validateErrorType, position)

            } ?: onValidationResult.onSuccess()

        }

        @JvmStatic
        fun validateCustom(pattern: String, yourField: String): ValidateModel {
            if (Pattern.compile(pattern).matcher(yourField).matches()) {
                return ValidateModel(true)
            } else
                return ValidateModel(false, ValidateErrorType.Custom)
        }


    }
}
