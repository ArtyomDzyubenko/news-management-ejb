package com.epam.newsmanagement.ejb.entity;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "NEWS")
public class News {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "newsSequence")
    @SequenceGenerator(name = "newsSequence", sequenceName = "NEWS_SEQUENCE")
    @Column(name = "NEWS_ID")
    private Long id;

    @Column(name = "NEWS_TITLE")
    private String title;

    @Column(name = "NEWS_CREATE_DATE")
    private Date date;

    @Column(name = "NEWS_BRIEF")
    private String brief;

    @Column(name = "NEWS_CONTENT")
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder().build();
    }
}
