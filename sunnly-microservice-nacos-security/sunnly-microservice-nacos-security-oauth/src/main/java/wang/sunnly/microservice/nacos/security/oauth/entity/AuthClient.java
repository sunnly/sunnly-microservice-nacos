package wang.sunnly.microservice.nacos.security.oauth.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "auth_client")
public class AuthClient {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 服务编码
     */
    @Column(name = "code")
    private String code;

    /**
     * 服务密钥
     */
    @Column(name = "secret")
    private String secret;

    /**
     * 服务名
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 是否锁定
     */
    @Column(name = "locked")
    private String locked;

    /**
     * 描述
     */
    @Column(name = "description")
    private String description;

    /**
     * 创建时间
     */
    @Column(name = "crt_time")
    private Date crtTime;

    /**
     * 创建人
     */
    @Column(name = "crt_user")
    private String crtUser;

    /**
     * 创建人姓名
     */
    @Column(name = "crt_name")
    private String crtName;

    /**
     * 创建主机
     */
    @Column(name = "crt_host")
    private String crtHost;

    /**
     * 更新时间
     */
    @Column(name = "upd_time")
    private Date updTime;

    /**
     * 更新人
     */
    @Column(name = "upd_user")
    private String updUser;

    /**
     * 更新姓名
     */
    @Column(name = "upd_name")
    private String updName;

    /**
     * 更新主机
     */
    @Column(name = "upd_host")
    private String updHost;

    @Column(name = "attr1")
    private String attr1;

    @Column(name = "attr2")
    private String attr2;

    @Column(name = "attr3")
    private String attr3;

    @Column(name = "attr4")
    private String attr4;

    @Column(name = "attr5")
    private String attr5;

    @Column(name = "attr6")
    private String attr6;

    @Column(name = "attr7")
    private String attr7;

    @Column(name = "attr8")
    private String attr8;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取服务编码
     *
     * @return code - 服务编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置服务编码
     *
     * @param code 服务编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取服务密钥
     *
     * @return secret - 服务密钥
     */
    public String getSecret() {
        return secret;
    }

    /**
     * 设置服务密钥
     *
     * @param secret 服务密钥
     */
    public void setSecret(String secret) {
        this.secret = secret;
    }

    /**
     * 获取服务名
     *
     * @return name - 服务名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置服务名
     *
     * @param name 服务名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取是否锁定
     *
     * @return locked - 是否锁定
     */
    public String getLocked() {
        return locked;
    }

    /**
     * 设置是否锁定
     *
     * @param locked 是否锁定
     */
    public void setLocked(String locked) {
        this.locked = locked;
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取创建时间
     *
     * @return crt_time - 创建时间
     */
    public Date getCrtTime() {
        return crtTime;
    }

    /**
     * 设置创建时间
     *
     * @param crtTime 创建时间
     */
    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    /**
     * 获取创建人
     *
     * @return crt_user - 创建人
     */
    public String getCrtUser() {
        return crtUser;
    }

    /**
     * 设置创建人
     *
     * @param crtUser 创建人
     */
    public void setCrtUser(String crtUser) {
        this.crtUser = crtUser;
    }

    /**
     * 获取创建人姓名
     *
     * @return crt_name - 创建人姓名
     */
    public String getCrtName() {
        return crtName;
    }

    /**
     * 设置创建人姓名
     *
     * @param crtName 创建人姓名
     */
    public void setCrtName(String crtName) {
        this.crtName = crtName;
    }

    /**
     * 获取创建主机
     *
     * @return crt_host - 创建主机
     */
    public String getCrtHost() {
        return crtHost;
    }

    /**
     * 设置创建主机
     *
     * @param crtHost 创建主机
     */
    public void setCrtHost(String crtHost) {
        this.crtHost = crtHost;
    }

    /**
     * 获取更新时间
     *
     * @return upd_time - 更新时间
     */
    public Date getUpdTime() {
        return updTime;
    }

    /**
     * 设置更新时间
     *
     * @param updTime 更新时间
     */
    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    /**
     * 获取更新人
     *
     * @return upd_user - 更新人
     */
    public String getUpdUser() {
        return updUser;
    }

    /**
     * 设置更新人
     *
     * @param updUser 更新人
     */
    public void setUpdUser(String updUser) {
        this.updUser = updUser;
    }

    /**
     * 获取更新姓名
     *
     * @return upd_name - 更新姓名
     */
    public String getUpdName() {
        return updName;
    }

    /**
     * 设置更新姓名
     *
     * @param updName 更新姓名
     */
    public void setUpdName(String updName) {
        this.updName = updName;
    }

    /**
     * 获取更新主机
     *
     * @return upd_host - 更新主机
     */
    public String getUpdHost() {
        return updHost;
    }

    /**
     * 设置更新主机
     *
     * @param updHost 更新主机
     */
    public void setUpdHost(String updHost) {
        this.updHost = updHost;
    }

    /**
     * @return attr1
     */
    public String getAttr1() {
        return attr1;
    }

    /**
     * @param attr1
     */
    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    /**
     * @return attr2
     */
    public String getAttr2() {
        return attr2;
    }

    /**
     * @param attr2
     */
    public void setAttr2(String attr2) {
        this.attr2 = attr2;
    }

    /**
     * @return attr3
     */
    public String getAttr3() {
        return attr3;
    }

    /**
     * @param attr3
     */
    public void setAttr3(String attr3) {
        this.attr3 = attr3;
    }

    /**
     * @return attr4
     */
    public String getAttr4() {
        return attr4;
    }

    /**
     * @param attr4
     */
    public void setAttr4(String attr4) {
        this.attr4 = attr4;
    }

    /**
     * @return attr5
     */
    public String getAttr5() {
        return attr5;
    }

    /**
     * @param attr5
     */
    public void setAttr5(String attr5) {
        this.attr5 = attr5;
    }

    /**
     * @return attr6
     */
    public String getAttr6() {
        return attr6;
    }

    /**
     * @param attr6
     */
    public void setAttr6(String attr6) {
        this.attr6 = attr6;
    }

    /**
     * @return attr7
     */
    public String getAttr7() {
        return attr7;
    }

    /**
     * @param attr7
     */
    public void setAttr7(String attr7) {
        this.attr7 = attr7;
    }

    /**
     * @return attr8
     */
    public String getAttr8() {
        return attr8;
    }

    /**
     * @param attr8
     */
    public void setAttr8(String attr8) {
        this.attr8 = attr8;
    }
}