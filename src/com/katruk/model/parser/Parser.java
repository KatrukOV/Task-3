package com.katruk.model.parser;

import com.katruk.model.entity.Devices;

public interface Parser {

  /**
   * name of parser
   *
   * @return name
   */
  public String name();

  /**
   * parse XML
   *
   * @param fileName name of file
   * @return devices
   */
  public Devices parse(String fileName);

  /**
   * create XML
   *
   * @param fileName name of file
   * @param devices  devices
   */
  public void createXML(String fileName, Devices devices);
}
