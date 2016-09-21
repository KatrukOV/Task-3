
package com.katruk.model.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Port.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Port">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="COM"/>
 *     &lt;enumeration value="USB"/>
 *     &lt;enumeration value="LPT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Port", namespace = "http://katruk.com.task3/devices")
@XmlEnum
public enum Port {
    COM,
    USB,
    LPT;

    public String value() {
        return name();
    }

    public static Port fromValue(String v) {
        return valueOf(v);
    }

}
