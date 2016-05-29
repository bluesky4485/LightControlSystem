package com.gaogandeng.model;

/**
 * Created by gch on 16-5-29.
 */
public class DeviceStatusLog {
    private Integer id;
    private String deviceId;        //集中控制器号
    private Double longitude;       //经度
    private Double latitude;        //纬度
    private Integer northOrSouth;   //南北纬：1北纬，0南纬
    private Integer eastOrWest;     //东西经：1东经，0西经

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Integer getNorthOrSouth() {
        return northOrSouth;
    }

    public void setNorthOrSouth(Integer northOrSouth) {
        this.northOrSouth = northOrSouth;
    }

    public Integer getEastOrWest() {
        return eastOrWest;
    }

    public void setEastOrWest(Integer eastOrWest) {
        this.eastOrWest = eastOrWest;
    }
}
