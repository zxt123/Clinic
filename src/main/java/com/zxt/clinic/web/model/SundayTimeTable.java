package com.zxt.clinic.web.model;

public class SundayTimeTable{
    private boolean _10;
    private boolean _11;
    private boolean _12;
    private boolean _13;
    private boolean _14;
    public SundayTimeTable() {
        _10=false;
        _11=false;
        _12=false;
        _13=false;
        _14=false;
    }
    public static SundayTimeTable convertTo(WorkTimeTable workTimeTable){
        SundayTimeTable sundayTimeTable = new SundayTimeTable();
        sundayTimeTable.set_10(workTimeTable.is_10());
        sundayTimeTable.set_11(workTimeTable.is_11());
        sundayTimeTable.set_12(workTimeTable.is_12());
        sundayTimeTable.set_13(workTimeTable.is_13());
        sundayTimeTable.set_14(workTimeTable.is_14());
        return sundayTimeTable;
    }
    public boolean is_10() {
        return _10;
    }

    public void set_10(boolean _10) {
        this._10 = _10;
    }

    public boolean is_11() {
        return _11;
    }

    public void set_11(boolean _11) {
        this._11 = _11;
    }

    public boolean is_12() {
        return _12;
    }

    public void set_12(boolean _12) {
        this._12 = _12;
    }

    public boolean is_13() {
        return _13;
    }

    public void set_13(boolean _13) {
        this._13 = _13;
    }

    public boolean is_14() {
        return _14;
    }

    public void set_14(boolean _14) {
        this._14 = _14;
    }
}
