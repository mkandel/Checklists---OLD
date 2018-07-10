/*
 * Copyright (c) 2018. Marc Kandel
 */

package mkandel.entities;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @Column(columnDefinition = "char(36)")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @CreatedBy
    @Column(name = "CreateUser", columnDefinition = "char(36)")
    private String createUser;

    @CreatedDate
    @Column(name = "CreateDate")
    private LocalDateTime createDate;

    @LastModifiedBy
    @Column(name = "UpdateUser", columnDefinition = "char(36)")
    private String updateUser;

    @LastModifiedDate
    @Column(name = "UpdateDate")
    private LocalDateTime updateDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BaseEntity)) {
            return false;
        }

        final BaseEntity that = (BaseEntity) o;
        if (getId() == null && that.getId() == null) {
            return this == that;
        } else {
            return Objects.equals(getId(), that.getId());
        }
    }
}
