package cn.suqc.entity;

public class PCAInfo {
    private String pCode;
    private String cCode;
    private String aCode;

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public String getcCode() {
        return cCode;
    }

    public void setcCode(String cCode) {
        this.cCode = cCode;
    }

    public String getaCode() {
        return aCode;
    }

    public void setaCode(String aCode) {
        this.aCode = aCode;
    }

    @Override
    public String toString() {
        return "PCAInfo{" +
                "pCode='" + pCode + '\'' +
                ", cCode='" + cCode + '\'' +
                ", aCode='" + aCode + '\'' +
                '}';
    }
}
