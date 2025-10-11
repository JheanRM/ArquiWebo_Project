package pe.edu.upc.tp2025.dtos;

public class ClientDeviceCountDTO {
    private String clientName;
    private Long deviceCount;
    private Integer instalationDate;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Long getDeviceCount() {
        return deviceCount;
    }

    public void setDeviceCount(Long deviceCount) {
        this.deviceCount = deviceCount;
    }

    public Integer getInstalationDate() {
        return instalationDate;
    }

    public void setInstalationDate(Integer instalationDate) {
        this.instalationDate = instalationDate;
    }
}
