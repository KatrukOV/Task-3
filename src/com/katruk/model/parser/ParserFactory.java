package com.katruk.model.parser;

public class ParserFactory {

  /**
   * this single factory
   */
  private static ParserFactory parserFactory = new ParserFactory();

  /**
   * hidden constructor
   */
  private ParserFactory() {
  }

  /**
   * for get single ParserFactory
   *
   * @return ParserFactory
   */
  public static ParserFactory getInstance() {
    return parserFactory;
  }

  /**
   * create different type of parser
   *
   * @param type type of parser
   * @return one of parser
   */
  public Parser create(ParserType type) {
    Parser result = null;
    switch (type) {
      case DOMParser: {
        result = new DOMParser(ParserType.DOMParser.toString());
        break;
      }
      case SAXParser: {
        result = new SAXParser(ParserType.SAXParser.toString());
        break;
      }
      case StAXParser: {
        result = new StAXParser(ParserType.StAXParser.toString());
        break;
      }
    }
    return result;
  }
}
