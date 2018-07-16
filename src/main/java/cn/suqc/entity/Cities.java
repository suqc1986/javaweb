package cn.suqc.entity;

import java.util.List;

public class Cities {
    private Integer id;
    private String provinceCode;
    private String cityCode;
    private String cityName;
    //一对多
    private List<Areas> areasList;

    public Cities(Integer id, String provinceCode, String cityCode, String cityName) {
        this.id = id;
        this.provinceCode = provinceCode;
        this.cityCode = cityCode;
        this.cityName = cityName;
    }

    public List<Areas> getAreasList() {
        return areasList;
    }

    public void setAreasList(List<Areas> areasList) {
        this.areasList = areasList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
