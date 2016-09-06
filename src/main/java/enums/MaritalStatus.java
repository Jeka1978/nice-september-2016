package enums;

import lombok.Getter;

/**
 * Created by Jeka on 06/09/2016.
 */
@Getter
public enum  MaritalStatus {
    SINGLE(1,"רווק"), MARRIED(2,"נשוי"), DIVORCED(3,"גרוש"), WIDOW(7,"אלמן");

    private final int dbCode;
    private final String hebrewDesc;

    MaritalStatus(int dbCode, String hebrewDesc) {
        this.dbCode= dbCode;
        this.hebrewDesc = hebrewDesc;
    }

    @Override
    public String toString() {
        return hebrewDesc;
    }

    public static MaritalStatus findByDbCode(int dbCode) {
        MaritalStatus[] statuses = values();
        for (MaritalStatus status : statuses) {
            if (status.dbCode == dbCode) {
                return status;
            }
        }
        throw new RuntimeException("dbcode " + dbCode + " not bound");
    }








}
