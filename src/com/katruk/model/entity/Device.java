package com.katruk.model.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Device complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Device">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Origin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Price" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="ComponentsGroup" type="{http://katruk.com.task3/devices}ComponentsGroup"/>
 *         &lt;element name="Options">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Peripherals" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;element name="EnergyConsumption">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *                         &lt;pattern value="[0-9]{1,4}"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="PresenceCooler" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                   &lt;element name="Ports" type="{http://katruk.com.task3/devices}Port"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Critical" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;pattern value="[0-9]{1,10}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Device", namespace = "http://katruk.com.task3/devices", propOrder = {
    "name",
    "origin",
    "price",
    "componentsGroup",
    "options",
    "critical"
})
public class Device {

  @XmlElement(name = "Name", namespace = "http://katruk.com.task3/devices", required = true)
  protected String name;
  @XmlElement(name = "Origin", namespace = "http://katruk.com.task3/devices", required = true)
  protected String origin;
  @XmlElement(name = "Price", namespace = "http://katruk.com.task3/devices")
  protected double price;
  @XmlElement(name = "ComponentsGroup", namespace = "http://katruk.com.task3/devices", required = true)
  protected ComponentsGroup componentsGroup;
  @XmlElement(name = "Options", namespace = "http://katruk.com.task3/devices", required = true)
  protected Device.Options options;
  @XmlElement(name = "Critical", namespace = "http://katruk.com.task3/devices")
  protected boolean critical;
  @XmlAttribute(name = "id")
  protected Integer id;

  @Override
  public String toString() {
    return "    Device{" +
           "name='" + name + '\'' +
           ", origin='" + origin + '\'' +
           ", price=" + price +
           ", componentsGroup=" + componentsGroup +
           ",\n        options=" + options +
           ", critical=" + critical +
           ", id=" + id +
           '}';
  }

  /**
   * Gets the value of the name property.
   *
   * @return possible object is {@link String }
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the value of the name property.
   *
   * @param value allowed object is {@link String }
   */
  public void setName(String value) {
    this.name = value;
  }

  /**
   * Gets the value of the origin property.
   *
   * @return possible object is {@link String }
   */
  public String getOrigin() {
    return origin;
  }

  /**
   * Sets the value of the origin property.
   *
   * @param value allowed object is {@link String }
   */
  public void setOrigin(String value) {
    this.origin = value;
  }

  /**
   * Gets the value of the price property.
   */
  public double getPrice() {
    return price;
  }

  /**
   * Sets the value of the price property.
   */
  public void setPrice(double value) {
    this.price = value;
  }

  /**
   * Gets the value of the componentsGroup property.
   *
   * @return possible object is {@link ComponentsGroup }
   */
  public ComponentsGroup getComponentsGroup() {
    return componentsGroup;
  }

  /**
   * Sets the value of the componentsGroup property.
   *
   * @param value allowed object is {@link ComponentsGroup }
   */
  public void setComponentsGroup(ComponentsGroup value) {
    this.componentsGroup = value;
  }

  /**
   * Gets the value of the options property.
   *
   * @return possible object is {@link Device.Options }
   */
  public Device.Options getOptions() {
    return options;
  }

  /**
   * Sets the value of the options property.
   *
   * @param value allowed object is {@link Device.Options }
   */
  public void setOptions(Device.Options value) {
    this.options = value;
  }

  /**
   * Gets the value of the critical property.
   */
  public boolean isCritical() {
    return critical;
  }

  /**
   * Sets the value of the critical property.
   */
  public void setCritical(boolean value) {
    this.critical = value;
  }

  /**
   * Gets the value of the id property.
   *
   * @return possible object is {@link Integer }
   */
  public Integer getId() {
    return id;
  }

  /**
   * Sets the value of the id property.
   *
   * @param value allowed object is {@link Integer }
   */
  public void setId(Integer value) {
    this.id = value;
  }


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
   *         &lt;element name="Peripherals" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
   *         &lt;element name="EnergyConsumption">
   *           &lt;simpleType>
   *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
   *               &lt;pattern value="[0-9]{1,4}"/>
   *             &lt;/restriction>
   *           &lt;/simpleType>
   *         &lt;/element>
   *         &lt;element name="PresenceCooler" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
   *         &lt;element name="Ports" type="{http://katruk.com.task3/devices}Port"/>
   *       &lt;/sequence>
   *     &lt;/restriction>
   *   &lt;/complexContent>
   * &lt;/complexType>
   * </pre>
   */
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(name = "", propOrder = {
      "peripherals",
      "energyConsumption",
      "presenceCooler",
      "ports"
  })
  public static class Options {

    @XmlElement(name = "Peripherals", namespace = "http://katruk.com.task3/devices")
    protected boolean peripherals;
    @XmlElement(name = "EnergyConsumption", namespace = "http://katruk.com.task3/devices")
    protected int energyConsumption;
    @XmlElement(name = "PresenceCooler", namespace = "http://katruk.com.task3/devices")
    protected boolean presenceCooler;
    @XmlElement(name = "Ports", namespace = "http://katruk.com.task3/devices", required = true)
    protected Port ports;

    @Override
    public String toString() {
      return "Options{" +
             "peripherals=" + peripherals +
             ", energyConsumption=" + energyConsumption +
             ", presenceCooler=" + presenceCooler +
             ", ports=" + ports +
             '}';
    }

    /**
     * Gets the value of the peripherals property.
     */
    public boolean isPeripherals() {
      return peripherals;
    }

    /**
     * Sets the value of the peripherals property.
     */
    public void setPeripherals(boolean value) {
      this.peripherals = value;
    }

    /**
     * Gets the value of the energyConsumption property.
     */
    public int getEnergyConsumption() {
      return energyConsumption;
    }

    /**
     * Sets the value of the energyConsumption property.
     */
    public void setEnergyConsumption(int value) {
      this.energyConsumption = value;
    }

    /**
     * Gets the value of the presenceCooler property.
     */
    public boolean isPresenceCooler() {
      return presenceCooler;
    }

    /**
     * Sets the value of the presenceCooler property.
     */
    public void setPresenceCooler(boolean value) {
      this.presenceCooler = value;
    }

    /**
     * Gets the value of the ports property.
     *
     * @return possible object is {@link Port }
     */
    public Port getPorts() {
      return ports;
    }

    /**
     * Sets the value of the ports property.
     *
     * @param value allowed object is {@link Port }
     */
    public void setPorts(Port value) {
      this.ports = value;
    }

  }

}
