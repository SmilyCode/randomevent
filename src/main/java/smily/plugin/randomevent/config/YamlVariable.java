package smily.plugin.randomevent.config;

public class YamlVariable{
    private Integer cooldown;
    private Boolean started;
    private Integer day;

    public Boolean getStarted() {
        return started;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getCooldown() {
        return cooldown;
    }

    public void setCooldown(Integer cooldown) {
        this.cooldown = cooldown;
    }

    public void setStarted(Boolean started) {
        this.started = started;
    }
}