package com.katruk.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Device" type="{http://katruk.com.task3/devices}Device"
 * maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "device"
})
@XmlRootElement(name = "Devices", namespace = "http://katruk.com.task3/devices")
public class Devices {

  @XmlElement(name = "Device", namespace = "http://katruk.com.task3/devices", required = true)
  protected List<Device> device;

  /**
   * Gets the value of the device property.
   *
   * <p>
   * This accessor method returns a reference to the live list,
   * not a snapshot. Therefore any modification you make to the
   * returned list will be present inside the JAXB object.
   * This is why there is not a <CODE>set</CODE> method for the device property.
   *
   * <p>
   * For example, to add a new item, do as follows:
   * <pre>
   *    getDevice().add(newItem);
   * </pre>
   *
   *
   * <p>
   * Objects of the following type(s) are allowed in the list
   * {@link Device }
   */
  public List<Device> getDevice() {
    if (device == null) {
      device = new ArrayList<Device>();
    }
    return this.device;
  }

  public void setDevice(List<Device> device) {
    this.device = device;
  }
}
