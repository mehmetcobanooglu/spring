package com.mehmet.maas_sistem.DTO;

public class MaasDTO {
    private Long employeeId;
    private String employeeName;
    private double aylikMaas;
    private double toplamAvans;
    private int gelmedigiGun;
    private double netMaas;

    public MaasDTO() {
    }

    public MaasDTO(Long employeeId, String employeeName, double aylikMaas, double toplamAvans, int gelmedigiGun,
            double netMaas) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.aylikMaas = aylikMaas;
        this.toplamAvans = toplamAvans;
        this.gelmedigiGun = gelmedigiGun;
        this.netMaas = netMaas;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getAylikMaas() {
        return aylikMaas;
    }

    public void setAylikMaas(double aylikMaas) {
        this.aylikMaas = aylikMaas;
    }

    public int getGelmedigiGun() {
        return gelmedigiGun;
    }

    public void setGelmedigiGun(int gelmedigiGun) {
        this.gelmedigiGun = gelmedigiGun;
    }

    public double getToplamAvans() {
        return toplamAvans;
    }

    public void setToplamAvans(double toplamAvans) {
        this.toplamAvans = toplamAvans;
    }

    public double getNetMaas() {
        return netMaas;
    }

    public void setNetMaas(double netMaas) {
        this.netMaas = netMaas;
    }
}
