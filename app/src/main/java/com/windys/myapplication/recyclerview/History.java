package com.windys.myapplication.recyclerview;

public class History {
    private int point;
    private String title;
    private String icon;
    private int balance;
    private int type;
    private int typeAdd;
    private String createDateStr;
    private String createData;
    private String code;
    private String addpointCode;
    private int customerId;
    private int historyId;

    public History(String title, String icon, int point) {
        this.title = title;
        this.icon = icon;
        this.point = point;
    }



    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getTypeAdd() {
        return typeAdd;
    }

    public void setTypeAdd(int typeAdd) {
        this.typeAdd = typeAdd;
    }

    public String getCreateDateStr() {
        return createDateStr;
    }

    public void setCreateDateStr(String createDateStr) {
        this.createDateStr = createDateStr;
    }

    public String getCreateData() {
        return createData;
    }

    public void setCreateData(String createData) {
        this.createData = createData;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddpointCode() {
        return addpointCode;
    }

    public void setAddpointCode(String addpointCode) {
        this.addpointCode = addpointCode;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public History(String title, String icon, int balance, int type, int typeAdd, String createDateStr,
                   String createData, String code, String addpointCode, int customerId, int historyId, int point) {
        this.title = title;
        this.icon = icon;
        this.balance = balance;
        this.type = type;
        this.typeAdd = typeAdd;
        this.createDateStr = createDateStr;
        this.createData = createData;
        this.code = code;
        this.addpointCode = addpointCode;
        this.customerId = customerId;
        this.historyId = historyId;
        this.point = point;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getTitle() {
        return title;
    }

    public int getPoint() {
        return point;
    }

    public History(String title, int point) {
        this.title = title;
        this.point = point;
    }
}
