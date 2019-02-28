package org.wso2.carbon.sample.user.operation.event.listener;

import org.wso2.carbon.user.core.common.AbstractUserOperationEventListener;

import java.security.SecureRandom;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.wso2.carbon.user.core.UserStoreException;
import org.wso2.carbon.user.core.UserStoreManager;
import org.wso2.carbon.user.core.common.AbstractUserOperationEventListener;

public class CustomUserOperationEventListener extends AbstractUserOperationEventListener {
    private static final int PASSWORD_LENGTH = 10;
    private static final Random RANDOM = new SecureRandom();

    public CustomUserOperationEventListener() {
    }

    public int getExecutionOrderId() {
        return 94;
    }

    public boolean doPreAddUser(String userName, Object credential, String[] roleList, Map<String, String> claims, String profile, UserStoreManager userStoreManager) throws UserStoreException {
        if (StringUtils.isNotBlank((String) claims.get("http://wso2.org/claims/identity/askPassword")) && credential instanceof StringBuffer) {
            String characters = "23456789abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ!@#$%&*";
            String digits = "23456789";
            String lowercaseLetters = "abcdefghjkmnpqrstuvwxyz";
            String uppercaseLetters = "ABCDEFGHJKMNPQRSTUVWXYZ";
            int passwordLength = 10;
            int mandatoryCharactersCount = 3;
            StringBuilder pw = new StringBuilder();

            int index;
            for (int i = 0; i < passwordLength - mandatoryCharactersCount; ++i) {
                index = RANDOM.nextInt(characters.length());
                pw.append(characters.charAt(index));
            }

            index = RANDOM.nextInt(digits.length());
            pw.append(digits.charAt(index));
            index = RANDOM.nextInt(lowercaseLetters.length());
            pw.append(lowercaseLetters.charAt(index));
            index = RANDOM.nextInt(uppercaseLetters.length());
            pw.append(uppercaseLetters.charAt(index));
            char[] password = new char[pw.length()];
            pw.getChars(0, pw.length(), password, 0);
            ((StringBuffer) credential).setLength(0);
            ((StringBuffer) credential).append(password);
        }


        return true;
    }
}