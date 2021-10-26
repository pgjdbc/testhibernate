/*
 * Copyright (c) 2021, Dave Cramer
 * See the LICENSE file in the project root for more information.
 */


package org.postgresql.model;

import  javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="datetime")

public class TestTimeDate {
    @Id
    @GeneratedValue
    private Long id;

    private Date dateval;
    private Timestamp timestamp;
    private Duration duration;
    private Instant instant;
    private LocalDate localDate;
    private LocalDateTime localDateTime;

    public TestTimeDate() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateval() {
        return dateval;
    }

    public void setDateval(Date dateval) {
        this.dateval = dateval;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
