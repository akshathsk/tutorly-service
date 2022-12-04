package com.uiuc.fp.util;

public class UtilHelper {

  public static Double roundDecimalPlaces(Double value, int places) {

    if(value.isNaN()) {
      return 0D;
    }

    double scale = Math.pow(10, places);
    return Math.round(value * scale) / scale;

  }

}
