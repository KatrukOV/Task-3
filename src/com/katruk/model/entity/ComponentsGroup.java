package com.katruk.model.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for ComponentsGroup.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ComponentsGroup">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="I/O"/>
 *     &lt;enumeration value="MULTIMEDIA"/>
 *     &lt;enumeration value="SOUND"/>
 *     &lt;enumeration value="VIDEO"/>
 *     &lt;enumeration value="PRINTER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "ComponentsGroup", namespace = "http://katruk.com.task3/devices")
@XmlEnum
public enum ComponentsGroup {

  @XmlEnumValue("I/O")
  I_O("I/O"),
  MULTIMEDIA("MULTIMEDIA"),
  SOUND("SOUND"),
  VIDEO("VIDEO"),
  PRINTER("PRINTER");

  private final String value;

  ComponentsGroup(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static ComponentsGroup fromValue(String v) {
    for (ComponentsGroup c : ComponentsGroup.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }

}
