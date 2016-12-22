package com.katruk.controller;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ControllerFile {

  /**
   * read from file
   *
   * @param path         path to file
   * @param encodingText text Encoding
   * @return text
   */
  public String readFile(String path, EncodingText encodingText) throws IOException {
    InputStreamReader
        inputStream =
        new InputStreamReader(new FileInputStream(path), encodingText.toString());
    StringBuilder string = new StringBuilder();
    int data = inputStream.read();
    char content;

    while (data != -1) {
      content = (char) data;
      string.append(content);
      data = inputStream.read();
    }
    inputStream.close();
    return string.toString();
  }

  /**
   * write to file
   *
   * @param path         path to file
   * @param encodingText text Encoding
   * @param string       text
   */
  public void writeFile(String path, EncodingText encodingText, String string) throws IOException {
    BufferedWriter
        out =
        new BufferedWriter(
            new OutputStreamWriter(new FileOutputStream(path), encodingText.toString()));
    out.append(string);
    out.close();
  }
}
