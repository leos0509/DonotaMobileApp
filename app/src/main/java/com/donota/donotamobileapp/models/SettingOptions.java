package com.donota.donotamobileapp.models;

public class SettingOptions {
    String settingID;
    int settingIcon;
    String settingName;

    public SettingOptions(String settingID, int settingIcon, String settingName) {
        this.settingID = settingID;
        this.settingIcon = settingIcon;
        this.settingName = settingName;
    }

    public String getSettingID() {
        return this.settingID;
    }

    public void setSettingID(String settingID) {
        this.settingID = settingID;
    }

    public int getSettingIcon() {
        return this.settingIcon;
    }

    public void setSettingIcon(int settingIcon) {
        this.settingIcon = settingIcon;
    }

    public String getSettingName() {
        return this.settingName;
    }

    public void setSettingName(String settingName) {
        this.settingName = settingName;
    }
}
