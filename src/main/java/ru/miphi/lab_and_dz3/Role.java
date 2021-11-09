package ru.miphi.lab_and_dz3;

public enum Role {
    STAFF(10), MANAGER(20), EXECUTIVE(30);
    int percentPremium;


    Role(int percentPremium) {
        this.percentPremium = percentPremium;
    }

    int getPercentPremium() {
        return percentPremium;
    }

}