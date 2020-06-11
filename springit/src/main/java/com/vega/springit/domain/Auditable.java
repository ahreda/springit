package com.vega.springit.domain;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

public abstract class Auditable {

    @CreatedBy
    private String CreatedBy;
    @CreatedDate
    private LocalDateTime CreationDate;
    @LastModifiedBy
    private String LastModificationBy;
    @LastModifiedDate
    private LocalDateTime LastModificationDate;

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public LocalDateTime getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        CreationDate = creationDate;
    }

    public String getLastModificationBy() {
        return LastModificationBy;
    }

    public void setLastModificationBy(String lastModificationBy) {
        LastModificationBy = lastModificationBy;
    }

    public LocalDateTime getLastModificationDate() {
        return LastModificationDate;
    }

    public void setLastModificationDate(LocalDateTime lastModificationDate) {
        LastModificationDate = lastModificationDate;
    }
}
