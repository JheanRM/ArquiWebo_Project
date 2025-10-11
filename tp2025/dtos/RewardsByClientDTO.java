package pe.edu.upc.tp2025.dtos;

public class RewardsByClientDTO {
    private String clientName;
    private String rewardName;

    public RewardsByClientDTO(String clientName, String rewardName) {
        this.clientName = clientName;
        this.rewardName = rewardName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }
}
