package com.include.demo.design.chain;

/**
 * @author: chenshuo
 * @Date: 2023-08-16
 * @Time: 15:40
 * @version： 1.0
 * @Description:
 **/
public class GatewayEntity {

    private String name;

    private String conference;

    private Integer handlerId;

    private Integer preHandlerId;

    private Integer nextHandlerId;

    public GatewayEntity(Integer handlerId,String name, String conference,  Integer preHandlerId, Integer nextHandlerId) {
        this.name = name;
        this.conference = conference;
        this.handlerId = handlerId;
        this.preHandlerId = preHandlerId;
        this.nextHandlerId = nextHandlerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public Integer getHandlerId() {
        return handlerId;
    }

    public void setHandlerId(Integer handlerId) {
        this.handlerId = handlerId;
    }

    public Integer getPreHandlerId() {
        return preHandlerId;
    }

    public void setPreHandlerId(Integer preHandlerId) {
        this.preHandlerId = preHandlerId;
    }

    public Integer getNextHandlerId() {
        return nextHandlerId;
    }

    public void setNextHandlerId(Integer nextHandlerId) {
        this.nextHandlerId = nextHandlerId;
    }

}