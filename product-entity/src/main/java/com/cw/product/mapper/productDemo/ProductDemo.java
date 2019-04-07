package com.cw.product.mapper.productDemo;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 
 * 产品Demo实体
 * 
 * @version 
 * <pre>
 * Author	Version		Date		Changes
 * Administrator 	1.0  2019年04月07日 Created
 *
 * </pre>
 * @since 1.
 */
public class ProductDemo implements Serializable {
    private static final long serialVersionUID = 1196186561245178L;
    
    /***/
    private String id;
    /***/
    private String name;
    /***/
    private String sex;
    /***/
    private String phone;
    /***/
    private String address;
    /***/
    private String bz;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getBz() {
        return bz;
    }
    public void setBz(String bz) {
        this.bz = bz;
    }



    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}