package com.ashehata.validateme;

import com.ashehata.mylibrary.ValidateErrorType;
import com.ashehata.mylibrary.ValidateME;
import com.ashehata.mylibrary.ValidateModel;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static com.ashehata.mylibrary.ValidateErrorType.*;

public class Try {

    public void doIt() {
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
    }
}
