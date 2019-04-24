package com.zxt.clinic.web.model;

public class WorkDayTimeTable {
    private boolean _10;
    private boolean _11;
    private boolean _12;
    private boolean _13;
    private boolean _14;
    private boolean _15;
    private boolean _16;
    private boolean _17;
    private boolean _18;
    private boolean _19;
    private boolean _20;
    public WorkDayTimeTable() {
        _10=false;
        _11=false;
        _12=false;
        _13=false;
        _14=false;
        _15=false;
        _16=false;
        _17=false;
        _18=false;
        _19=false;
        _20=false;
    }
    public static WorkDayTimeTable convertTo(WorkTimeTable workTimeTable){
        WorkDayTimeTable workDayTimeTable = new WorkDayTimeTable();
        workDayTimeTable.set_10(workTimeTable.is_10());
        workDayTimeTable.set_11(workTimeTable.is_11());
        workDayTimeTable.set_12(workTimeTable.is_12());
        workDayTimeTable.set_13(workTimeTable.is_13());
        workDayTimeTable.set_14(workTimeTable.is_14());
        workDayTimeTable.set_15(workTimeTable.is_15());
        workDayTimeTable.set_16(workTimeTable.is_16());
        workDayTimeTable.set_17(workTimeTable.is_17());
        workDayTimeTable.set_18(workTimeTable.is_18());
        workDayTimeTable.set_19(workTimeTable.is_19());
        workDayTimeTable.set_20(workTimeTable.is_20());
        return workDayTimeTable;
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

    public boolean is_15() {
        return _15;
    }

    public void set_15(boolean _15) {
        this._15 = _15;
    }

    public boolean is_16() {
        return _16;
    }

    public void set_16(boolean _16) {
        this._16 = _16;
    }

    public boolean is_17() {
        return _17;
    }

    public void set_17(boolean _17) {
        this._17 = _17;
    }

    public boolean is_18() {
        return _18;
    }

    public void set_18(boolean _18) {
        this._18 = _18;
    }

    public boolean is_19() {
        return _19;
    }

    public void set_19(boolean _19) {
        this._19 = _19;
    }

    public boolean is_20() {
        return _20;
    }

    public void set_20(boolean _20) {
        this._20 = _20;
    }
}
