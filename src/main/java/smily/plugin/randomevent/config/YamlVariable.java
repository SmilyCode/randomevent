package smily.plugin.randomevent.config;

public class YamlVariable{
    public Integer cooldown;
    public Boolean started;
    public PtEventConfigVariable pt_event;

    public Boolean getStarted() {
        return started;
    }

    public PtEventConfigVariable getPt_event() {
        return pt_event;
    }

    public void setPt_event(PtEventConfigVariable pt_event) {
        this.pt_event = pt_event;
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
