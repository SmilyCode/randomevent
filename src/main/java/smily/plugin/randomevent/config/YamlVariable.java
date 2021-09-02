package smily.plugin.randomevent.config;

import smily.plugin.randomevent.event.pt.PtLightningEvent;

public class YamlVariable{
    private Integer cooldown;
    private Boolean started;
    private Integer day;
    private PtEventConfigVariable pt_event;

    public Boolean getStarted() {
        return started;
    }

    public PtEventConfigVariable getPt_event() {
        return pt_event;
    }

    public void setPt_event(PtEventConfigVariable pt_event) {
        this.pt_event = pt_event;
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
