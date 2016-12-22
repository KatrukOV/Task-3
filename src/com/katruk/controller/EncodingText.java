package com.katruk.controller;

public enum EncodingText {
  CP1251,
  Utf8;

  @Override
  public String toString() {
    return name();
  }
}
