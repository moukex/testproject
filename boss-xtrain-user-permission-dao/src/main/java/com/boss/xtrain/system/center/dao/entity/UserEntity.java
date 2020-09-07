package com.boss.xtrain.system.center.dao.entity;

import com.boss.xtrain.data.convertion.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "t_user")
public class UserEntity extends BaseEntity {

    /**
     * 用户id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 工号
     */
    @Column(name = "code")
    private String code;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 名字
     */
    @Column(name = "name")
    private String name;

    /**
     * 头像
     */
    @Column(name = "profile_picture")
    private String profilePicture;

    /**
     * 性别
     */
    @Column(name = "sex")
    private String sex;

    /**
     * 生日
     */
    @Column(name = "birthday")
    private Date birthday;

    /**
     * 电话
     */
    @Column(name = "tel")
    private String tel;

    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 其他联系
     */
    @Column(name = "other")
    private String other;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 状态位
     */
    @Column(name = "status")
    private Boolean status;

    /**
     * 创建人
     */
    @Column(name = "created_by")
    private Long createdBy;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 修改人
     */
    @Column(name = "updated_by")
    private Long updatedBy;

    /**
     * 修改时间
     */
    @Column(name = "updated_time")
    private Date updatedTime;

    /**
     * 版本
     */
    @Column(name = "version")
    private Long version;

    /**
     * 用户部门
     */
    @Column(name = "department")
    private Long department;

    /**
     * 用户职位
     */
    @Column(name = "position")
    private Long position;

    /**
     * 公司ID
     */
    @Column(name = "company_id")
    private Long companyId;

    /**
     * 获取用户id
     *
     * @return id - 用户id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置用户id
     *
     * @param id 用户id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取工号
     *
     * @return code - 工号
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置工号
     *
     * @param code 工号
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取名字
     *
     * @return name - 名字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名字
     *
     * @param name 名字
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取头像
     *
     * @return profile_picture - 头像
     */
    public String getProfilePicture() {
        return profilePicture;
    }

    /**
     * 设置头像
     *
     * @param profilePicture 头像
     */
    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取生日
     *
     * @return birthday - 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置生日
     *
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取电话
     *
     * @return tel - 电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置电话
     *
     * @param tel 电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取其他联系
     *
     * @return other - 其他联系
     */
    public String getOther() {
        return other;
    }

    /**
     * 设置其他联系
     *
     * @param other 其他联系
     */
    public void setOther(String other) {
        this.other = other;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取状态位
     *
     * @return status - 状态位
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置状态位
     *
     * @param status 状态位
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取创建人
     *
     * @return created_by - 创建人
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置创建人
     *
     * @param createdBy 创建人
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 获取创建时间
     *
     * @return created_time - 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置创建时间
     *
     * @param createdTime 创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取修改人
     *
     * @return updated_by - 修改人
     */
    public Long getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 设置修改人
     *
     * @param updatedBy 修改人
     */
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * 获取修改时间
     *
     * @return updated_time - 修改时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置修改时间
     *
     * @param updatedTime 修改时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * 获取版本
     *
     * @return version - 版本
     */
    public Long getVersion() {
        return version;
    }

    /**
     * 设置版本
     *
     * @param version 版本
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * 获取用户部门
     *
     * @return department - 用户部门
     */
    public Long getDepartment() {
        return department;
    }

    /**
     * 设置用户部门
     *
     * @param department 用户部门
     */
    public void setDepartment(Long department) {
        this.department = department;
    }

    /**
     * 获取用户职位
     *
     * @return position - 用户职位
     */
    public Long getPosition() {
        return position;
    }

    /**
     * 设置用户职位
     *
     * @param position 用户职位
     */
    public void setPosition(Long position) {
        this.position = position;
    }

    /**
     * 获取公司ID
     *
     * @return company_id - 公司ID
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * 设置公司ID
     *
     * @param companyId 公司ID
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
    }
