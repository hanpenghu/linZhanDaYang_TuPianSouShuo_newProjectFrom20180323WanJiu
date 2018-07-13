package com.winwin.picreport.Edto;

public class ModelUsersSpcKey {
    private String usersUuid;

    private String ctrlId;

    private String modelUuid;

    public String getUsersUuid() {
        return usersUuid;
    }

    public void setUsersUuid(String usersUuid) {
        this.usersUuid = usersUuid == null ? null : usersUuid.trim();
    }

    public String getCtrlId() {
        return ctrlId;
    }

    public void setCtrlId(String ctrlId) {
        this.ctrlId = ctrlId == null ? null : ctrlId.trim();
    }

    public String getModelUuid() {
        return modelUuid;
    }

    public void setModelUuid(String modelUuid) {
        this.modelUuid = modelUuid == null ? null : modelUuid.trim();
    }
}